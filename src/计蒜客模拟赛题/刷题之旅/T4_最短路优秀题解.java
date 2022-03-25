package 计蒜客模拟赛题.刷题之旅;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-28 19:33
 **/
import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.LinkedList;
        import java.util.Queue;

public class T4_最短路优秀题解{
    static int N = 20010,M = 60010 * 2;
    static long INF = Long.MAX_VALUE;
    static int n,m;
    static int[] h1 = new int[N];
    static int[] h2 = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int[] w = new int[M];
    static int idx = 0;
    static long[] dist = new long[N];
    static boolean[] st = new boolean[N];
    static void add(int[] h,int a,int b,int c)
    {
        e[idx] = b;  //尾节点
        w[idx] = c;  //权值
        ne[idx] = h[a];  //终点到下一个
        h[a] = idx ++; //代表头结点
    }
    static long spfa(int[] h)
    {
        long res = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        Arrays.fill(dist, INF);
        dist[1] = 0;
        q.add(1);
        st[1] = true;

        while(!q.isEmpty())
        {
            int t = q.poll();
            st[t] = false;
            for(int i = h[t];i != -1;i = ne[i])
            {
                int j = e[i];
                if(dist[j] > dist[t] + w[i])
                {
                    dist[j] = dist[t] + w[i];
                    if(!st[j])
                    {
                        q.add(j);
                        st[j] = true;
                    }
                }
            }
        }
        for(int i = 1;i <= n;i ++) res += dist[i];
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T -- > 0)
        {

            String[] s1 = br.readLine().split(" ");
            n = Integer.parseInt(s1[0]);
            m = Integer.parseInt(s1[1]);
            Arrays.fill(h1, -1);
            Arrays.fill(h2, -1);
            idx = 0;
            while(m -- > 0)
            {
                String[] s2 = br.readLine().split(" ");
                int a = Integer.parseInt(s2[0]);
                int b = Integer.parseInt(s2[1]);
                int c = Integer.parseInt(s2[2]);
                add(h1,a,b,c);
//                add(h2,b,a,c);//建反向边
            }
            System.out.println(spfa(h1) + spfa(h2));
        }
    }
}
