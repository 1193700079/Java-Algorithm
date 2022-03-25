package 练习_LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-20 10:31
 **/
public class _62不同路径 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(uniquePaths(m,n));
    }
    static int rec[][];
    public static int uniquePaths(int m, int n) {
        rec = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                rec[i][j] = -1;
            }
        }
        return DP(m,n);
    }
        private static int DP(int m, int n) {
            if(m==1 || n==1){
                return 1;
            }
            if(rec[m][n]>=0){
                return rec[m][n];
            }
            rec[m][n] = DP(m-1,n)+DP(m,n-1);
            return rec[m][n];
    }
}
