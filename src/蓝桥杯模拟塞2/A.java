package 蓝桥杯模拟塞2;

import _1_recursion.Utils;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq   141
 * @create: 2020-02-29 13:00
 **/


public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s ;
        int[] ans = new int[26];
        while (sc.hasNext()){
            s  = sc.nextLine();
            s =s.replace(" ","");
            s=s.toLowerCase();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)>='a'&&s.charAt(j)<='z'){
                    int x = s.charAt(j)-'a';
                    ans[x]++;
                }
            }
        }
        int max=0;
        for (int j = 0; j < 26; j++) {
            max=Math.max(max,ans[j]);
        }
        System.out.println(max);

    }
}
/*
public class Main{
    public static void main(String[] args){
        System.out.println("0.965262");
    }
}
 */