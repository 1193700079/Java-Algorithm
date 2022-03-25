package _3多维数组和矩阵;

import _1_recursion.Utils;

/**
 * @program: lanqiaobei2020
 * @description: 枚举做法 n^4  以及预处理做法  n^3 建表 这种思维很好呀（类似与DP 动态规划）
 * @author: yrq
 * @create: 2020-01-17 16:28
 **/
public class Test_4最大子方阵 {
    static int[][][] recTable;//记录表 记录右下 其实就是二维数组里面记录两个数.
    static int len = 5;
    public static void main(String[] args) {

        int[][] arr = Utils.createTwo_dimensionalArrays(len,len,0,1);
//        int[][] arr=new int[][]{
//                {0,1,1,1,1},
//                {1,1,0,0,1},
//                {1,1,1,0,1},
//                {1,1,1,1,1},
//                {1,1,1,1,1}};
        Utils.printTwo_dimensionalArrays(arr);

        recTable=new int[len][len][2];//第一位表示记录右边1的个数 第二位表示记录下边1的个数
        makeRecTable(arr);
        printThree(recTable);
        int sonLen = toManLenInMatrix(arr);
        System.out.println(sonLen);
    }

    private static void printThree(int[][][] recTable) {
        for (int i = 0; i < recTable.length; i++) {
            for (int j = 0; j < recTable[i].length; j++) {
                System.out.print("("+recTable[i][j][0]+","+recTable[i][j][1]+")"+"\t");
            }
            System.out.println();
        }
    }



    /**
     * 只看右下
     * @param arr
     */
    private static void makeRecTable(int[][] arr) {
        int r=len-1;
        for (int j = len-1; j >= 0; j--) {
            if(arr[r][j]==1){
                if(j==len-1){
                    recTable[r][j][0]=1; //记录右侧
                }else{
                    recTable[r][j][0]=recTable[r][j+1][0]+1;
                }
                recTable[r][j][1]=1;
            }
        }
        r--;
        for(int i = r; i >= 0 ; i--){
            for(int j = len-1; j >= 0 ; j--){
                if(arr[i][j]==1){
                    if(j==len-1){
                        recTable[i][j][0]=1; //记录右侧
                    }else{
                        recTable[i][j][0]=recTable[i][j+1][0]+1;
                    }
                    //记录下侧
                    recTable[i][j][1]=recTable[i+1][j][1]+1;
                }
            }
        }
    }


    private static int toManLenInMatrix(int[][] arr) {
        int n= arr.length;
        while (n>0){
            for (int i = 0; i < arr.length; i++) {
                if(i+n>5){
                    break ;
                }
                y3:for (int j = 0; j < arr.length; j++) {
                if(j+n>5){
                    break ;
                }
//                    //i,j为顶点
//                    //r，c为移动的点
//                    int r=i;
//                    int c=j;
//                    //检查上边
//                    while (c<j+n){
//                        if(arr[r][c]==0){
//                            continue y3;
//                        }else {
//                            c++;
//                        }
//                    }
//                    c--;
//                    //检查右边
//                    while (r<i+n){
//                        if(arr[r][c]==0){
//                            continue y3;
//                        }else {
//                            r++;
//                        }
//                    }
//                    r--;
//                    //检查下边
//                    while (c>=j){
//                        if(arr[r][c]==0){
//                            continue y3;
//                        }else {
//                            c--;
//                        }
//                    }
//                    c++;
//                    //检查左边
//                    while (r>=i){
//                        if(arr[r][c]==0){
//                            continue y3;
//                        }else {
//                            r--;
//                        }
//                    }
//                    r++;
                    if(check(i,j,n)){
                        return n;
                    }
                }
            }
            n--;
        }
        return 0;
    }

    private static boolean check(int i, int j, int n) {
        //recTable
        if(recTable[i][j][0]>=n&&recTable[i][j][1]>=n&&recTable[i][j+n-1][1]>=n&&recTable[i+n-1][j][0]>=n)
            return true;
        return false;
    }
}
