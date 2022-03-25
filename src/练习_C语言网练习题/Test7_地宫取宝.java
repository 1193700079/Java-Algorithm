package 练习_C语言网练习题;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-04 21:21
 **/
public class Test7_地宫取宝 {
    static int n;
    static int m;
    static int k;
    static int[][] v;
    static int[][][][] rec;
    static int mod =  1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n  = sc.nextInt();
        m  = sc.nextInt();
        k  = sc.nextInt();
        rec= new int[50][50][50][50];
        v = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                v[i][j] = sc.nextInt();
            }
        }
        fill();
        int ans = dfs(0,0,0,-1);  //坐标x,y 以及拿到的件数 和价值
        System.out.println(ans);
    }

    private static int dfs(int i, int j, int num, int val) {
        if (i>=n||j>=m||num>k){
            return 0;
        }
        if(rec[i][j][num][val+1] != -1){
            return rec[i][j][num][val+1];
        }
        int count = 0;
        if(i==n-1&&j==m-1) {//到达出口
            //如果已经有K个或者有k-1个且出口处的价值大于手中价值（即可以拿），即为一种可行方法
            if(num==k||(num==k-1&&v[i][j]>val)) {
                return 1;
            }
            //到达出口但是宝物不够，不可行
            return 0;
        }
        //如果可以拿的话
        if(v[i][j]>val && num < k){
            //拿
            count+=dfs(i+1,j,num+1, v[i][j]);
            count%=mod;
            count+=dfs(i,j+1,num+1, v[i][j]);
            count%=mod;
        }
        //不取
        count+=dfs(i+1,j,num,val);
        count%=mod;
        count+=dfs(i,j+1,num,val);
        count%=mod;
        rec[i][j][num][val+1] =count;
        return count;
    }

        static void fill() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                for (int p = 0; p < 50; p++) {
                    for (int l = 0; l < 50; l++) {
                        rec[i][j][p][l] = -1;
                    }
                }
            }
        }
    }
}

//import java.util.Scanner;
//public class Main {
//    static int n;//行
//    static int m;//列
//    static int k;//需取数
//    static int mod = 1000000007;//取余值
//    static int dp[][][][] = new int[50][50][15][15];//x,y,已取数,最大价值
//    static int map[][] = new int[50][50];//价值
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        k = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                map[i][j] = sc.nextInt();
//            }
//        }
//        fill(dp);//因为有的格子不能走，即方法数为0，避免重复搜索，全部置为-1
//        System.out.println(dfs(0, 0, 0, -1));//最低价值为0，入口处可取可不取，因此初始最高价值置为-1
//    }
//    static int dfs(int x, int y, int sum, int max) {
//        //越界，比如一直向下一直向右，不可行
//        if(x>=n||y>=m||sum>k) {
//            return 0;
//        }
//        //入口的方法数已更新，即已经搜索完毕
//        if(dp[x][y][sum][max+1]!=-1) {//因为max初值设为-1，不+1会下越界
//            return dp[x][y][sum][max+1];
//        }
//        int count=0;//方法数
//        int gold=map[x][y];//当前位置的价值
//        if(x==n-1&&y==m-1) {//到达出口
//            //如果已经有K个或者有k-1个且出口处的价值大于手中价值（即可以拿），即为一种可行方法
//            if(sum==k||(sum==k-1&&gold>max)) {
//                return 1;
//            }
//            //到达出口但是宝物不够，不可行
//            return 0;
//        }
//        if(gold>max) {//此处可取，取之，每次相加时取余
//            count+=dfs(x+1,y,sum+1,gold);
//            count%=mod;
//            count+=dfs(x,y+1,sum+1,gold);
//            count%=mod;
//        }
//        //不取（不能取和可取但是没有取两种情况）
//        count+=dfs(x+1,y,sum,max);
//        count%=mod;
//        count+=dfs(x,y+1,sum,max);
//        count%=mod;
//        //记忆
//        dp[x][y][sum][max+1]=count;
//        return count;
//    }
//    static void fill(int[][][][] dp2) {
//        for (int i = 0; i < 50; i++) {
//            for (int j = 0; j < 50; j++) {
//                for (int k = 0; k < 15; k++) {
//                    for (int l = 0; l < 15; l++) {
//                        dp[i][j][k][l] = -1;
//                    }
//                }
//            }
//        }
//    }
//}
