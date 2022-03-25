package 练习_LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-19 17:19
 **/
public class _198抢银行 {
    static int[] a;
    static int[] rec;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        rec = new int[n];
        dp = new int[n];
        Arrays.fill(rec,-1);
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(rob(a));
        System.out.println(DP(a));
    }
    public static int rob(int[] nums) {
        return slove(nums.length-1,nums);
    }

    private static int slove(int idx, int[] nums) {
        if(idx<0){
            return 0;
        }
        if(rec[idx]>=0){
            return rec[idx];
        }
        int v1 = nums[idx]+slove(idx-2,nums);  //有两种决策  算是暴力解法！
        int v2 = slove(idx-1,nums);
        rec[idx] = v1>v2?v1:v2;
        return rec[idx];
    }


    private static int DP(int[] nums){
        if(nums.length==0){
            return 0;
    }else if(nums.length==1){
        return nums[0];
    }else if(nums.length==2){
        return Math.max(nums[0],nums[1]);
    }
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
        dp[i]= Math.max(dp[i-2]+nums[i],dp[i-1]);
    }
        return dp[nums.length-1];
    }
    private static int DP2(int[] nums){
        if(nums.length==0){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int a = nums[0];
        int b = Math.max(nums[0],nums[1]);
        int ans = 0;
        for (int i = 2; i < nums.length; i++) {
            ans = Math.max(a+nums[i],b);
            a = b;
            b = ans;
        }
        return ans;
    }
}
