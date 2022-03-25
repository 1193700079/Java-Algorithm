package 数据结构之图.最短路径;

import _1_recursion.Utils;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-27 19:53
 **/
public class Bellman_ford {
    static int[][] a={
            {0,2,5,0,0,0,0},
            {2,0,4,6,10,0,0},
            {5,4,0,2,0,0,0},
            {0,6,2,0,0,1,0},
            {0,10,0,0,0,3,5},
            {0,0,0,1,3,0,9},
            {0,0,0,0,5,9,0}, //无向图
    };
    public static void main(String[] args) {
        int[] d = shortPath(0);
        Utils.printArrays(d);
    }

    private static int[] shortPath(int s) {
        int n = a.length;
        int[] d = new int[n];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[s] = 0;
        while (true){
            boolean update = false;
            for (int i = 0; i < n; i++) {
                if(d[i]==Integer.MAX_VALUE) continue;;
                for (int j = 0; j < n; j++) {
                    //说明有边存在
                    if(a[i][j]>0 && d[i]+a[i][j]<d[j]){
                        //则更新d表
                        update = true;
                        d[j] = d[i]+a[i][j];
                    }
                }
            }
            if(!update){
                break;
            }
        }
        return d;

    }
}
