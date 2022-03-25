package 蓝桥杯模拟赛1;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-22 16:39
 **/
public class _J梅深不见冬 {
    static int n;
    static int k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int sum= 0;
        for (int i = 1; i <= n; i++) {
            //k层循环
            if(k==1){
                sum+=i;
            }
            if(k==2){
                for (int j = 1; j <= n ; j++) {
                    sum+=gcd(i,j);
                }
            }
            if(k==3){
                for (int j = 1; j <= n ; j++) {
                    for (int l = 1; l <= n; l++) {
                        sum+=gcd(gcd(i,j),l);
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static int gcd(int a, int b)
    {
        if(a==0) return b;
        if(b==0) return a;
        if(!(a%2==1)&&!(b%2==1))
        {
            return gcd(a>>1,b>>1)<<1;
        }
        else if(!(b%2==1))
        {
            return gcd(a,b>>1);
        }
        else if(!(a%2==1))
        {
            return gcd(a>>1,b);
        }
        else
        {
            return gcd(Math.abs(a-b),Math.min(a,b));
        }
    }
}
