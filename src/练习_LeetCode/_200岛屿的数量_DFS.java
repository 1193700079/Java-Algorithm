package 练习_LeetCode;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-22 11:15
 **/
public class _200岛屿的数量_DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] c = new char[N][];
        for (int i = 0; i < N; i++) {
            c[i]=sc.next().toCharArray();  //字符串读取用next
        }
        System.out.println(numIslands(c));
    }
    public static int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    static int[][] d= new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public static void dfs(char[][] c,int i,int j){
        c[i][j]='0';
        //有四个方向 没有进行回溯
        for (int a = 0; a < d.length; a++) {
            int k = d[a][0];
            int l = d[a][1];
            if(i+k>=0&&i+k<c.length&&j+l>=0&&j+l<c[0].length){
                if(c[i+k][j+l]=='1'){
                    dfs(c,i+k,j+l);
                }
            }
        }
    }
}
