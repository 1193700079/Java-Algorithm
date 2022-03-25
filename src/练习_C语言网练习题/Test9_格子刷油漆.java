package 练习_C语言网练习题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * 不简单 啊  需要dp才能AC  暴力搜索会超时。重点还不能用记忆形递归
 * @author: yrq
 * @create: 2020-03-06 19:47
 **/
public class Test9_格子刷油漆 {
    static int n;
    static int mod =   1000000007;
    static int[][] vis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        vis = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 1;
                dfs(i,j,1);
                vis[i][j] = 0;
            }
        }
        System.out.println(ans);
    }


    static int ans;
    private static void dfs(int i, int j,int step) {
        if(step == 2*n){
            ans++;
            if(mod == ans) ans = 0;
            return;
        }
        //有八个方向
        for (int k = -1; k < 2; k++) {  //-1 0 1 从四个方向开始找寻 这种写法不错哟
            for (int l = -1; l < 2 ; l++) {
                if(k==0&&l==0) continue;  //因为中间不变
                if(i+k<0||i+k>=2||j+l<0||j+l>=n) continue;
                    if(vis[i+k][j+l]==0){
                        vis[i+k][j+l]=1;
                        dfs(i+k,j+l,step+1);
                        vis[i+k][j+l]=0;
                    }

            }
        }
    }

}
