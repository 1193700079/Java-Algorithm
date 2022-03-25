package _3多维数组和矩阵;



import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-17 20:03
 **/
public class Test_7子矩阵最大累加和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] arr = new long[n][m];
        boolean flag = false;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j]>0) flag = true;
                max = Math.max(max,arr[i][j]);
            }
        }
        if(flag){
            long res = cumulativeSum(arr);
            System.out.println(res);
        }else{
            System.out.println(max);
        }

    }

    private static long cumulativeSum(long[][] arr) {
        int beginRow = 0;//起始行
        long[] sumj=new long[arr[0].length*2]; //记录每一列的值
        Arrays.fill(sumj,0);
        long sumMax = 0;  //历史最大累加和
        while (beginRow<arr.length){
            for (int i = beginRow; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    sumj[j]+=arr[i][j];  //这个写法很巧啊 表达的就是
                }
                for (int j = arr[0].length; j<arr[0].length*2; j++) {
                    sumj[j]=sumj[j-arr[0].length];  //这个写法很巧啊 表达的就是
                }
                long t  = findByDp(sumj); //求的每一列的和 利用了一维数组求最大连续累加和
                if(t>sumMax){
                    sumMax = t;
                }
            }
            Arrays.fill(sumj,0);
            beginRow++;
        }
        return sumMax;
    }

    public static long findByDp(long[] arr){
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
        return sumMax;
    }

}

