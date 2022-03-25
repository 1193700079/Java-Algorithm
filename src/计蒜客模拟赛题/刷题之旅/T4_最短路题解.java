package 计蒜客模拟赛题.刷题之旅;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//spfa必须用邻接表  用邻接矩阵会炸掉 算法复杂度比Dijkstra和Ford低
/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-28 19:25
 **/
public class T4_最短路题解 {
    static class Edge{
        int start;
        int next;
        int va;

        public Edge(int start, int next, int va) {
            this.start = start;
            this.next = next;
            this.va = va;
        }
    }
    static int n;
    static int N = 20002;
    static int m;
    static long ans;
    static Long INF = Long.MAX_VALUE;
    static boolean[] used = new boolean[N];
    static long[] d = new long[N];
    static int[] h1 = new int[N];  //每个节点的有向边
    static int[] h2 = new int[N];  //每个节点的有向边
    static int len ;  //有向边的个数
    static List<Edge> edges ;
    static void add(int[] h,int a,int b,int c)   //一种邻接表结构
    {
//        e[idx] = b;
//        w[idx] = c;
//        ne[idx] = h[a];
        edges.add(new Edge(b,h[a],c));    //储存边  其中h[a]指向下个节点
        h[a] = len ++;  //h表示头结点
    }

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine().trim());
        int T = 1;
        for (int i = 0; i < T ; i++) {
            len = 0;   //对于多组数据输入 全局变量别忘了归0
            String[] s1 = br.readLine().split(" ");
            n = Integer.parseInt(s1[0]);  //结点个数
            m = Integer.parseInt(s1[1]);  //询问次数
            edges = new ArrayList<>();
            Arrays.fill(h1,-1);
//            Arrays.fill(h2,-1);
            for (int j = 0; j < n-1; j++) {
                String[] s2 = br.readLine().split(" ");
                int start = Integer.parseInt(s2[0]);
                int end = Integer.parseInt(s2[1]);;
//                int val = Integer.parseInt(s2[2]);
                int val = 1;
                add(h1,start-1,end-1,val);
//                add(h2,end-1,start-1,val);

            }
            for (int j = 0; j < m; j++) {
                String[] s3 = br.readLine().split(" ");
                int start = Integer.parseInt(s3[0]);
                int end = Integer.parseInt(s3[1]);
                System.out.println(shortestPath(start-1,n,edges,h1,end-1));
            }
//            System.out.println(shortestPath(0,n,edges,h1)+shortestPath(0,n,edges,h2));
        }
    }

    /**
     *
     * @param s   起点
     * @param n   节点数
     * @param edges
     */
    private static long shortestPath(int s, int n, List<Edge> edges,int[] h,int endd) {
        Queue<Integer> q = new LinkedList<>(); //队列
        Arrays.fill(d,INF);
        Arrays.fill(used,false);
        int[] num = new int[n];
        d[s] = 0;
        num[s]++;
        q.add(s);
        used[s] = true;
        while (!q.isEmpty()){
            int a = q.poll();   //出队
            used[a] = false;
            for (int i = h[a]; i !=-1; i = edges.get(i).next) {
                Edge e = edges.get(i);
                int end = e.start;
                int val = e.va;
                if( d[end]>d[a]+val){   //松弛操作
                    d[end] = d[a]+val;
                    if(!used[end]){
                        q.add(end);
                        used[end] = true;
                        if(++num[i]>n){
                            System.out.println("有负环");  //有负环表示一直按环走下去值会越来越小
                        }
                    }
                }
            }
        }
//        long res = 0;
//        for (int j = 0; j < d.length; j++) {
//            if(d[j]!=INF)
//            res+=d[j];
//        }
        return d[endd];
    }
}
