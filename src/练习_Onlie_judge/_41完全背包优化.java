package 练习_Onlie_judge;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description: 物品可以选无数个
 * @author: yrq
 * @create: 2020-02-23 13:34
 **/
public class _41完全背包优化 {

    static int n;
    static int k;
    static int[] w;
    static int[] v;
    static int[][] dp;
    static int[] f;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        w = new int[n+1];
        v = new int[n+1];
        dp = new int[n+1][k+1];
        f = new int[k+1];
        for (int i = 1; i <= n; i++) {
            w[i] =sc.nextInt();
            v[i] =sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 0; l*w[i] <= j ; l++) {  //能拿的个数   这样写也比较好理解 但是复杂度有点高
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-l*w[i]]+l*v[i]); //考虑了前i个物品 体积为j的最大价值
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= w[i]; j--) {   //等于是逆着打表  能省去一个空间复杂度
                for (int l = 0; l*w[i] <= j ; l++) {  //能拿的个数   这样写也比较好理解 但是复杂度有点高
                    f[j] = Math.max(f[j],f[j-l*w[i]]+l*v[i]);
                }
            }
        }
        System.out.println(dp[n][k]);
        System.out.println(f[k]);

    }
}
