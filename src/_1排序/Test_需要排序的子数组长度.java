package _1排序;

import _1_recursion.Utils;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-16 16:26
 **/
public class Test_需要排序的子数组长度 {
    public static void main(String[] args) {
        int[] arr = Utils.createRandomArrayNotRepetition(6,1,6);
        Utils.printArrays(arr);
        int[] result = findSegment(arr);
        System.out.println("按照升序"+Arrays.toString(result));

        int[] result2 = findSegment2(arr);
        System.out.println("按照降序"+Arrays.toString(result2));

        int a = result[1]-result[0];
        int b = result2[1]-result2[0];
        System.out.println("最优解是：");
        if(a<=b){
            System.out.println(Arrays.toString(result));
        }else {
            System.out.println(Arrays.toString(result2));
        }
    }
    private static int[] findSegment(int[] arr){
        int p1=-1;
        int p2=-1;
        int max=arr[0];
        int min=arr[arr.length-1];
        for (int i = 0; i < arr.length; i++) {
            if(max<=arr[i]){
                max=arr[i];
            }else {
                p2=i; //更新右边界
            }
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            if(min>=arr[i]){
                min=arr[i];
            }else {
                p1=i; //更新左边界
            }
        }
        if(p2==-1){
            return new int[]{0,0};
        }
        return new int[]{p1,p2};
    }

    /**
     * 按照降序分析
     * 往右边扫的时候找最小值 定
     * @param arr
     * @return
     */
    private static int[] findSegment2(int[] arr){
        int p1=-1;
        int p2=-1;
        int min=arr[0];
        int max=arr[arr.length-1];
        for (int i = 0; i < arr.length; i++) {
            if(min>=arr[i]){
                min=arr[i];
            }else {
                p2=i; //更新右边界
            }
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            if(max<=arr[i]){
                max=arr[i];
            }else {
                p1=i; //更新左边界
            }
        }
        if(p2==-1){
            return new int[]{0,0};
        }
        return new int[]{p1,p2};
    }
}
