package 专题系列一背包九讲;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-23 21:22
 **/
public class _7_求方案数的背包 {
    static int N =15000;
    static final int mod = 1000000007;
    static int[] w = new int[N+1];
    static int[] v = new int[N+1];
    static int[] f = new int[N+1];
    static int[] g = new int[N+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        g[0] = 1;  //表示在背包容量为0的情况下的方案总数
        for (int i = 1; i < n ; i++) f[i]=-1;  //把f[0]==0  这样就能保证状态转移方程从0开始！
        for (int i = 0; i < n ; i++) {
            for (int j = k; j>= w[i] ; j--) {   //01背包倒序  根据 状态方程 对于i而言只有两层没有必要全部记录下来
                int t = Math.max(f[j],f[j-w[i]]+v[i]);  //因为肯定是从状态f[0] 转移过来的
                int s = 0;   //s为方案数
                if(t==f[j]) s+=g[j];    //有三种情况就是 1大或者2大或者都一样大 都++
                if(t==f[j-w[i]]+v[i]) s+=g[j-w[i]];
                if(s>mod) s-=mod;  //这样求模算法效率更高
                f[j] = t;
                g[j] = s;

            }
        }
        int res = 0;
        int MaxV = 0;
        for (int j = 0; j <= k ; j++) MaxV = Math.max(MaxV,f[j]); //由于状态方程是从0开始的 所以f[k]不是唯一的最大价值
        //比如 f[10]=300 背包容量为10的情况下求出的最大价值  不一定背包就要装满！！
        //比如 f[8]=300 背包容量为8的情况下求出的最大价值
        for (int j = 0; j <= k  ; j++){
            if(MaxV ==f[j]){
                res+=g[j];
                if(res>mod) res-=mod;
            }
        }

        System.out.println(res);
    }
}
