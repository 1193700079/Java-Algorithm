package 蓝桥杯官网练习系统;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * NP完全问题 + 集合覆盖问题
 * @author: yrq
 * @create: 2020-03-02 10:59
 **/
public class _307vertexCover {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] a = new int[n][n];
            int[] vis = new int[n];
            for (int j = 0; j < n; j++) {
                Arrays.fill(a[j],0);
            }
            for (int j = 0; j < m; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                a[s-1][e-1] = 1;
                a[e-1][s-1] = 1;
            }
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if(a[j][l]!=0){
                        vis[j]++;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                if(vis[j]==k){

                }

            }
        }
    }
}
