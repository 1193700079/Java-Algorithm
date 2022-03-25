package 练习_C语言网练习题;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-29 10:34
 **/
public class Test1923_学霸的迷宫 {
    static char[][] a ;
    static int[][] vis ;
    static int[][] d = new int[][]{
            {1,0},
            {0,1},
            {-1,0},
            {0,-1},
    } ;
    static char[] ds = new char[]{'D','R','U','L'};
    static Queue<Node> q = new LinkedList<>();
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            a[i] = s.toCharArray();
        }
        Node start = new Node(0,0,"");
        q.offer(start);
        bfs();
    }

    private static void bfs() {
        while (!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            String s= node.s;
            vis[x][y]=1;
            if(x==n-1 && y==m-1){
                System.out.println(s.length());
                System.out.println(s);
            }
            for (int i = 0; i < d.length; i++) {
                 int xx = x+d[i][0];
                 int yy = y+d[i][1];
                 if(xx<n&&xx>=0&&yy<m&&yy>=0&&vis[xx][yy]==0&&a[xx][yy]=='0'){
                     vis[xx][yy]=1;
                     q.offer(new Node(xx,yy,s+ds[i]));
                 }
            }
        }
    }

    static class Node{
        int x;
        int y;
        String s;

        public Node(int x, int y,  String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }
}
