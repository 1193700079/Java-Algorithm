package _1_recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-16 11:12
 **/
public class _7基数排序 {

    //初始化链表 这是一个二维的
    private static ArrayList[] bucket = new ArrayList[10];

    static {
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList();
        }
    }
    public static void main(String[] args) {
        int[] arr = Utils.createRandomArrayNotRepetition(10,100,1000);
        Utils.printArrays(arr);
        //入桶位数的初始化
        int d = 1;
        //最大元素
        int max = Utils.arrOfMax(arr);
        //求最大元素的位数
        int dMax=0;
        while (max!=0){
            dMax++;
            max/=10;
        }
        while (d<=dMax){
            sort(arr,d++);
        }
        Utils.printArrays(arr);
    }

    private static void sort(int[] arr, int digit) {
        //入桶
        for (int i = 0; i < arr.length; i++) {
            //根据每一个位进行存放
            putInBucket(arr[i],getDigit(arr[i],digit));
        }
        //出桶
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (Object m:bucket[i]) {
                arr[index++] = (Integer)m;
            }
        }
        clearAll();

    }

    private static void clearAll() {
        for (ArrayList arrayList:bucket){
            arrayList.clear();
        }
    }

    /**
     * 得到这个数第d位 如得到123的第二位 就是返回2
     * @param data
     * @param digit
     * @return
     */
    private static int getDigit(int data, int digit) {
       if(digit<=0){
           System.out.println("位数错误");
       }
        String str = String.valueOf(data); //转化成字符串
        char[] c = str.toCharArray();
        String result = c[str.length()-digit]+"";
        int res = Integer.parseInt(result);
        return res;
    }

    /**
     * 入桶
     * @param data
     * @param digit
     */
    private static void putInBucket(int data, int digit) {
        bucket[digit].add(data);
    }
}
