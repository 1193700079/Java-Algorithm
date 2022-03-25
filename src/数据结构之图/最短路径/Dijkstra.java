package 数据结构之图.最短路径;

import _1_recursion.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-27 20:40
 **/
public class Dijkstra {
    static int[][] a={
            {0,2,5,0,0,0,0},
            {2,0,4,6,10,0,0},
            {5,4,0,2,0,0,0},
            {0,6,2,0,0,1,0},
            {0,10,0,0,0,3,5},
            {0,0,0,1,3,0,9},
            {0,0,0,0,5,9,0}, //无向图
    };
    static int[] prev; //计算前驱结点
    public static void main(String[] args) {
        int[] d = shortestPath(0);
        Utils.printArrays(d);
    }

    private static int[] shortestPath(int s) {
        int n  = a.length;
        int[] d  = new int[n];
        prev = new int[n];
        d[s] = 0;
        //记录以及找到最短距离的结点  存放的是结点
        Set<Integer> vis = new HashSet<>();
        vis.add(d[s]);

        //初始化起点
        for (int i = 0; i < n; i++) {
            if(i!=s&&a[s][i]==0) d[i] = Integer.MAX_VALUE;
            if(i!=s&&a[s][i]>0){  //与起点相邻的点 记录下来
                d[i] = a[s][i];
                prev[i] = s; //前驱结点
            }
        }

        while (vis.size()<n){
            int min = minIndex(d,vis); //从没被访问的数组里 找到最小值的下标索引出来
            vis.add(d[min]); //把最小值 加入vis中
            if(vis.size()==n)  break;
            for (int i = 0; i < n; i++) {
                if(!vis.contains(d[i])  && a[min][i]>0){
                    if(d[min]+a[min][i] <d[i]){
                        d[i] = d[min] + a[min][i];
                        prev[i] = min;
                    }
                }
            }
        }
        return d;

    }

    //从没有访问过的d中找出最小值出来
    private static int minIndex(int[] d, Set<Integer> vis) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < d.length; i++) {
            if(!vis.contains(d[i]) && d[i]<min){
                min = d[i];
                index = i;
            }
        }
        return index;
    }
}
