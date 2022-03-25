package 蓝桥杯模拟赛3;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-07 18:27
 **/
public class B_字符串2的倍数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.next();
        int n  = s.charAt(s.length()-1)-'0';
        if(n%2==0){
            System.out.println("no");
        }else {
            System.out.println("yes");
        }
    }
}
