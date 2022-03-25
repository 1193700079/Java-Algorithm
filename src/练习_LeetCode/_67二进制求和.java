package 练习_LeetCode;

import java.math.BigInteger;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-23 20:17
 **/
public class _67二进制求和 {
    public static void main(String[] args) {
        String  s1 = "11";
        String  s2 = "1";
        System.out.println(addBinary(s1,s2));
    }

    //使用BigInteger
    private static String addBinary(String s1, String s2) {
        BigInteger a = new BigInteger(s1,2);
        BigInteger b = new BigInteger(s2,2);
        BigInteger zero = new BigInteger("0",2);
        BigInteger cur,ans;
        while (b.compareTo(zero)!=0){
            ans = a.xor(b);
            cur = a.and(b).shiftLeft(1);
            a = ans;
            b = cur;
        }

        return a.toString(2);
    }
    //如果String的长度太长的话 会无法转换
    private static String addBinary2(String s1, String s2) {
        int a = Integer.parseInt(s1,2);
        int b = Integer.parseInt(s2,2);
//        return Integer.toBinaryString(a+b);
        return Integer.toBinaryString(Integer.parseInt(s1,2)+Integer.parseInt(s2,2));
    }
}
