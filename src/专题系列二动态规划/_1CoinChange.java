package 专题系列二动态规划;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-04 20:04
 **/
public class _1CoinChange {
    public static void main(String[] args) {
        int k = 27;
        int[] dp = new int[k+1];  //表示凑配面值为k 的最小硬币数
        dp[0] = 0;
        for (int i = 1; i <=k  ; i++) {
            if(i==2||i==5||i==7){
                dp[i] = 1;
                continue;
            }
            if(i-2<0){
                dp[i] = 1000;
                continue;
            }
            if(i-5<0) {
                dp[i] = 100000;
                continue;
            }
            if(i-7<0) {
                dp[i] = Math.min(dp[i-2]+1,dp[i-5]+1);
                continue;
            }
            dp[i] = Math.min(dp[i-2]+1,Math.min(dp[i-5]+1,dp[i-7]+1));
        }
        System.out.println(dp[k]);
    }
}
