package 计蒜客模拟赛题.刷题之旅;

import java.util.*;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-28 13:37
 **/
public class T4_最短路 {
    static int T;
    static int n;
    static int m;
    static int[][] a;
    static int[][] af;
    static int[] d;
    static long ans;
    List<Edge> edges = new ArrayList<>();
    List<Edge> edgesf = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 0; i < T ; i++) {
            ans = 0;
            n = sc.nextInt();  //结点个数
            m = sc.nextInt();  //边数
            a = new  int[n][n];
            af= new  int[n][n];
            for (int j = 0; j < m; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int val = sc.nextInt();
                a[start-1][end-1] = val;
                af[end-1][start-1] = val;

            }
            shortestPath(0,a);
            for (int j = 0; j < d.length; j++) {
                ans+=d[j];
            }
            shortestPath(0,af);
            for (int j = 0; j < d.length; j++) {
                ans+=d[j];
            }
            System.out.println(ans);
        }

    }

    private static void shortestPath(int s,int[][] a) {
        int n = a.length;
        d = new int[n];
        d[s] = 0;
        Set<Integer> vis = new HashSet<>();
        vis.add(d[s]);

        for (int i = 0; i < n; i++) {
            if(i!=s && a[s][i]==0) d[i] =Integer.MAX_VALUE;
            if(i!=s && a[s][i]>0) d[i] = a[s][i];
        }


        while (vis.size()<n){
            int min = minIndex(d,vis);
            vis.add(d[min]);
            if(vis.size() == n) break;
            for (int i = 0; i < n; i++) {
                if(!vis.contains(d[i])  && a[min][i]>0){
                    if(d[min]+a[min][i] <d[i]){
                        d[i] = d[min] + a[min][i];
                    }
                }
            }
        }

    }

    private static int minIndex(int[] d, Set<Integer> vis) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < d.length; i++) {
            if(!vis.contains(d[i])&&d[i]<min){
                min = d[i];
                index = i;
            }
        }
        return index;

    }
    class Edge implements Comparable<Edge>{
        int start;
        int end;
        int val;

        public Edge(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getVal() {
            return val;
        }

        @Override
        public int compareTo(Edge o) {
            return 0;
        }
    }
}
/*
import java.util.*;

public class Main{
    static long[][] a;
    static long[][] af;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T ; i++) {
            long ans = 0;
            int n = sc.nextInt();  //结点个数
            int m = sc.nextInt();  //边数
            a = new  long[n][n];
            af= new  long[n][n];
            for (int j = 0; j < m; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                long val = sc.nextInt();
                a[start-1][end-1] = val;
                af[end-1][start-1] = val;
            }
            long[] d = shortestPath(0,a);
            for (int j = 0; j < d.length; j++) {
                ans=ans+d[j];
            }
            long[] d2 = shortestPath(0,af);
            long sum = 0;
            for (int j = 0; j < d2.length; j++) {
                sum=sum+d2[j];
            }
            System.out.println(ans+sum);
        }
    }

    private static long[] shortestPath(int s,long[][] a) {
        int n = a.length;   //顶点个数
        long[] d = new long[n];
        d[s] = 0;
        Set<Integer> vis = new HashSet<>();  //记录已经找到最短路的顶点
        vis.add(s);

        for (int i = 0; i < n; i++) {
            if(i!=s && a[s][i]==0) d[i] =Long.MAX_VALUE;
            if(i!=s && a[s][i]>0) d[i] = a[s][i];
        }

        while (vis.size()<n){
            int min = minIndex(d,vis);
            vis.add(min);
            if(vis.size() == n) break;
            for (int i = 0; i < n; i++) {
                if(a[min][i]>0 && d[min]+a[min][i] <d[i]){

                    d[i] = d[min] + a[min][i];

                }
            }
        }
        return d;
    }

    private static int minIndex(long[] d, Set<Integer> vis) {
        int index = -1;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < d.length; i++) {
            if(!vis.contains(i)&&d[i]<min){
                min = d[i];
                index = i;
            }
        }
        return index;
    }
}
*/