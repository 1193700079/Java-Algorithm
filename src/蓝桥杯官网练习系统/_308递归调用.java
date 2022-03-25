package 蓝桥杯官网练习系统;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-02 10:56
 **/
public class _308递归调用 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = 0;
        fun(s,0);
    }

    private static void fun(String s, int i) {
        if(i==s.length()){
            return;
        }
        System.out.print(s.charAt(i)+"-");
        fun(s,i+1);
    }
}
