package 练习_LeetCode;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-20 11:13
 **/
public class _64最小路径和 {
    public static void main(String[] args) {

    }
    static int[][] rec;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        rec = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rec[i][j] = -1;
            }
        }
        return DP(m-1,n-1,grid);
    }

    private int DP(int m, int n,int[][] grid) {
        if( m < 0 || n < 0){
            return 0;
        }
        //如果到了边界
        if( m == 0 && n > 0){
            int sum = 0;
            for (int i = 0; i <= n ; i++) {
                sum+=grid[m][i];
            }
            return sum;
        }

        if(n == 0 && m > 0){
            int sum = 0;
            for (int i = 0; i <= m ; i++) {
                sum+=grid[i][n];
            }
            return sum;
        }
        if(rec[m][n] > 0){
            return  grid[m][n]+rec[m][n];
        }
        rec[m][n] = Math.min(DP(m-1,n,grid),DP(m,n-1,grid));
        return grid[m][n]+rec[m][n];
    }
}
