package _8高精度;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-29 20:38
 **/
public class T3_乘法 {

   static int[] c = new int[5000000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int lena = s1.length();
        int lenb = s2.length();
        int[] a = new int[lena];
        int[] b = new int[lenb];
        int i,j,x;
        for( i = 0; i < lena; i++) {
            a[i] = s1.charAt(lena-1-i)-'0'; //倒着存储
        }
        for (i = 0; i < lenb; i++) {
            b[i] = s2.charAt(lenb-1-i)-'0'; //倒着存储
        }
        for(i=0;i<lenb;i++)
        {
            x=0;//用于存放进位
            for(j=0;j<lena;j++)//对乘数每一位进行处理
            {
                c[i+j]=a[j]*b[i]+x+c[i+j];//当前乘积+上次乘积进位+原数
                x=c[i+j]/10;
                c[i+j]%=10;
            }
            c[i+lena]=x;//进位
        }
        int lenc=lena+lenb;
        while((c[lenc]==0)&&(lenc>1))//删除前导0
            lenc--;
        for(i=lenc;i>=0;i--)
            System.out.print(c[i]);

    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s= sc.next();
//        BigInteger a = new BigInteger(s);
//        String s2= sc.next();
//        BigInteger b = new BigInteger(s2);
//        a=a.multiply(b);
//        System.out.println(a);
//
//}

}
