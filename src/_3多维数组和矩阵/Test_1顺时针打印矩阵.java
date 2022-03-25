package _3多维数组和矩阵;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-16 20:10
 **/
public class Test_1顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        int n=1;
        for (int i = 0; i <arr.length ; i++) {   //行row
            for (int j = 0; j < arr[i].length; j++) {  //列col
                arr[i][j]=n++;   //可以这么写
            }
        }
        clockwisePrint(arr);

    }
    private static void clockwisePrint(int[][] matrix) {
        int leftupRow = 0,leftupCol=0,rightdownRow = matrix.length-1,rightdownCol=matrix[0].length-1;
        while (leftupRow<=rightdownRow&&leftupCol<=rightdownCol){
            int r=leftupRow,c=leftupCol;
            while (c<=rightdownCol){
                System.out.print(matrix[r][c++]+" ");
            }
            c=rightdownRow;
            r++;
            while (r<=rightdownRow){
                System.out.print(matrix[r++][c]+" ");
            }
            r=rightdownRow;
            c--;
            while (c>=leftupCol){
                System.out.print(matrix[r][c--]+" ");
            }
            c=leftupCol;
            r--;
            while (r>leftupRow){
                System.out.print(matrix[r--][c]+" ");
            }
            leftupRow++;
            leftupCol++;
            rightdownRow--;
            rightdownCol--;
        }
    }
}
