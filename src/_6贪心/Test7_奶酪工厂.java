package _6贪心;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * 本题目的贪心策略就是：
 * 1.本周生产就本周售出
 * 2.本周生产一部分保存一周 下周继续售出
 * @author: yrq
 * @create: 2020-02-17 15:42
 **/
public class Test7_奶酪工厂 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int c = sc.nextInt();
        int  qian = 999999999; //任取一个任意大的数
        long res = 0;
        for (int i = 0; i < N; i++) {
            int m = sc.nextInt();
            long s = sc.nextLong();
            qian = Math.min(qian+c,m);
            res+=s*qian;
        }
        System.out.println(res);
    }
}
