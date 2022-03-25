package _9数论;

/**
 * @program: lanqiaobei2020
 * @description:   2016蓝桥杯总决赛 填空题   贝祖等式
 * @author: yrq
 * @create: 2020-03-04 13:52
 **/
public class _4一步之遥 {

    /* 97x-127y = 1  */
    public static void main(String[] args) {
        long a = 97;
        long b =-127;
        long res = ex_gcd(a,b);
        System.out.println(x+y);

    }
    public static long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
    static long x;
    static long y;
    public static long ex_gcd(long a,long b){
        if(b==0){
            x=1;
            y=0;
            return a;
        }
        long res = ex_gcd(b,a%b);
        long x1 = x;
        x =y;
        y = x1-(a/b)*y;
        return res;
    }
}
