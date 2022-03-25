package _2019蓝桥杯真题;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-20 21:29
 **/
public class Test2_数列求值 {
    public static void main(String[] args) {
        long ans=0;
        long a =1;
        long b =1;
        long c =1;
        for (int i = 4; i <= 20190324; i++) {
            ans=a+b+c;
            a=b%10000;
            b=c%10000;
            c=ans%10000;
        }
        System.out.println(ans%10000);
//        long res = 0;
//        long[] array = new long[20190324];
//        array[0] = 1;
//        array[1] = 1;
//        array[2] = 1;
//        for(int i=3;i<20190324;i++)
//        {
//            array[i] = array[i-1]%10000 + array[i-2]%10000 + array[i-3]%10000;
//            if(i == 20190323)
//            {
//                res = array[i]%10000;
//            }
//        }
//        System.out.println(res);
    }
            }
