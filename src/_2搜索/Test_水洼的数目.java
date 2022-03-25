package _2搜索;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * 八连通
 *
 10 10
 W.........
 .WWW......
 .WW.....WW
 .WW....WWW
 ........W.
 .......W..
 ..WW......
 ...WWW....
 ..W.......
 ..W......W
 * @author: yrq
 * @create: 2020-02-09 17:06
 **/

public class Test_水洼的数目 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] c = new char[N][];
        for (int i = 0; i < N; i++) {
                c[i]=sc.next().toCharArray();  //字符串读取用next
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(c[i][j]=='W'){
                    dfs(c,i,j);//找一个起点开始挖   作用是清除了一个水洼
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(c[i][j]);
            }
            System.out.println();
        }

    }
    public static void dfs(char[][] c,int i,int j){
        c[i][j]='.';
        //有八个方向 没有进行回溯
        for (int k = -1; k < 2; k++) {  //-1 0 1 从四个方向开始找寻 这种写法不错哟
            for (int l = -1; l < 2 ; l++) {
                if(k==0&&l==0) continue;  //因为中间不变
                if(i+k>=0&&i+k<c.length&&j+l>=0&&j+l<c[0].length){
                    if(c[i+k][j+l]=='W'){
                        dfs(c,i+k,j+l);
                    }
                }
            }
        }
    }
}
