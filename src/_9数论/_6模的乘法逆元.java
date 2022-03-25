package _9数论;

/**
 * @program: lanqiaobei2020
 * @description:
 * 定义 ：   ax%n = 1 则 a 与 x 互为模域上的逆元   一种特殊的同余方程  ax == 1(mode n)
 * @author: yrq
 * @create: 2020-03-04 15:03
 **/
public class _6模的乘法逆元 {
    public static void main(String[] args) throws Exception {
        long a = 20191031;
        long b = 1000000007;
        System.out.println(Case_gcd.inverseElement(a,b));

//        long d = Case_gcd.linearEquation(a,b,1L);
//        System.out.println(d);
//        long x0 =Case_gcd.x;
//        b/= d;
//        b = Math.abs(b);
//        x0 = (x0%b+b)%b;
//        System.out.println(x0);
//        int T = 2 ;   //输入多组数据用的模板
//        while (T-- > 0){
//            System.out.println("yrq");
//        }

    }
    static class Case_gcd{

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

        /*计算 a在mo下的逆元  就是说 求 ax%mo = 1*/
        public static long inverseElement(long a,long mo) throws Exception {
            long d = linearEquation(a,mo,1);
            x = (x%mo+mo)%mo;
            return x;
        }
    }
}
