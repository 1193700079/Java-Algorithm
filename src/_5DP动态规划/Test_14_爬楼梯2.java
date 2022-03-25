package _5DP动态规划;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description: 可以奇数次跳跃
 * @author: yrq
 * @create: 2020-02-18 19:46
 **/
public class Test_14_爬楼梯2 {
    static long[] rec;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        rec = new long[n+1];
        Arrays.fill(rec,-1);
        long ans = Dp(n-1);
        System.out.println(ans%100007);
        long ans2 = Dp2(n);
        System.out.println(ans2%100007);
    }

    private static long Dp(int n) {
        long ans = 0;
        if(n==1||n==0){
            return 1L;
        }else if (n==2){
            return 2L;
        }else {
            if(rec[n]>=0){
                return rec[n]%100007;
            }
            ans =Dp(n-1)+Dp(n-2);
            rec[n] =ans;
            return ans%100007;
        }
    }

    private static long Dp2(int n) {
        if(n==1||n==0){
            return 1L;
        }else if (n==2){
            return 2L;
        }else {
            long a=1;
            long b=2;
            long temp=0;
            for (int i = 3; i <=n ; i++) {
                temp = a+b;
                a=b%100007;
                b=temp%100007;
            }
            return temp%100007;
        }
    }
}
