package 专题系列一背包九讲;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * 123 < 31
 * 132 < 21
 * @author: yrq
 * @create: 2020-02-23 22:04
 **/
public class _8_求最优方案的背包_字典序 {
    static int N =15000;
    static int[] w = new int[N+1];
    static int[] v = new int[N+1];
    static int[][] f = new int[N+1][N+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        //i倒序的原因是通过求f[i][j]的状态一定会转移到f[0][j]的 从1号物体开始判断选与不选！ 这样就能安装字典序了
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j<= k ; j++) {   //正序 因为是二维的  根据 状态方程 对于i而言只有两层没有必要全部记录下来
                f[i][j] = f[i + 1][j];
                if (j >= w[i]) f[i][j] = Math.max(f[i + 1][j], f[i + 1][j - w[i]] + v[i]);
            }
        }

        int wol = k;//最大容量
        for (int i = 1; i <=n ; i++) {
            if(f[i][wol]==f[i+1][wol-w[i]]+v[i]&&wol>=0){
                //说明f[i]一定被选取了
                System.out.print(i+" ");
                wol-=w[i];
            }
        }
    }
}
