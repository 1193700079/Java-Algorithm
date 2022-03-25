package 练习_LeetCode;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-20 10:52
 **/
public class _63不同路径2 {
    public static void main(String[] args) {

    }

    static int rec[][];
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        rec=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rec[i][j] = -1;
            }
        }
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1 ){
                    //说明有障碍
                    if(i==0){
                        for (int k = j; k < n; k++) {
                            rec[i][k] = 0;
                        }
                    }else if(j==0){
                        for (int k = i; k < m; k++) {
                            rec[k][j] = 0;
                        }
                    }else {
                        rec[i][j] = 0;
                    }
                    //如果边界有障碍的话
                }else {
                    rec[i][j] = DP(i,j);
                }
            }
        }
        return rec[m-1][n-1];
    }

    private static int DP(int i, int j) {
        if(rec[i][j]>=0){
            return rec[i][j];
        }
        if(i==0 || j==0){
            return 1;
        }
        rec[i][j] = DP(i-1,j)+DP(i,j-1);
        return rec[i][j];
    }
}
