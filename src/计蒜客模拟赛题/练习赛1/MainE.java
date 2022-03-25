package 计蒜客模拟赛题.练习赛1;

import _1_recursion.Utils;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:方阵  要利用gcd 如果 gcd(a,b)==1 说明a b 互质  而我做题的时候只考虑了a=1 或 b=1的情况 。。明显少了
 * @author: yrq
 * @create: 2020-01-18 16:12
 **/
public class MainE {
    static int n=1000;
    static int k=500;
    static int count1,count2,count;
    public static void main(String[] args) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                arr[i][j]=1;
            }
        }
        for (int i = 0; i < n; i++) {
           y1: for (int j = 0; j < n; j++) {
                //向右边走  向下 右斜向下 左斜向下
                for (int l = j+1; l < n; l++) {
                    int len = l-j;
                    if(len<=k){
                        count1++;
                        continue y1;
                    }
                }
            }
        }
        count1*=2;
        for (int i = 0; i < n; i++) {
           y2: for (int j = 0; j < n; j++) {
                //算斜下
                for (int l = j+1; l < n; l++){
                    int lenR = l-j;
                    for (int m = i+1; m < n; m++) {
                        int lenX =m-i;
                        if(lenR*lenR+lenX*lenX<=k*k){
                            count2++;
                            continue y2;
                        }
                    }

                }
            }

        }
        count2*=2;
        System.out.println((count1+count2)%1000000007);
    }

}


