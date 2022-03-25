package _6贪心;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-17 13:52
 **/
public class Test5_字典序最小 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(sc.next());
        }
        f(sb.toString());
    }

    private static void f(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        int N = s.length();
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        while (res.length()<N){
            if(s.compareTo(s1)<=0){   //字符串比较 说明s更小 字符串比较就是从第一个开始比较的
                res.append(s.charAt(0));
                s = s.substring(1);
            }else {
                res.append(s1.charAt(0));
                s1 = s1.substring(1);
            }
            if(res.length()%80==0){
                System.out.println(res.substring(cnt*80,(cnt+1)*80));
                cnt++;
            }
        }
        if(res.length()>cnt*80){
            System.out.println(res.substring(cnt*80));
        }
    }
}
