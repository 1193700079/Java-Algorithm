package _6贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-17 16:12
 **/
public class Test8_节约用电 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dengs = new int[n];
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            dengs[i]=sc.nextInt();
            flag[i]=true;
        }
        Arrays.sort(dengs);
        int res=0;
        for (int i = 1; i < n-1; i++) {
                int j = i-1;
                while (!flag[j]){
                    j--;//找到亮的灯
                }
                if(dengs[i+1]-dengs[j]<=m){
                    res++;
                    flag[i]=!flag[i]; //灭灯了
                }
        }
        System.out.println(res);
    }
}
