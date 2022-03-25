package _5DP动态规划;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-18 21:10
 **/
public class Test_1机器人走格子 {
    public static void main(String[] args) {
//        int a = solve(100,100);
//        System.out.println(a);
        int a = solve2(3,3);
        System.out.println(a);
    }

    /**
     * 复杂度太高 2^n
     * @param x
     * @param y
     * @return
     */
    private static int solve(int x, int y) {
        if(x==1||y==1){
            return 1;
        }
        return solve(x-1,y)+solve(x,y-1);
    }

    /**
     * 如果使用DP的话就要建立DP表  复杂度N^2
     * @param x
     * @param y
     * @return
     */
    private static int solve2(int x, int y) {
        //为了方便统计dp表 都从1开始
        int[][] dp = new int[x+1][y+1];
        for (int i = 1; i <=x ; i++) {
            //行遍历
            dp[i][1]=1;
        }
        for (int i = 1; i <= y; i++) {
            //列遍历
            dp[1][i]=1;
        }
        for (int i = 2; i <=x ; i++) {
            for (int j = 2; j <=y ; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[x][y];
    }

}
