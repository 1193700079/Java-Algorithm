package _1排序;

import _1_recursion.Utils;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-16 14:44
 **/
public class _3堆排序 {
    public static void main(String[] args) {
        int[] arr = Utils.createRandomArrayNotRepetition(7,1,15);
        Utils.printArrays(arr);

        int n =arr.length;
        //对数组进行堆化  变成了最小堆
        minHeap(arr);
        //从最后一个元素开始与第0元素进行交换  然后进行调整
        for (int i = n-1; i > 0 ; i--) {
            swap(arr,0,i);
            minHeapFixDowm(arr,0,i);
        }
        Utils.printArrays(arr);

        int[] arr2= Utils.createRandomArrayNotRepetition(7,1,15);
        System.out.println(Arrays.toString(arr2));
        maxHeap(arr2);
        System.out.println(Arrays.toString(arr2));
        for (int i = arr2.length-1; i > 0 ; i--) {
            swap(arr2,0,i);
            maxHeapFixDown(arr2,0,i);
        }
        System.out.println(Arrays.toString(arr2));

    }

    /**
     * 构建大顶堆
     * @param arr
     */
    private static void maxHeap(int[] arr){
        for (int i = arr.length/2-1; i >=0 ; i--) {
            maxHeapFixDown(arr,i,arr.length);
        }
    }

    /**
     * 最大堆 用于升序
     * @param arr  表示数组
     * @param i  表示数组当前的下标
     * @param length  表示数组的长度
     */
    private static void maxHeapFixDown(int[] arr, int i, int length) {
        int left = 2*i+1;
        int right = 2*i+2;
        if(left>=length){
            return;
        }
        int max = left;
        if(right>=length){

        }else {
            if(arr[left]<arr[right]){
                max = right;
            }
        }
        //得到了最大的那个
        if(arr[max]<=arr[i]){
            return;
        }
        swap(arr,max,i);
        maxHeapFixDown(arr,max,length);
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
