package _9数论;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-04 10:48
 **/
public class _3gcd {

    public static void main(String[] args) {
        System.out.println(gcd(15,7));
    }

    public static int gcd (int n,int m){
        return m==0?n:gcd(m,n%m);
    }
    public static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }


    /* 贝祖公式 计算  ax+by = gcd(a,b)  如果是倍数的话 如  ax+by = gcd(a,b)*t  那么x y 只需要再除个t就好了 */
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
        x = y;  //更新 x
        y =x1 - (a/b)*y;  // 更新 y  因为java里面用不了指针只能用全局变量来表示了哟
        return res;
    }

    /*线性方程  计算  ax+by = m  其中m如果不是gcd(a,b)的倍数的话则无解  */
    public static long linearEquation(long a,long b,long m) throws Exception {
        long d = ex_gcd(a,b);
        if(d%m!=0) throw new Exception("无解");
        long t =m/d;
        x*=t;
        y*=t;
        return  d;
    }
}
