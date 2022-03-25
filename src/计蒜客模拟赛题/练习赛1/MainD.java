package 计蒜客模拟赛题.练习赛1;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description: 苹果   感觉像是用的搜索
 * @author: yrq
 * @create: 2020-01-18 15:13
 **/
public class MainD {
    static int count=0;
    static int[] arr = new int[40];
    static int[] tmp = new int[40];
    static int len = 3;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= len; i++) {
            arr[i]=sc.nextInt();
            tmp[i]=arr[i];
        }
        func(1);
        System.out.println(count*2);
    }

    private static void func(int i) {
        if(i>=len){
            count++;
            return;
        }
        arr[i]-=3;
        if(arr[i]<0){
            arr[i]+=3; //恢复
            return;
        }
        if(i==1){
            func(i+1);
            arr[i]+=3;
            arr[i]-=1;
            arr[i+1]-=1;
            arr[i+2]-=1;
            func(i+1);
        }else if(i<=len-1){
            func(i+1);
            arr[i++]+=3;
            arr[i-1]-=1;
            arr[i]-=1;
            arr[i+1]-=1;
            func(i+1);
        }else {
            func(i+1);
            arr[i]+=3;
            arr[i-2]-=1;
            arr[i-1]-=1;
            arr[i]-=1;
            func(i+1);
        }

    }
}
