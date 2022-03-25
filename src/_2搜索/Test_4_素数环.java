package _2搜索;

import _1_recursion.Utils;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-09 21:58
 **/
public class Test_4_素数环 {
    static int n=8;
    static int cnt;
    public static void main(String[] args) {
        int[] arr=  new int[n];
        Arrays.fill(arr,0);
        arr[0]=1;
        dfs(arr,1);
        System.out.println(cnt);
    }

    private static void dfs(int[] arr, int i) {
        if(arr.length==i && isPrime(arr[n-1]+arr[0])){
            cnt++;
            Utils.printArrays(arr);
            return;
        }
        for (int j = 2; j <= n; j++) {
            if(check(arr,i,j)){
                arr[i]=j;
                dfs(arr,i+1);
                arr[i]=0;
            }
        }
    }

    private static boolean check(int[] arr, int i, int j) {
        for (int a:arr) {
            if(a==j || !isPrime(j+arr[i-1])) return false;

        }
        return true;

    }
    private static boolean isPrime(int i) {
        //0和1既不是质数、也不是合数。2是质数
        if(i==1||i==2){
            return true;
        }
        for (int j = 2; j < i/2; j++) {
            if(i%j==0){
                return false;
            }
        }
        return true;
    }

}
