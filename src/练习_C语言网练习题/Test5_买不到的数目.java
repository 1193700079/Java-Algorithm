package 练习_C语言网练习题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 *    说白了，其实就是求a和b不能组成的最大数；
 * @author: yrq
 * @create: 2020-02-20 20:41
 **/
public class Test5_买不到的数目 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        System.out.println(a*b-a-b);
        int c = fun(a,b);
        System.out.println(c);
    }

    private static int fun(int a, int b) {
        int[] arr = new int[999999999];
        Arrays.fill(arr,0);
        arr[a]=1;
        arr[b]=1;
        int count=0;
        int index=0;
        int max = a>b?a:b;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                index=i;
                count=0;
            }else {
                arr[a+i]=1;
                arr[b+i]=1;
                count++;
            }
            if(count==max){
                break;
            }
        }
        return index;

    }
}
