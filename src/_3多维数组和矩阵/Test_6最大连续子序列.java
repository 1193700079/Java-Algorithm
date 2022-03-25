package _3多维数组和矩阵;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-17 19:15
 **/
public class Test_6最大连续子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int[] res = findByDp(arr);
        System.out.println(res[0]+" "+arr[res[1]]+"~"+arr[res[2]]);
    }

    public static int[] findByDp(int[] arr){
        int sumMax=arr[0];//最终最大和
        int sum=arr[0]; //当前和
        int left = 0; //左指针
        int right = 0; //右指针
        //考虑了下一个状态
        for (int i = 1; i < arr.length; i++) {
            if(sum>=0){
                //保留
                sum+=arr[i];
            }else {
                //舍弃
                sum=arr[i];
                left=i;
            }
            //如果超过就更新
            if(sum>sumMax){
                sumMax = sum;
                right=i;
            }
        }
        return new int[]{sumMax,left,right};
    }

}
