package 专题系列一背包九讲;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-23 19:26
 **/
public class _6_分组背包 {
    static int N =1500;
    static int[] w = new int[N+1];
    static int[] v = new int[N+1];
    static int[] f = new int[N+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //组数
        int k = sc.nextInt();  //背包容量
        for (int i = 1; i <=n ; i++) {
            int s = sc.nextInt();  //组中的个数
            for (int l = 1; l <=s ; l++) {
                w[l] = sc.nextInt();
                v[l] = sc.nextInt();
            }
            for (int j = k; j >= 1 ; j--) {
                for (int l = 1; l <= s ; l++) {
                        if(j>=w[l])
                            f[j] = Math.max(f[j],f[j-w[l]]+v[l]);
                }
            }
        }
        System.out.println(f[k]);
    }
}
