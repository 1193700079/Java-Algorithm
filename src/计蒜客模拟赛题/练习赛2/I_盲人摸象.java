package 计蒜客模拟赛题.练习赛2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:  顺时针dfs+逆时针dfs+bfs最短路
 * @author: yrq
 * @create: 2020-03-01 14:33
 **/
public class I_盲人摸象 {

   static int[][] d= new int[][]{
           {-1,0},{0,1},{1,0},{0,-1}}; /*0-上,1-右,2-下,3-左*/ //背下来 上右下左
    static int ans;
    static int n ;
    static int m ;
    static char[][] c ;
    static int[][] vis ;
    static int left=1;
    static int right=1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();  //列数
        n = sc.nextInt();  //行数
         c =new char[n][m];
        vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s= sc.next();
            c[i] = s.toCharArray();
        }
        int sx=0;
        int sy=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(c[i][j]=='S'){
                    c[i][j]='#';
                    sx = i;
                    sy = j;
                }
            }
        }
        int face = 0;
        //确定初始方位  （因为S 一定在边界处）
          if(sx == 0)
                  face = 2;
          else if(sx == n-1)
                  face = 0;
          if(sy == 0)
                  face = 1;
          else if(sy == m-1)
                  face = 3;

        dfsLeft(sx,sy,face); //表示逆时针  左瞎子  就只能往左的那个
        dfsRight(sx,sy,face); //表示顺时针  右瞎子
        bfs(sx,sy);//表示正常人

    }


    private static void dfsLeft(int x, int y,int face) {
        int to[] = new int[]{3,0,1,2};   //表示朝向

        if(c[x][y] == 'E')
         {
             System.out.println(left);
             return ;
         }
        left++;
        for(int i=0; i<4; ++i)
         {
             int nowface = (face + to[i]) % 4;
             int tx = x + d[nowface][0];
             int ty = y + d[nowface][1];
             if(tx>=0 && ty>=0 && tx<n && ty<m && c[tx][ty] != '#')
              {
                  dfsLeft(tx, ty, nowface);
                   return ;

              }
         }

    }

    private static void dfsRight(int x, int y,int face) {
        int to[] = new int[]{1,0,3,2};
        if(c[x][y] == 'E')
        {
            System.out.println(right);
            return ;
        }
        right++;
        for(int i=0; i<4; ++i)
        {
            int nowface = (face + to[i]) % 4;
            int tx = x + d[nowface][0];
            int ty = y + d[nowface][1];
            if(tx>=0 && ty>=0 && tx<n && ty<m && c[tx][ty] != '#')
            {
                dfsRight(tx, ty, nowface);
                return ;
            }
        }
    }

    private static void bfs(int a, int b) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a,b,1));

        while (!q.isEmpty()){
            Node node  = q.poll();
            int i = node.x;
            int j = node.y;
            int step = node.step;
            vis[i][j] = 1;
            if(c[i][j]=='E'){
                System.out.println(step);
                return ;
            }

            for (int k = 0; k < d.length; k++) {
                int x = i+d[k][0];
                int y = j+d[k][1];
                if(x>=0&&x<n&&y>=0&&y<m&&vis[x][y]==0&&(c[x][y]=='.'||c[x][y]=='E')){
                    vis[x][y]=1;
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
