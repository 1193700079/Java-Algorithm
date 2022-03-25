package 计蒜客模拟赛题.练习赛2;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-01 14:12
 **/
public class G_juedou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a= new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum+=a[i];
            sum%=n;
        }
        int k = sc.nextInt();
        int index = (int)sum%n;
        System.out.println(index+1);
        if(a[index]>k){
            System.out.println("Escape");
        }else {
            System.out.println("Win") ;  //字母大小写要注意啊
        }

    }
}

