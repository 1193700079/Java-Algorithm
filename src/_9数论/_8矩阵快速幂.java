package _9数论;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-04 19:12
 **/
public class _8矩阵快速幂 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(fib(i));
        }
    }

    public static  long fib(int n){
        if(n==1||n==2) return 1;
        long[][] matrix = new long[][]{
                {0,1},
                {1,1}
        };
        long[][] res = matrixPow(matrix,n-1);  //矩阵乘方
         res =  matrixMultiply(new long[][]{{1,1}},res);
         return res[0][0];
    }

    private static long[][] matrixMultiply(long[][] A, long[][] B) {
        if(A[0].length!=B.length) return null;
        int p = B.length;
        int n = A.length , m = B[0].length;
        long[][] res = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    res[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
        return res;
    }

    /*矩阵快速幂运算 和 pow的快速幂运算一样*/
    private static long[][] matrixPow(long[][] matrix, int p) {

        long[][] pingfang = matrix;
        //构建单位矩阵
        long[][] res = new long[matrix.length][matrix[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }

        while (p!=0){
            if((p&1)!=0){
                res = matrixMultiply(res,pingfang);
            }
            pingfang = matrixMultiply(pingfang,pingfang);
            p>>=1;
        }
        return res;
    }


}
