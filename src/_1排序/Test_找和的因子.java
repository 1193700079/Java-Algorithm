package _1排序;

import _1_recursion.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: lanqiaobei2020
 * @description:利用二分法 因为数组是有序的！！
 * @author: yrq
 * @create: 2020-01-16 15:02
 **/
public class Test_找和的因子 {
    public static void main(String[] args) {
        int[] arr = Utils.createRandomArrayNotRepetition(10,-8,8);
        Arrays.sort(arr);
        Utils.printArrays(arr);
        int k = 10;  //和

//        Map<Integer,Integer> resultMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int searchValue = k - arr[i];  //需要查找的值

            int res = binary_search(arr,i,arr.length-1,searchValue);
            if(res!=-1&&res!=i){   //查找的小标不能是本身
                //如果找到了
                System.out.println(arr[i]+","+arr[res]);
//                resultMap.put(arr[i],arr[res]);
            }else {
                continue;
            }
        }

//        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
    }

    /**
     * 二分查找
     * @param arr
     * @param left  左边界
     * @param right 右边界
     * @param data  需要查找的数
     * @return
     */
    private static int binary_search(int[] arr,int left,int right,int data){
        if(left>right){
            return -1;  //说明没有找到
        }
        int mid = left + ((right-left)>>1);
        if(data==arr[mid]){
            return mid;
        }
        if(data>arr[mid]){
            return binary_search(arr,mid+1,right,data);
        }else {
            return binary_search(arr,left,mid-1,data);
        }
    }
}
