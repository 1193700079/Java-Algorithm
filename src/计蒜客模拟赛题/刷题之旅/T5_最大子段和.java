package 计蒜客模拟赛题.刷题之旅;

import _1_recursion.Utils;
import 数据结构之图.最小生成树.UnionFindSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:  最大的连续和
 * @author: yrq
 * @create: 2020-03-03 18:07
 **/
public class T5_最大子段和 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sn = br.readLine();
        long n  = Integer.parseInt(sn);
        long[] a =new long[(int)n];
        String sa = br.readLine();
        String[] sai = sa.split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sai[i]);
        }
        long ans = fun(a);
        System.out.println(ans);
    }

    private static long fun(long[] a) {
        long dp[] = new long[2];
        dp[0] = a[0];
        int n = a.length;
        for (int i = 1; i < a.length; i++) {
            dp[i%2] = Math.max(dp[(i-1)%2],dp[(i-1)%2]+a[i]);
        }
        return dp[(n-1)%2];
    }
}
