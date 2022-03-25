package _8高精度;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-29 20:36
 **/
public class T1_减法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s= sc.next();
        BigInteger a = new BigInteger(s);
        String s2= sc.next();
        BigInteger b = new BigInteger(s2);
        a=a.subtract(b);
        System.out.println(a);
    }
}
