package 专题系列一背包九讲;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-23 09:45
 **/
public class _2_完全背包 {
    static int N =15000;
    static int[] w = new int[N+1];
    static int[] v = new int[N+1];
    static int[] f = new int[N+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = w[i]; j<= k ; j++) {  //正序输出
                f[j] = Math.max(f[j],f[j-w[i]]+v[i]);
            }
        }
        System.out.println(f[k]);
    }
}
//public class _41完全背包 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] w = new int[n];
//        int[] v = new int[n];
//        for (int i = 0; i < n; i++) {
//            w[i] = sc.nextInt();
//            v[i] = sc.nextInt();
//        }
//        int[][] dp = new int[n][k+1];
//        for (int i = 0; i < n; i++) {
//            dp[i][0] = 0;
//        }
//        for (int j = 1; j < k+1; j++) {
//            if(j<w[0]){
//                dp[0][j] = 0;
//            }
//            dp[0][j] = (j/w[0])*v[0];
//        }
//        for (int i = 1; i < dp.length ; i++) {
//            for (int j = 1; j < dp[0].length; j++) {
//                if(j>=w[i]){
//                    //能选的话
//                    dp[i][j] = Math.max(dp[i][j-w[i]]+v[i],dp[i-1][j]);
//                }else {
//                    dp[i][j] = dp[i-1][j];
//                }
//
//            }
//        }
//        System.out.println(dp[n-1][k]);
//    }
//}
