package 练习_LeetCode;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-23 19:47
 **/
public class _263丑数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        System.out.println(isUgly(n));
    }

    private static boolean isUgly(int n) {
        int[] d = new int[]{3,2,5};
        for (int prime:d) {
            while (n>0 && n%prime == 0)
                n/=prime;
        }
        return n==1;
    }
}
