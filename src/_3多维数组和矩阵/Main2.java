package _3多维数组和矩阵;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-16 21:50
 **/
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        boolean[][] border = new boolean[n+2][m+2];//判断边界矩阵
        //初始化
        for (int i = 0; n+2 > i; ++i) {
            for (int j = 0; m+2 > j; ++j) {
                if (i == 0 || i == n+1 || j == 0 || j == m+1)
                    border[i][j] = false;
                else {
                    border[i][j] = true;
                    arr[i-1][j-1] = sc.nextInt();
                }
            }
        }
        //当前数组位置
        int i = 0;
        int j = 0;
        int direction = 0;//方向
        //遍历
        for (int k = 0; n * m > k; ++k) {
            //当前边界位置
            int d1 = i+1;
            int d2 = j+1;
            System.out.print(arr[i][j] + " ");
            border[d1][d2] = false;
            boolean flag = true;
            for (int l = 0; 2 > l && flag; ++l) {
                direction = direction % 4;
                //判断当前方向的下一个数是否未读,若否则换方向
                switch (direction){
                    case 0:
                        if (border[d1+1][d2]){
                            i++;
                            flag = false;
                        }
                        else
                            direction++;//换方向
                        break;
                    case 1:
                        if (border[d1][d2+1]){
                            j++;
                            flag = false;
                        }
                        else
                            direction++;//换方向
                        break;
                    case 2:
                        if (border[d1-1][d2]){
                            i--;
                            flag = false;
                        }
                        else
                            direction++;//换方向
                        break;
                    case 3:
                        if (border[d1][d2-1]){
                            j--;
                            flag = false;
                        }
                        else
                            direction++;//换方向
                        break;
                }
            }
        }
    }
}