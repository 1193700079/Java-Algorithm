package 蓝桥杯模拟赛1;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:  DP + 前缀和优化 + 滚动数组
 * 65044
 * @author: yrq
 * @create: 2020-02-22 15:25
 **/
public class _I_美味糖果 {
    static int N =1000001;
    static final int mod = 998244353;
    static int[] m = new int[N+1];
    static int[][] dp = new int[2][N+1];
    static int[][] s = new int[2][N+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //物品种类
        int K = sc.nextInt();  //最多能带走的物品数量
        for (int i = 1; i <=n ; i++) {
            m[i] = sc.nextInt();  //物品种类的数量
        }
        dp[0][0]=1; //前0种物品 取0包的方案数
        for (int j = 0; j <=K ; j++) {
            s[0][j] = 1;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <= K ; j++) { //能装的数量

                int flag = Math.max(0, j - m[i]);
                if (flag != 0) {
                    dp[i % 2][j] = sub(s[(i - 1) % 2][j], s[(i - 1) % 2][flag - 1]);
                } else {
                    dp[i % 2][j] = s[(i - 1) % 2][j];
                }
                if (j != 0) {
                    s[i % 2][j] = add(s[i % 2][j - 1], dp[i % 2][j]);
                } else {
                    s[i % 2][j] = dp[i % 2][j];
                }

            }
        }
        System.out.println(s[n%2][K]%mod);
    }

    private static int add(int a, int b) {
        a+=b;
        if(a>=mod) a-=mod;
        return  a;
    }

    private static int sub(int a, int b) {
        a-=b;
        if(a<0) a+=mod;
        return  a;
    }
}
/*

import java.util.Scanner;


public class Main {
    static int N =1000001;
    static final int mod = 998244353;
    static int[] m = new int[N+1];
    static int[][] dp = new int[2][N+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //物品种类
        int K = sc.nextInt();  //最多能带走的物品数量
        for (int i = 1; i <=n ; i++) {
            m[i] = sc.nextInt();  //物品种类的数量
        }
        dp[0][0]=1; //前0种物品 取0包的方案数
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <= K ; j++) {
                int sum = 0;
                for (int k = 0; k<=j && k<=m[i]; k++) {
                    sum+=dp[(i-1)%2][j-k];
                    if(sum>mod) sum-=mod;
                }
                dp[i%2][j] = sum;
                if(dp[i%2][j]>mod) dp[i%2][j]-=mod;  //这样求模算法效率更高
            }
        }
        long res = 0;
        for (int j = 0; j <= K ; j++) {
            res+=dp[n%2][j];
            if(res>mod) res-=mod;
        }
        System.out.println(res%mod);
    }
}

*/
