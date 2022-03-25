package 蓝桥杯模拟赛3;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * 同理求 10进制尾0就是  2和5的个数  取最小
 * @author: yrq
 * @create: 2020-03-07 19:15
 **/
public class G_求六进制尾0的个数 {
        static int a=0;
        static int b=0;
        public static void main(String[]args){
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                int k=scanner.nextInt();
                while (k%2==0){
                    a++;
                    k=k/2;
                }
                while (k%3==0){
                    b++;
                    k=k/3;
                }
            }
            System.out.println(Math.min(a,b));
        }
}
