package 蓝桥杯模拟塞2;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-29 16:21
 **/
public class J_最小生成树 {
    static class Edge{
        int v,w,next;
        Edge(int v,int w,int next){
            this.v=v;
            this.w=w;
            this.next=next;
        }
    }
    static final int N= 100500;
    static final int M=1000050;
    static final int INF=0x3f3f3f3f;
    static int n,m,s,t,u,v,w,cnt;
    static int[] head=new int[N];
    static Edge[] edges=new Edge[M];
    static int[] dis=new int[N];
    static boolean[] vis=new boolean[N];
    static int[] inq=new int[N];
    static void init(){
        cnt=0;
        for(int i=1;i<=n;i++){
            head[i]=-1;
        }
    }
    private static void addEdge(int nextInt, int nextInt1, int i) {
        edges[cnt]=new Edge(v,w,head[u]);  //起点  代价 终点
        head[u]=cnt++;
        edges[cnt]=new Edge(u,w,head[v]);
        head[v]=cnt++;
    }
    static boolean spfa(){
        for(int i=1;i<=n;i++){
            vis[i]=false;
            inq[i]=0;
            dis[i]=INF;
        }
        dis[s]=0;
        vis[s]=true;
        Queue<Integer> q=new LinkedBlockingDeque<>();
        q.add(s);
        inq[s]=1;
        while(!q.isEmpty()){
            int u=q.poll();
            vis[u]=false;
            for(int i=head[u];i!=-1;i=edges[i].next){
                int v=edges[i].v;
                int w=edges[i].w;
                if(dis[v]>dis[u]+w){
                    dis[v]=dis[u]+w;
                    if(!vis[v]){
                        vis[v]=true;
                        q.add(v);
                        if(++inq[v]>n){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n  =sc.nextInt();   //5个顶点
        int q = sc.nextInt();  //询问次数
        init();
        for (int i = 0; i < n-1; i++) {
            int st = sc.nextInt();
            int en = sc.nextInt();
            addEdge(st,en,1);
        }
        for (int i = 0; i < q; i++) {
            s = sc.nextInt();
            t = sc.nextInt();
            //从s到t的最短路径
            spfa();
            System.out.println(dis[t]);
        }
    }


}
