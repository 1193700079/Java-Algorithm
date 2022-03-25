package _5DP动态规划;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * ABCBDAB
 * BDCABAE
 * 结果：
 * 4
 * BCBA
 * @author: yrq
 * @create: 2020-02-18 11:41
 **/
public class Test_8_LCS {
    static int[][] DP;
    static int n; //列数
    static int m;  //行数
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
         n = s1.length();
         m = s2.length();
        DP = new int[m][n];
        ans = dp(s1,s2);
        System.out.println(ans);
        parse_dp(s1,s2);
    }

    /**
     * 解析DP表
     */
    private static void parse_dp(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        for (int i = m-1; i >0 ; ) {
            for (int j = n-1; j >0 ; ) {
                if(res.length()==ans){
                    break;
                }
                if(s1.charAt(j)==s2.charAt(i)){
                    res.append(s1.charAt(j));
                    i--;
                    j--;
                }else if(DP[i][j-1]>=DP[i-1][j]){
                    j--;
                }else {
                    i--;
                }
            }
        }
        System.out.println(res.reverse().toString());
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
