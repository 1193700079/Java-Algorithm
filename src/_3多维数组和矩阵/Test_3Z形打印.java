package _3多维数组和矩阵;

import _1_recursion.Utils;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-17 11:19
 **/
public class Test_3Z形打印 {
    static int count=0;  //只给count也可以改成boolean来区分
    public static void main(String[] args) {
        int[][] arr = Utils.createTwo_dimensionalArrays(6,6,1,9);
        Utils.printTwo_dimensionalArrays(arr);

        printZ(arr);
    }

    private static void printZ(int[][] arr) {
        int startRow = 0; int startCol = 0;
        int endRow = arr.length-1; int endCol = arr[0].length-1;
        int r=startRow,c=startCol; //定义移动指针
        //别忘记考虑方阵的情况  因为方阵会同时超限
        while (r<=endRow&&c<=endCol&&r>=startRow&&c>=startCol){
            if(r==endRow&&c==endCol){
                System.out.print(arr[r][c]+" ");
                break;
            }
            if(r==startRow&&c==startCol){
                //第一次打印
                System.out.print(arr[r][c++]+" ");
                count++;
            }
            if(count%2!=0){
                //说明是奇数次 斜着向下
                while (c>=startCol&&r<=endRow){
                    System.out.print(arr[r++][c--]+" ");
                }
                count++;
                if(c<startCol&&r>endRow){
                    //说明同时超了
                    r--;
                    c+=2;
                }
                else if(c<startCol){
                    //说明c过了
                    c++;
                }else if(r>endRow){
                    //说明r过l
                    r--;
                    c+=2;
                }
            }else {
                //说明是偶数次 卸向上
                while (c<=endCol&&r>=startRow){
                    System.out.print(arr[r--][c++]+" ");
                }
                count++;
                if(r<startRow&&c>endCol){
                    c--;
                    r+=2;
                } else if(r<startRow){
                    //说明r过了
                    r++; //这是恢复
                }else if(c>endCol){
                    //说明c过了
                    c--;
                    r+=2;
                }
            }

        }

    }
}
