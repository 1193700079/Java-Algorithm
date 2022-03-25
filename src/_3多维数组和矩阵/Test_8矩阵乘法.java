package _3多维数组和矩阵;

import _1_recursion.Utils;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-18 10:30
 **/
public class Test_8矩阵乘法 {
    public static void main(String[] args) {
        int[][] matrixA = Utils.createTwo_dimensionalArrays(3,3,-5,5);
        Utils.printTwo_dimensionalArrays(matrixA);
        int[][] matrixB = Utils.createTwo_dimensionalArrays(3,3,-5,5);
        Utils.printTwo_dimensionalArrays(matrixB);
        int[][] resMatrix = matrixMultiply(matrixA,matrixB);
        Utils.printTwo_dimensionalArrays(resMatrix);
    }

    private static int[][] matrixMultiply(int[][] matrixA, int[][] matrixB) {

        int n1=matrixA.length; //n表示行数
        int m1=matrixA[0].length; //表示列数
        int n2=matrixB.length;
        int m2=matrixB[0].length;

        if(m1!=n2){
            throw new IllegalArgumentException();
        }

        int[][] resMatrix = new int[n1][m2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++) {
                    resMatrix[i][j]+=matrixA[i][k]*matrixB[k][j];
                }

            }
        }
        return resMatrix;
    }
}
