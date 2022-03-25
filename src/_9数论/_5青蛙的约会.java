package _9数论;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:   线性同余方程 lct  ax=b(mod n)  =>   ax+ny = b  本质还是求 线性方程
 * @author: yrq
 * @create: 2020-03-04 14:19
 **/
public class _5青蛙的约会 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();  //青蛙A的坐标x
        int y = sc.nextInt();  //青蛙B的坐标y
        int m = sc.nextInt();  //青蛙A一次移动的距离
        int n = sc.nextInt();  //青蛙B一次移动的距离
        int L = sc.nextInt();  //地球的周长

        /*分析推理： x+km == y+kn (mod L )
        =>  x+km = L*t1 + 余数   y+kn = L*t2+余数
        => (x-y)+k(m-n)=L*t
        =>  ak+bt = (y-x)
        */

        int a = m-n;
        int b = L;
        m = y-x;
        int d = LinearEquation(a,b,m);
        b/=d;
        b = Math.abs(b);
        int res = (k%b+b)%b;   //一定是第一个k（理解为x）大于的第一个解
        System.out.println(res);
    }


    static int k;
    static int t;
    public  static  int ex_gcd(int a,int b){
        if(b==0){
            k =1;
            t =0;
            return a;
        }
        int res = ex_gcd(b,a%b);
        int x1 = k;
        k = t;
        t = x1-(a/b)*t;
        return res;
    }
    private static int LinearEquation(int a, int b, int m) {
        int d = ex_gcd(a,b);
        if(m%d!=0) System.out.println("无解");
        else {
            int p = m/d;
            k*=p;
            t*=p;
        }
        return d;
    }
}
