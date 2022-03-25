package _5DP动态规划;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-18 09:39
 **/
public class Test_6_斐波那契 {
    static long[] rec;
    public static void main(String[] args) {
        rec = new long[101];
        Arrays.fill(rec,-1);
        long ans = fun(100);
        System.out.println(ans);
    }

    private static long fun(int i) {
        if(i<=0) return 0;
        if(i==1 || i==2) return 1;
        if(i==3) return 2;
        if(rec[i]>=0){
            return rec[i];
        }
        long ans = fun(i-1)+fun(i-2);
        rec[i] =ans;
        return ans;
    }
}
