package 蓝桥杯官网练习系统;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-02 14:45
 **/
public class _306最大整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();
        int[] a= new int[n*2];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = n; i < 2*n; i++) {
            a[i] = a[i-n];
        }
        int max = 0;
        for (int i = 0; i <= 2*n-m; i++) {
            int sum=0;
            for (int j = i; j < i+m ; j++) {
                sum+=a[j];
                max = Math.max(max,sum);
            }
//            if(i==m-1){
//                for (int j = 0; j <= m-1; j++) {
//                    max+=a[j];
//                }
//            }else {
//                max = Math.max(a[i]+max-a[i-m],max);
//            }
        }
        System.out.println(max);

    }
}
