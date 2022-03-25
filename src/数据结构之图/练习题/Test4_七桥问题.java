package 数据结构之图.练习题;

import java.util.Stack;

/**
 * @program: lanqiaobei2020
 * @description:
 * dfs+动态标记
 * @author: yrq
 * @create: 2020-02-26 20:43
 **/
public class Test4_七桥问题 {
    static int[][] a=new int[][]{
            {0,1,2,1},   //2表示有两条边
            {1,0,0,0},
            {2,0,0,1},
            {1,0,1,0},
    };
    static int n = 4;
    static int[][] vis = new int[n][n];  //表示从i点到j点是否被访问过
    static Stack<String> s = new Stack<>();
    public static void main(String[] args) {
        dfs(1);//从第B点 （i==行开始）开始dfs   因为B点的度数为奇数 可以作为起点 同理C也可以作为起点
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    private static void dfs(int i) {

        //扫描其他点  环顾四周
        for (int j = 0; j < n; j++) {
            //如果存在边 且没有被访问过（或者说访问的次数小于边的个数）    看有无可能性
            if(a[i][j]>0 && vis[i][j]< a[i][j]){
                vis[i][j]++;  //因为是无向图 所有都要加加
                vis[j][i]++;
                dfs(j);
                s.push((char)('A'+i)+"->"+(char)('A'+j));
            }
        }
    }
}
