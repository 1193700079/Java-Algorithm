package 数据结构之图.练习题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:   对于dfs用void就好了！
 * 10
 * 0010000000
 * 0011100000
 * 0000111110
 * 0001100010
 * 1111010010
 * 0000010010
 * 0000010011
 * 0111111000
 * 0000010000
 * 0000000000
 * 3
 * 0 0 9 9
 * 0 2 6 8
 * 4 4 4 6
 * @author: yrq
 * @create: 2020-02-26 10:32
 **/
public class Test1_连通的检测 {
    static int[][] a;
    static int[][] vis;
    static int x2;
    static int y2;
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         a = new int[n][n];
         vis = new int[n][n];
         String[] s= new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
            char[] c= s[i].toCharArray();
            for (int j = 0; j < n; j++) {
                a[i][j] = c[j]-'0';
            }
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            for (int j = 0; j < n; j++) {
                Arrays.fill(vis[i],0);
            }
//            flag = false;
//            dfs(x1,y1);
            System.out.println( dfs(x1,y1));
        }
    }

    //
    static boolean f;
    static int[][] d={{1,0},{-1,0},{0,-1},{0,1}};
    private static boolean dfs(int x1, int y1) {
        if(x1==x2&&y1==y2){
            return true;
        }

        for (int i = 0; i < d.length; i++) {
            int newx = x1+d[i][0];
            int newy = y1+d[i][1];
            if(check(newx,newy,x1,y1))
            {
                if(vis[x1][y1]==0){
                    vis[x1][y1]=1;
                    f = dfs(newx,newy);
                    vis[x1][y1]=0;
                }
            }
        }
        return f;
    }
    public static boolean check(int newx,int newy,int x1,int y1){
        if(newx>=0&&newx<a.length &&newy>=0&&newy<a[0].length&&a[x1][y1]==a[newx][newy]){
            return true;
        }
        return false;
    }
}
