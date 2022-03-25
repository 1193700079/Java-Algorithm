package 蓝桥杯模拟塞2;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-29 16:03
 **/
public class I_M数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long M = sc.nextInt();
        long N = sc.nextInt();
        long i = 0;
        long j = 1;
        while (true){
            String s= j+"";
            long r = 1;
            for (int k = 0; k < s.length(); k++) {
                r*=(s.charAt(k)-'0');
                if(r>M) break;
            }
            if(r==M){
                i++;
            }
            if(i==N){
                System.out.println(j);
                break;
            }
            j++;
        }
    }
}
