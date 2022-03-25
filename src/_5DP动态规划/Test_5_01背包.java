package _5DP动态规划;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-18 09:16
 **/
public class Test_5_01背包 {
    static int[] w=new int[]{2,1,3,2};
    static int[] v=new int[]{3,2,4,2};
    static int n = 4;
    static int W = 5;
    static int[][] rec=new int[n][W+1];
    static int[][] dp = new int[n][W+1];
    public static void main(String[] args) {
        int ww = W;
        int ans = dfs(0,ww);
        System.out.println(ans);

        for (int i = 0; i < rec.length; i++) {
            Arrays.fill(rec[i],-1);
        }
        int ans2 = m(0,ww);
        System.out.println(ans2);

        int ans3 = dP();
        System.out.println(ans3);
    }

    /**
     * dp表 不断计算 不需要使用递归了
     * @return
     */
    private static int dP() {
        //先填满第一行
        for (int i = 0; i < W+1; i++) {
            if(i>=w[0]){
                dp[0][i] = v[0];
            }else {
                dp[0][i] = 0;
            }
        }
        //依次填后面的行
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < W+1; j++) {
                if(j>=w[i]){
                    int v1 = v[i]+dp[i-1][j-w[i]];  //选
                    int v2 = dp[i-1][j];  //不选
                    dp[i][j] = Math.max(v1,v2);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][W];
    }

    /**
     * 备忘录法 计算之前查询数据
     * @param i
     * @param ww
     * @return
     */
    private static int m(int i, int ww) {
        //递归出口
        if(ww<=0) return 0;  //表示已经装满了
        if(i==n) return 0;   //表示没有物体可以选了
        //查询
        if(rec[i][ww]>=0){
            return rec[i][ww];
        }
        //不选
        int v2 = m(i+1,ww);
        int ans;
        //选
        if(ww>=w[i]){
            int v1 = v[i]+m(i+1,ww-w[i]);
            ans = Math.max(v1,v2);
        }else {
            ans = v2;
        }
        //保存 做纪录
        rec[i][ww] = ans;
        return ans;
    }

    /**
     * 具有重叠子问题  效率低 复杂度为 2^n
     * @param i
     * @param ww
     * @return
     */
    private static int dfs(int i, int ww) {
        //递归出口
        if(ww<=0) return 0;  //表示已经装满了
        if(i==n) return 0;   //表示没有物体可以选了
        //不选
        int v2 = dfs(i+1,ww);
        //选
        if(ww>=w[i]){
            int v1 = v[i]+dfs(i+1,ww-w[i]);
            return Math.max(v1,v2);
        }else {
            return v2;
        }

    }
}
