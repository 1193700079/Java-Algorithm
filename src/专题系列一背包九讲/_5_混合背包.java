package 专题系列一背包九讲;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * 把多重背包转换成01背包就好了
 * 然后分别计算
 * @author: yrq
 * @create: 2020-02-23 15:52
 **/
public class _5_混合背包 {
    static int N =15000;
    static int[] w = new int[N+1];
    static int[] v = new int[N+1];
    static int[] flag = new int[N+1];  //0表示 01背包  1表示完全背包
    static int[] f = new int[N+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int tot = 1;
        for (int i = 1; i <= n; i++) {
            int a,b,c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if(c==-1){ //说明是01背包
                w[tot] = a;
                v[tot] = b;
                flag[tot++] = 0;
            }else if(c==0){
                w[tot] = a;
                v[tot] = b;
                flag[tot++] = 1;
            }else if(c>0){
                for (int j = 1; j <=c; j<<=2) {
                    w[tot] = a*j;
                    v[tot] = b*j;
                    flag[tot++] = 0;
                    c-=j;
                }
                if(c>0){
                    w[tot] = a*c;
                    v[tot] = b*c;
                    flag[tot++] = 0;
                }
            }
        }

        for (int i = 1; i <= tot ; i++) {
            if(flag[tot]==0){
                for (int j = k; j >=w[i] ; j--) {  //01背包是倒序循环
                    f[j] = Math.max(f[j],f[j-w[i]]+v[i]);
                }
            }else {
                for (int j = w[i]; j <=k ; j++) {  //完全背包是正序循环
                    f[j] = Math.max(f[j],f[j-w[i]]+v[i]);
                }
            }
        }

        System.out.println(f[k]);
    }
}
