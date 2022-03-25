package _6贪心;

import _1_recursion.Utils;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-10 13:14
 **/
public class Test1_硬币支付 {
    static int[] arr = new int[6];
    static int[] coins = new int[]{1,5,10,50,100,500};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <=5 ; i++) {
            arr[i] = sc.nextInt();
        }
        int A = sc.nextInt();
        int res= fun(A,5);
        System.out.println(res);
    }

    private static int fun(int a, int cur) {
        if(a<=0) return 0;
        if(cur==0) return a;

        int coinValue = coins[cur];
        int x = a/coinValue; //可以得到的最大需求的数量 1
        int coinNumber = arr[cur]; // 求出实际有的硬币数量 2
        int t = Math.min(x,coinNumber);
        return t+fun(a-t*coinValue,cur-1);
    }

}
