package _2搜索;

import javax.swing.*;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-17 20:47
 **/
public class Test7_引爆炸弹 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();
        char[][] c = new char[n][m];
        for (int i = 0; i < n; i++) {
            c[i]=sc.next().toCharArray();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(c[i][j]=='1'){
                    dfs(c,i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }

    private static void dfs(char[][] c, int x, int y) {
        c[x][y]=0;
        for (int i = 0; i < c[0].length ; i++) {
            if(c[x][i]=='1'){
                dfs(c,x,i);
            }
        }
        for (int i = 0; i < c.length; i++) {
            if(c[i][y]=='1'){
                dfs(c,i,y);
            }
        }
    }

}
