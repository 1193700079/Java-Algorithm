package 练习_LeetCode;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-23 19:52
 **/
public class _264丑数2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        System.out.println(nthUglyNumber(n));
    }
    //三指针 +  dp
    private static int nthUglyNumber(int n) {
        if(n==1){
            return 1;
        }
        int[] f = new int[n];
        int a=0,b=0,c=0;
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(2*f[a],Math.min(3*f[b],5*f[c]));
            if(min == 2*f[a]) a++;
            if(min == 2*f[b]) b++;
            if(min == 2*f[c]) c++;
            f[i] = min;
        }
        return f[n-1];

    }
    //复杂度太高
    private static int nthUglyNumber2(int n) {
        if(n==1){
            return 1;
        }
        int[] d = new int[]{2,3,5};
        int i = 2;
        int cnt = 1;
        while (true){
            int j = i;
            for (int prime:d) {
                while (j>0 && j%prime == 0)
                    j/=prime;
            }
            if(j==1){
                cnt++;
                if(cnt == n){
                    return i;
                }
            }
            i++;
        }
    }
}
