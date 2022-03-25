package _2搜索;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-17 20:23
 **/
public class Test_水洼的数目2_踏青 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] c = new char[N][];
        for (int i = 0; i < N; i++) {
            c[i]=sc.next().toCharArray();  //字符串读取用next
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(c[i][j]=='#'){
                    dfs(c,i,j);//找一个起点开始挖   作用是清除了一个水洼
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static int[][] d= new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public static void dfs(char[][] c,int i,int j){
        c[i][j]='.';
        //有四个方向 没有进行回溯
        for (int a = 0; a < d.length; a++) {
            int k = d[a][0];
            int l = d[a][1];
            if(i+k>=0&&i+k<c.length&&j+l>=0&&j+l<c[0].length){
                if(c[i+k][j+l]=='#'){
                    dfs(c,i+k,j+l);
                }
            }
        }
    }

}
