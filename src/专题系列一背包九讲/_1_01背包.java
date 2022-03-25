package 专题系列一背包九讲;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:  选或者不选
 * @author: yrq
 * @create: 2020-02-23 17:19
 **/
public class _1_01背包 {
    static int N =15000;
    static int[] w = new int[N+1];
    static int[] v = new int[N+1];
    static int[] f = new int[N+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = k; j>= w[i] ; j--) {   //倒序  根据 状态方程 对于i而言只有两层没有必要全部记录下来
                f[j] = Math.max(f[j],f[j-w[i]]+v[i]);  //因为肯定是从状态f[0] 转移过来的
            }
        }
        System.out.println(f[k]);  //f[k]表示 在总体积为k的情况下 背包的最大价值
    }
}
