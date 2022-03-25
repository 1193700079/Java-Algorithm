package _1排序;

import _1_recursion.Utils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:  利用小顶堆 每次把最小的数顶出去
 * @author: yrq
 * @create: 2020-01-16 17:10
 **/
public class Test_TopK {

    static int k;
    static int index=0;
    static int heap[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        heap = new int[k];
        int n = sc.nextInt();
        while (n!=-1){
            deal(n);
            printHeap();
            n = sc.nextInt();
        }

    }

    private static void printHeap(){
        System.out.println(Arrays.toString(heap));
    }
    private static void deal(int n) {
        if(index<k){
            heap[index++]=n;
            if(k==index){
                //1.进行堆化  那么最小的就是首元素
                minHeap(heap);
            }
        }else {
            if(n>heap[0]){
                heap[0]=n;
                //2.进行堆修整
                minHeapFixDowm(heap,0,k);
            }
        }
    }
    private static void minHeap(int[] arr) {
        int n = arr.length;
        for (int i = n/2-1; i >= 0 ; i--) {
            minHeapFixDowm(arr,i,n);
        }
    }

    private static void minHeapFixDowm(int[] arr, int i, int n) {
        //1.找左右孩子
        int left = 2*i+1;
        int right = 2*i+2;
        //2.判断边界
        if(left>=n){
            return;
        }
        int min = left;
        if (right>=n){
            //只存在左孩子
            min = left;
        }else {
            //两个孩子都存在
            if(arr[left]>arr[right]){
                min =right;
            }
        }

        //3.得到了最小的孩子  然后交换  递归调用
        if(arr[i]<=arr[min]){
            //说明已经是小顶堆了
            return;
        }

        swap(arr,i,min);
        //递归修整
        minHeapFixDowm(arr,min,n);

    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]=temp;
    }
}
