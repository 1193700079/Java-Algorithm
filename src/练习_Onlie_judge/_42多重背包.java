package 练习_Onlie_judge;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * 有 NN种物品和一个容量为 VV 的背包。第ii种物品的体积是 C_iC
 * i
 * ​
 *   ，得到的价值是 W_iW
 * i
 * ​
 *  ，以及它最多只能被取M_iM
 * i
 * ​
 *  件。求解将哪些物品装入背包可使价值总和最大。
 *
 * 输入
 * 第一行是两个整数NN和V(1<=N,V<=5000)V(1<=N,V<=5000)。
 *
 * 接下来NN行，每行有三个数C_iC
 * i
 * ​
 *  和W_iW
 * i
 * ​
 *  和M_i(0<=C_i,W_i,M_i<=5000)M
 * i
 * ​
 *  (0<=C
 * i
 * ​
 *  ,W
 * i
 * ​
 *  ,M
 * i
 * ​
 *  <=5000)，分别代表体积和价值和件数。
 *
 * 输出
 * 输出能得到的最大价值。
 *
 * 样例
 * 输入复制
 * 5 10
 * 1 5 1
 * 2 4 2
 * 3 3 3
 * 4 2 4
 * 5 1 5
 * 输出复制
 * 16
 * @author: yrq
 * @create: 2020-02-23 10:00
 **/
public class _42多重背包 {
    static int N =5002;
    static int[][] dp = new int[N][N];
    static int[] w = new int[N];
    static int[] v = new int[N];
    static int[] m = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
            m[i] = sc.nextInt();
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <= s ; j++) {
                for (int k = 0; k*w[i]<=j && k<=m[i]; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*w[i]]+k*v[i]);
                }
            }
        }
        System.out.println(dp[n][s]);
    }
}
