package _6贪心;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-17 14:23
 **/
public class Test6_部分背包问题 {
    public static void main(String[] args) {
        int[] w = new int[]{1,2,3,4,5};
        int[] v = new int[]{3,4,3,1,4};
        int N = w.length;
        double c = 10;
        Obj[] objs = new Obj[N];
        for (int i = 0; i < N; i++) {
            objs[i] = new Obj(w[i],v[i]);
        }
        Arrays.sort(objs);
        double maxValue=0;
        for (int i = N-1; i >= 0 ; i--) {
            if(objs[i].w <= c){
                c-=objs[i].w;
                maxValue+=objs[i].v;
            }else {
                maxValue+=objs[i].v*(c/objs[i].w);
                break;
            }
        }
        System.out.println(maxValue);
    }
    private static class Obj implements Comparable<Obj>{
        int w;
        int v;

        public Obj(int w, int v) {
            this.w = w;
            this.v = v;
        }

        public double getPrice(){
            return v/(double)w;
        }

        @Override
        public int compareTo(Obj o) {
            if(this.getPrice()==o.getPrice()) return 0;
            else if (this.getPrice()<o.getPrice()) return -1;
            else return 1;
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "w=" + w +
                    ", v=" + v +
                    ", price=" + getPrice() +
                    '}';
        }
    }
}
