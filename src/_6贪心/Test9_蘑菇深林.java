package _6贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-17 16:40
 **/
public class Test9_蘑菇深林 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int h = sc.nextInt();
        int b = sc.nextInt();
        int gjz = h+b;
        Jiangshi[] Jiangshis = new Jiangshi[n];
        for (int i = 0; i < n; i++) {
            Jiangshis[i] = new Jiangshi(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(Jiangshis);
        int res = 0;
        for (int i = 0; i < n; i++) {
           if(Jiangshis[i].x>gjz){
               continue;
           }else {
               if(m<=0){
                   continue;
               }
               if(m-Jiangshis[i].y>=0){
                   res++;
                   m-=Jiangshis[i].y;
               }
           }
        }
        System.out.println(res);

    }
    private static class Jiangshi implements Comparable<Jiangshi>{
        int x;
        int y;

        public Jiangshi(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Jiangshi{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Jiangshi o) {
        int a  =this.y-o.y;
        if(a==0){
            return this.x - o.x;
        }else return a;
    }
}
}
