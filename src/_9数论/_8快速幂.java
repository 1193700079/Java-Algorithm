package _9数论;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-04 16:24
 **/
public class _8快速幂 {
    public static void main(String[] args) {
        long res = ex(99,50);
        System.out.println(res);
        long res2 = pow(2,63)-1;
        System.out.println(res2);
    }

    public static long pow(long a, long n){
        if(n==0) return 1;
        long res = a ;//res是result的简写
        long ex = 1;  //ex是指数部分的简写
        while ((ex<<1)<=n){
            res*= res;
            ex<<=1;   //等价于ex = ex<<1  要更新指数嘛 相当于 2乘2
        }
        //还差n-ex次方没有计算
        return res*pow(a,n-ex);
    }

    private static long ex(long n, long m) {
        long f = n;
        long res = 1;
        while (m!=0){
            if((m&1)==1){
                res*=f;
            }
            f*=f;
            m>>=1;
        }
       return res;
    }
}
