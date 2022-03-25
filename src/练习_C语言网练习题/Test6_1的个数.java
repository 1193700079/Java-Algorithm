package 练习_C语言网练习题;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-04 21:15
 **/
public class Test6_1的个数 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n =sc.nextInt();
        int ans = 0;
        for (int i = 1; i <=n ; i++) {
            String s= i+"";
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='1') ans++;
            }
        }
        System.out.println(ans);
    }
}
