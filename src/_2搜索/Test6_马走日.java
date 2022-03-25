package _2搜索;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-17 19:07
 **/
public class Test6_马走日 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] c = new char[10][9];
        for (int i = 0; i < 10; i++) {
            c[i] = sc.next().toCharArray();
        }
        int x = -1;
        int y = -1;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                if(c[i][j]=='S'){
                    x=i;
                    y=j;
                    c[i][j]='.';
                    break;
                }
            }
            if(x!=-1) break;
        }
        int a=-1;
        int b=-1;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                if(c[i][j]=='T'){
                    a=i;
                    b=j;
                    break;
                }
            }
            if(a!=-1) break;
        }
        if(isOk(c,a,b)){
            dfs(c,x,y);
        }else {
            System.out.println("No");
        }
    }

    private static boolean isOk(char[][] c, int x, int y) {
        for (int i = 0; i < 8; i++) {
            if(check(c,x+d[i][0],y+d[i][1])){
                return true;
            }
        }
        return false;
    }

    static int[][] d = new int[][]{
            {2,1},{1,2},{-1,2},{-2,1},
            {-1,-2},{-2,-1},{1,-2},{2,-1}};
    private static void dfs(char[][] c,int x,int y) {
        if(c[x][y]=='T'){
            System.out.println("Yes");
            System.exit(0);
        }
        for (int i = 0; i < 8; i++) {
            if(check(c,x+d[i][0],y+d[i][1]) &&c[x][y]=='.' ){
                c[x][y]='S';
                dfs(c,x+d[i][0],y+d[i][1]);
                c[x][y]='.';
            }
        }
    }

    private static boolean check(char[][] c, int x, int y) {
        if(x<0 || y<0 || x>=c.length || y>=c[0].length || c[x][y]=='#'){
            return false;
        }else {
            return true;
        }
    }
}
