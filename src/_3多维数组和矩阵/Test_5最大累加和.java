package _3多维数组和矩阵;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description: 可以枚举法暴力破解 不过时间复杂度很高 也可以DP？？
 * 单向扫描求和 max为负数就立刻舍弃 重新开始 正数的话就保留
 * @author: yrq
 * @create: 2020-01-17 18:53
 **/
public class Test_5最大累加和 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long[] arr = new long[(int)n];
        boolean flag = false;
        long max = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
            if(arr[i]>0) flag = true;
            max = Math.max(max,arr[i]);
        }
        if(flag){
            long[] res = findByDp(arr);
            System.out.println(res[0]);
        }else{
            System.out.println(max);
        }
    }

    public static long[] findByDp(long[] arr){
        long sumMax=0;//最终最大和
        long sum=0; //当前和
        int left = 0; //左指针
        int right = 0; //右指针
        boolean flag = true;//判断是不是第一次保留
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]+sum>=0){
                //是第一次保留的话
                if(flag){
                    left=i;
                    flag=false;
                }
                //保留
                sum+=arr[i];
            }else {
                //舍弃
                sum=0;
                if(!flag){
                    flag=true;
                }
            }
            //如果超过就更新
            if(sum>sumMax){
                sumMax = sum;
                right=i;
            }
        }
        return new long[]{sumMax,left,right};
    }

}
