package 蓝桥杯模拟塞2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-29 13:37
 **/
public class D_质数集合 {
    static long le9 =100000000;
    public static void main(String[] args) {
        Scanner sc  =new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        long N = sc.nextLong();
        int q1 = b/a;
        int q2 = c/b;
        int q = Math.min(q1,q2);
        long ans=a;
        for (long i = 1; i <= N-1 ; i++) {
            ans*=q;
            if(ans>le9) ans-=le9;
        }
        System.out.println(ans);
    }
}
