package _2搜索;

import _1_recursion.Utils;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-09 20:53
 **/
public class Test_2_n皇后问题 {
    static int cnt=0;
    static int n=8;
    public static void main(String[] args) {
        int[] rec = new int[n];  //下标是行 数值是列
        Arrays.fill(rec,-1);
        dfs(rec,0);
        System.out.println(cnt);
    }

    private static void dfs(int[] rec, int row) {
        if(row==n){
            cnt++;
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(rec[i]==j){
                        arr[i][j]='0';
                    }else {
                        arr[i][j]='*';
                    }
                }
            }
            Utils.printTwo_dimensionalArraysChar(arr);
            return;
        }
        for (int col = 0; col < n; col++) {
            if(check(rec,row,col)){
                rec[row] = col;
                dfs(rec,row+1);
                rec[row] = -1;
            }
        }
    }

    private static boolean check(int[] rec, int row, int col) {
        for (int i = 0; i < row; i++) {
            //检查列
            if(col == rec[i] || i-rec[i] == row - col ||i+rec[i] == row + col){
                return false;
            }
        }
        return true;
    }
}
