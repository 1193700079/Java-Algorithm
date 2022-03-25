package 专题系列一背包九讲;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:  二进制法
 * 把物品全部拆开！！
 * @author: yrq
 * @create: 2020-02-23 13:34
 **/
public class _3_多重背包优化二进制 {
    //物品个数不在需要建立数组了
    static int N =15000;
    static int[][] dp = new int[N][N];
    static int[] w = new int[N+1];
    static int[] v = new int[N+1];
    static int[] f = new int[N+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ww,vv,s;
        int tot = 1;
        for (int i = 1; i <= n; i++) {
            ww = sc.nextInt();
            vv = sc.nextInt();
            s = sc.nextInt();  //表示个数
            for (int kk = 1; kk <= s ; kk<<=1) {
                w[tot] = ww*kk;
                v[tot++] = vv*kk;
                s-=kk;
            }
            if(s>0){
                w[tot] = ww*s;
                v[tot++] = vv*s;
            }
        }
        for (int i = 1; i <= tot ; i++) {
            for (int j = k; j >=w[i] ; j--) {
                f[j] = Math.max(f[j],f[j-w[i]]+v[i]);
            }
        }
        System.out.println(f[k]);
    }
}
