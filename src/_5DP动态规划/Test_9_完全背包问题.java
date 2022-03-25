package _5DP动态规划;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-18 15:21
 **/
public class Test_9_完全背包问题 {
    static int[] w=new int[]{2,1,3,2};
    static int[] v=new int[]{3,2,4,2};
    static int n = 4;
    static int W = 10;
    static int[][] dp = new int[n][W+1];
    public static void main(String[] args) {
        int ans = Dp();
        System.out.println(ans);
    }

    private static int Dp() {
        //填充第一行
        for (int i = 0; i < W+1; i++) {
            if(i<w[0]){
                dp[0][i] = 0;
            }else {
                int k = i/w[0];
                dp[0][i] = k*v[0];
            }
        }
        //填充第一列
        for (int i = 0; i < n; i++) {
            dp[i][0]=0;
        }
        //依次填充
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < W+1; j++) {
                dp[i][j]=Math.max(v[i]+dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n-1][W];
    }
}
