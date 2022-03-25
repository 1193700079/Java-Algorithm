package _5DP动态规划;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-18 16:34
 **/
public class Test_12_LCS编辑距离 {
    static int[][] dp;
    static int n; //列数
    static int m;  //行数
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        n= s1.length();
        m= s2.length();
        dp=new int[m+1][n+1];
        ans = DP(s1,s2);
        System.out.println(ans);
    }

    private static int DP(String s1, String s2) {
        for (int i = 0; i <= n ; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(j-1)==s2.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    int v1 =dp[i-1][j]+1;
                    int v2 =dp[i][j-1]+1;
                    dp[i][j] = Math.min(dp[i-1][j-1]+1,Math.min(v1,v2));
                }
            }
        }
        return dp[m][n];
    }
}

