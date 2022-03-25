package 专题系列一背包九讲;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-23 11:06
 **/
public class _4_二维费用背包 {
    static int N =200;
    static int[][] f = new int[N][N];
    static int[] w = new int[N];
    static int[] v = new int[N];
    static int[] m = new int[N];  //m为体积
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int M = sc.nextInt();   //背包体积
        int s = sc.nextInt();   //背包容量
        for (int i = 1; i <= n; i++) {
            m[i] = sc.nextInt();  //体积
            w[i] = sc.nextInt();  //重量
            v[i] = sc.nextInt();  //价值
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = s; j >=w[i] ; j--) {
                for (int k = M; k >=m[i] ; k--) {
                    f[j][k] = Math.max(f[j][k],f[j-w[i]][k-m[i]]+v[i]);
                }
            }
        }
        System.out.println(f[s][M]);
    }
    
}

//public class _43二维费用背包 {
//    static int N =102;
//    static int[][] dp = new int[N][N];
//    static int[] w = new int[N];
//    static int[] v = new int[N];
//    static int[] rec = new int[N];
//    static int[] m = new int[N];  //m为体积
//    static int ans;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int s = sc.nextInt();   //背包容量
//        int M = sc.nextInt();   //背包体积
//        Arrays.fill(rec,-1);
//        for (int i = 0; i < n; i++) {
//            w[i] = sc.nextInt();
//            v[i] = sc.nextInt();
//            m[i] = sc.nextInt();
//        }
//        ans = dfs(0,n,s,M);
//        System.out.println(ans);
//    }
//    private static int dfs(int i, int n, int s, int M) {
//        //中点
//        if(i==n){
//            return 0;
//        }
//        if(s==0)
//        if(rec[i]>=0){
//            return rec[i];
//        }
//        int v1 = v[i]+dfs(i+1,n,s-w[i],M-m[i]);  //表示选 造成的代价
//        int v2 = dfs(i+1,n,s,M);
//        rec[i] = Math.max(v1,v2);
//        return rec[i];
//    }
//}




