package 练习_C语言网练习题;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * 题目描述
 * 有一头母牛，它每年年初生一头小母牛。每头小母牛从第四个年头开始，每年年初也生一头小母牛。请编程实现在第n年的时候，共有多少头母牛？
 *
 * 输入
 * 输入数据由多个测试实例组成，每个测试实例占一行，包括一个整数n(0<n<55)，n的含义如题目中描述。
 * n=0表示输入数据的结束，不做处理。
 *
 * 输出
 * 对于每个测试实例，输出在第n年的时候母牛的数量。
 * 每个输出占一行。
 *
 * 样例输入
 * 2
 * 4
 * 5
 * 0
 * 样例输出
 * 2
 * 4
 * 6
 * @author: yrq
 * @create: 2020-02-19 16:01
 **/
public class Test1_母牛的故事 {
    static int[] rec = new int[10000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n =sc.nextInt();
            if(n==0){
                System.exit(0);
            }else {
                System.out.println(fun(n));
            }
        }
    }

    private static int fun(int n) {
        if(n<=4){
            return n;
        }
        if(rec[n]>0){
            return rec[n];
        }
        int ans = fun(n-1)+fun(n-3);
        rec[n] =ans;
        return  ans;
    }
}
