package _1_recursion;

/**
 * @program: lanqiaobei2020
 * @description: 练习
 * @author: yrq
 * @create: 2020-01-15 21:20
 **/
public class Main {
    public static void main(String[] args) {
        int[] arr = Utils.createRandomArrayNotRepetition(10,1,20);
        Utils.printArrays(arr);
        //1.堆化
        maxheap(arr);
        //2.将最后一个元素与第0元素交换 然后从第o个元素到第i个元素进行堆化
        for (int i = arr.length-1; i > 0 ; i--) {
            Utils.swap(arr,0,i);
            maxheapFixDown(arr,0,i);
        }
        Utils.printArrays(arr);
    }

    private static void maxheap(int[] arr) {
        for (int i = arr.length/2-1; i >=0; i--) {
            maxheapFixDown(arr,i,arr.length);
        }
    }

    private static void maxheapFixDown(int[] arr, int i, int length) {
        int left = 2*i+1;
        int right= left+1;
        if(left>=length){
            return;
        }
        int  max = left;
        if(right>=length){
        }else {
            if(arr[right]>arr[left]){
                max = right;
            }
        }
        if(arr[max]<=arr[i]){
            return;
        }
        Utils.swap(arr,max,i);
        maxheapFixDown(arr,max,length);

    }

}


