package _5DP动态规划;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-18 15:39
 **/
public class Test_10_最长递增子序列 {
    static int[][] DP;
    static int n; //列数
    static int m;  //行数
    static int ans;
    static int[] arr = new int[]{5,4,3,2,6};
    static int[] arr2 = new int[]{5,4,3,2,6};
    public static void main(String[] args) {
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb2.append(arr2[i]);
        }
        n=arr.length;
        m=arr.length;
        DP=new int[n][m];
        ans = dp(sb.toString(),sb2.toString());
        System.out.println(ans);
    }

    static boolean flag = true;
    static boolean flag2 = true;
    private static int dp(String s1, String s2) {
        //填充第一行
        for (int i = 0; i < n; i++) {
            if(!flag){
                DP[0][i]=1;
                continue;
            }
            if(s2.charAt(0) == s1.charAt(i)){
                DP[0][i]=1;
                flag = false;
            }else {
                DP[0][i]=0;
            }
        }
        //填充第一列
        for (int i = 0; i < m; i++) {
            if(!flag2){
                DP[i][0]=1;
                continue;
            }
            if(s1.charAt(0) == s2.charAt(i)){
                DP[i][0]=1;
                flag2 = false;
            }else {
                DP[i][0]=0;
            }
        }
        //从第二行开始依次填写
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(s1.charAt(j)==s2.charAt(i)){
                    int v1=DP[i-1][j-1]+1;
                    int v2=Math.max(DP[i][j-1],DP[i-1][j]);
                    DP[i][j]=Math.max(v1,v2);
                }else {
                    DP[i][j]=Math.max(DP[i][j-1],DP[i-1][j]);
                }
            }
        }
        return DP[m-1][n-1];
    }
}
