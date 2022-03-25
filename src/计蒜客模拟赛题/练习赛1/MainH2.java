package 计蒜客模拟赛题.练习赛1;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description: 考察对于哈希的理解
 * 复杂度太高写的 N^3 TLE了
 * @author: yrq
 * @create: 2020-01-18 13:46
 **/
public class MainH2 {
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s =sc.next();
        M = sc.nextInt();
        //得到26进制的数
        int[] a = fun(s);
        System.out.println(a[0]+" "+a[1]);
    }

    private static int[] fun(String s) {
        //拆分字符数组
        char[] c= s.toCharArray();
        long[] arr = new long[s.length()];
        for (int i = 0; i < c.length; i++) {
            arr[i]=(c[i]-'A');
        }
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res+=arr[i]*Math.pow(26,arr.length-1-i);
        }
        if(res%M==0){
            return new int[]{0,0};
        }
        //开始进行交换比较
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
//                swap(arr,i,j);
//                res = fun2(arr);
                res-=arr[i]*Math.pow(26,arr.length-1-i);
                res-=arr[j]*Math.pow(26,arr.length-1-j);
                res+=arr[i]*Math.pow(26,arr.length-1-j);
                res+=arr[j]*Math.pow(26,arr.length-1-i);
                if(res%M==0){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[]{-1,-1};
    }

    private static long fun2(long[] arr) {
        long res=0;
        for (int i = 0; i < arr.length; i++) {
            res+=arr[i]*Math.pow(26,arr.length-1-i);
        }
        return res;
    }

    public static void swap(long[] arr,int a,int b){
        long temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
