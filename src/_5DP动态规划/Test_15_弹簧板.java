package _5DP动态规划;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-18 20:06
 **/
public class Test_15_弹簧板 {
    static  int[] dp = new int[1000000];
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = n-1; i >= 0 ; i--) {
            dp[i] = 1 + dp[i+arr[i]];
            res = Math.max(res,dp[i]);
        }
        System.out.println(res);
    }
}
