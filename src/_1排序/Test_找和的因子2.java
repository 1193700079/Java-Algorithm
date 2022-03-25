package _1排序;

import _1_recursion.Utils;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:  利用快排 双指针的思想！
 * @author: yrq
 * @create: 2020-01-16 15:26
 **/
public class Test_找和的因子2 {
    public static void main(String[] args) {
        int[] arr = Utils.createRandomArrayNotRepetition(10,1,10);
        Arrays.sort(arr);
        Utils.printArrays(arr);
        int k = 10;  //和
        twoPointScan(arr,0,arr.length-1,k);

    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param k  需要求和计算的值
     */
    private static void twoPointScan(int[] arr,int left,int right,int k){

        if(left>=right){
            return;
        }
        while (arr[left]+arr[right]<k&&left<right){
            left++;
        }
        if(arr[left]+arr[right]==k){
            //说明找到了
            System.out.println(arr[left]+","+arr[right]);
            twoPointScan(arr,++left,--right,k);
        }else {
            //说明没找到
            twoPointScan(arr,left,--right,k);
        }



    }


}
