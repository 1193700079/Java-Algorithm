package 练习_蓝桥杯官网练习题;

import java.util.Arrays;
import java.util.Scanner;



/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-25 21:53
 **/
public class ALGO_224Sticks {
    static int[] a;
    static int[] b;
    static int num ;
    static boolean flag ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if(n==0){
                System.exit(0);
            }
            a = new int[n];
            b = new int[n+10];
            num = 0;
            flag =false;
            int sum = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sum+=a[i];
                max= Math.max(max,a[i]);
            }
            Arrays.sort(a);
            int res = fun(sum,max);
            System.out.println(res);
        }
    }

    private static int fun(int sum, int max) {

        for (int i = max; i <= sum/2; i++) {
            int count = sum/i;//count 表示棍子的个数
            if(count*i == sum ){
                isOK(i,count);
                if(flag){
                    return i;
                }
            }
        }
        return -1;

    }


    private static void isOK(int max,int count) {
        if(max < 0){
            return ;
        }
        if(max==0){
            num++;
            if(num == count){
                flag = true;
                return;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if(b[i]==0){
                b[i]=1;
                isOK(max-a[i],count);
                b[i]=0;
            }
        }

    }

}
