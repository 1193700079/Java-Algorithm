package _5DP动态规划;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-18 10:24
 **/
public class Test_7_数字三角形 {
    static int[][] dp;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        dp=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = DP2(arr);
        System.out.println(ans);
    }

    private static int DP(int[][] arr) {
        //填最后一行
        int ColCount = arr[n-1].length; //最后一行的列数
        for (int i = 0; i < ColCount; i++) {
            dp[ColCount-1][i]=arr[ColCount-1][i];
        }
        //依次填写
        for (int i = ColCount-2; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j]=arr[i][j]+Math.max(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

    /**
     * 利用滚动数组
     * @param arr
     * @return
     */
    private static int DP2(int[][] arr) {
        //填最后一行
        int lastRow = arr[n-1].length;
        int[] state = new  int[lastRow];
        for (int i = 0; i < lastRow; i++) {
            state[i]=arr[lastRow-1][i];
        }
        //依次填写
        for (int i = lastRow-2; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
               state[j]=arr[i][j]+Math.max(state[j],state[j+1]);
            }
        }
        return state[0];
    }

}
