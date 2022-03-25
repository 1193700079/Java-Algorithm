package 蓝桥杯模拟赛1;

/**
 * @program: lanqiaobei2020
 * @description:
 * 11404800
 * 11404800
 * @author: yrq
 * @create: 2020-02-25 21:09
 **/
public class _E三叉神树 {
    static int n  = 12;
    static int[] a = new int[n];
    static int[] b = new int[n+1];
    static int res;
    public static void main(String[] args) {
        dfs(0);
        System.out.println(res);
    }

    private static void dfs(int i) {
        if(i==12){
            boolean flag  = (a[1]+a[4])%2==0
                    &&  (a[2]+a[5]+a[6]+a[9]+a[10])%2==0
                    && (a[6]+a[9]+a[10])%2==0
                    && (a[3]+a[7]+a[8]+a[11])%2==0
                    && (a[8]+a[11])%2==0;
            if(flag) res++;
            return;
        }
        for (int j = 1; j <=12 ; j++) {
            if(b[j]==0){
                a[i] = j;
                b[j] = 1;
                dfs(i+1);
                b[j] = 0;
            }

        }
    }
}
