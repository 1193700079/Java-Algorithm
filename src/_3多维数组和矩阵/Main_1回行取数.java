package _3多维数组和矩阵;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:  指针的移动 以及 打印的次数
 * @author: yrq
 * @create: 2020-01-16 20:38
 **/
public class Main_1回行取数 {
    static int count=0;  //注意这个count 打印多少次
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] arr = new int[200][200];

        for (int i = 0; i <r ; i++) {   //行row
            for (int j = 0; j < c; j++) {  //列col
                arr[i][j]=sc.nextInt();
            }
        }
        AntiClockwiseprint(arr,r,c);
    }

    private static void AntiClockwiseprint(int[][] arr,int rowB,int colB) {
        int leftupRow = 0,leftupCol=0,rightdownRow = rowB-1,rightdownCol=colB-1;
        while (leftupRow<=rightdownRow&&leftupCol<=rightdownCol&&count<rowB*colB){
            int r=leftupRow,c=leftupCol;
            while (r<=rightdownRow&&count<rowB*colB){
                System.out.print(arr[r++][c]+" ");
                count++;
            }
            r=rightdownRow;
            c++;
            while (c<=rightdownCol&&count<rowB*colB){
                System.out.print(arr[r][c++]+" ");
                count++;
            }
            c=rightdownCol;
            r--;
            while (r>=leftupRow&&count<rowB*colB){
                System.out.print(arr[r--][c]+" ");
                count++;
            }
            r=leftupRow;
            c--;
            while (c>leftupCol&&count<rowB*colB){
                System.out.print(arr[r][c--]+" ");
                count++;
            }
            leftupRow++;
            leftupCol++;
            rightdownRow--;
            rightdownCol--;
        }
    }
}
