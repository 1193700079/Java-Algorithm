package 计蒜客模拟赛题.刷题之旅;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * 双重dfs
 * @author: yrq
 * @create: 2020-02-26 13:48
 **/
public class T1_2n皇后 {
    static int[][] a;
    static int[][] rec;   //备忘录, rec[i][0]=j 表示黑皇后 放在第i行j列！！  同理rec[i][1]=j为白皇后
    static int ans = 0;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a= new int[n][n];
        rec = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(rec[i],-1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        //先放黑皇后 0  白皇后为 1
        dfs(0,0);
        System.out.println(ans);

    }

    private static void dfs(int i, int type) {
        if(i==n){
            //说明黑皇后已经摆好了   主要是if else 要注意 有时候答案会天差地别
            if(type==0){
                //再放白皇后
                dfs(0,1);
            }else {
                ans++;
            }
            return ;
        }
        for (int j = 0; j < n; j++) {
            if(a[i][j]==1){
                //如果可以存放的话
                if(check(i,j,type)){
                    rec[i][type] = j;
                    a[i][j]=0;
                    dfs(i+1,type);
                    a[i][j]=1;
                }
            }
        }
    }


    private static boolean check(int i, int j,int t) {
        for (int k = 0; k < i; k++) {
            if(j == rec[k][t] || (i+j)==(k+rec[k][t]) || (i-j)==(k-rec[k][t])){
                return false;
            }
        }
        return true;
    }
}
