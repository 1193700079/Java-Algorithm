package 计蒜客模拟赛题.练习赛2;

import _1_recursion.Utils;

import java.util.*;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-01 13:14
 **/
public class D_迷宫 {
    static int ans;
    static int n = 6;
    static int m = 5;
    static char[][] c = new char[n][m];
    static int[][] vis = new int[n][m];
    static int[][] d={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1},
    };
    public static void main(String[] args) {
        Scanner sc  =new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            c[i] = s.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis[i],-1);
        }

        for (int i = 0; i <m ; i++) {
            if(c[0][i]=='0'){
                vis[0][i]=0;
                bfs(0,i);
            }
        }
        System.out.println(ans);
    }
    static  int min = 2000;
    private static void bfs(int a, int b) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a,b,0));

        while (!q.isEmpty()){
            Node node  = q.poll();
            int i = node.x;
            int j = node.y;
            int step = node.step;
            if(step>min){
                break;
            }
            for (int k = 0; k < d.length; k++) {
                int x = i+d[k][0];
                int y = j+d[k][1];
                if(x>=0&&x<n&&y>=0&&y<m&&c[x][y]=='0'){
                    if(vis[x][y]!=-1&&vis[x][y]<step+1) continue; //如果这个点访问过了并且访问的值比我当前的步数还小 那么我肯定之前访问过了
                    vis[x][y]=step+1;
                    if(x==n-1){
                        min = step+1;
                        System.out.println(min);
                        ans++;
                    }
                   q.add(new Node(x,y,step+1));
                }
            }
        }
    }
    static class Node{
        int x;
        int y;
        int step;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}
