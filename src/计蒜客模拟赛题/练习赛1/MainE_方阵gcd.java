package 计蒜客模拟赛题.练习赛1;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-19 15:02
 **/
public class MainE_方阵gcd {
    final static int mod = 1000000007;
    static int n=1000;
    static int k=500;
    public static void main(String[] args) {
        int ans1=0;
        for (int a = 1; a <= n -1; a++) {
            for (int b = 1; b <= n -1; b++) {
                if(a*a+b*b<=k*k&&gcd(a,b)==1){
                    ans1+= ((n-a)*(n-b))%mod ;  //关键理解n-a和n-b 巧妙啊
                    ans1%=mod;
                }
            }
        }
        ans1*=2;
        int ans2=2*(n-1)*n;
        ans2*=2;
        System.out.println(ans1+ans2);
//        double mod = 1e9+7;//表示的1.000000007
//        System.out.println(mod);
    }

    /**
     * 辗转相除求最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if(a < 0 || b < 0)
            return -1;
        if(a == b || a == 0)
            return b;
        if(b == 0)
            return a;
        if(a < b)
            return gcd(a, b % a);
        else
            return gcd(b, a % b);
    }
}
