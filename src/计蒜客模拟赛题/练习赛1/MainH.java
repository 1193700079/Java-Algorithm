package 计蒜客模拟赛题.练习赛1;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-18 13:46
 **/
public class MainH {
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
        int[] arr = new int[s.length()];
        for (int i = 0; i < c.length; i++) {
            arr[i]=(c[i]-65);
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res+=arr[i]*Math.pow(26,arr.length-1-i);
        }
        if(res%M==0){
            return new int[]{0,0};
        }
        //开始进行交换比较
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
            swap(arr,i,j);
            res = fun2(arr);
            if(res%M==0){
                return new int[]{i+1,j+1};
            }
        }
    }
        return new int[]{-1,-1};
    }

    private static int fun2(int[] arr) {
        int res=0;
        for (int i = 0; i < arr.length; i++) {
            res+=arr[i]*Math.pow(26,arr.length-1-i);
        }
        return res;
    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
