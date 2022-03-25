package game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class J{
	static int n;
	static int m;
	static char[][] a;
	static int[][] vis;
	static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		

		n =sc.nextInt();
		m =sc.nextInt();
		int x =sc.nextInt();
		int y =sc.nextInt();
		a = new char[n][m];
		vis = new int[n][m];
		for(int i=0;i<n;i++){
			a[i] = sc.next().toCharArray();
		}
		vis[x][y]=1;
		q.add(new Node(x,y));
		bfs();
		System.out.println(ans);
	}

	private static void bfs() {
		while (!q.isEmpty()){
			Node now = q.poll();
			ans++;
			int x = now.x;
			int y = now.y;
			for(int i = 0;i<4;i++){
				int nx = x+d[i][0];
				int ny = y+d[i][1];
				if(nx<0||nx>=n||ny<0||ny>=m||vis[nx][ny]==1||a[nx][ny]=='0') continue;
				q.add(new Node(nx,ny));
				vis[nx][ny] = 1;
			}
		}
	}

	static int[][] d = new int[][]{
		{0,1},
		{0,-1},
		{1,0},
		{-1,0}
	};
	static int ans;
	static class  Node{
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
//	private static void dfs(int x, int y) {
//		ans++;
//		for(int i = 0;i<4;i++){
//			int nx = x+d[i][0];
//			int ny = y+d[i][1];
//			if(nx<0||nx>=n||ny<0||ny>=m||vis[nx][ny]==1||a[nx][ny]=='0') continue;
//			vis[nx][ny]=1;
//			dfs(nx,ny);
//		}
//		return ;
//	}
}
