package 蓝桥杯模拟赛1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description: 贪心
 * @author: yrq
 * @create: 2020-02-22 14:49
 **/
public class _H宝剑锋从磨砺出 {
    static int N;
    static int K;
    static int[][] arr;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        if(N==0 || K==0){
            System.out.println(0);
            System.exit(0);
        }
        arr = new int[N][2];
        int arrP2[] = new int[N+1];
        int flagi=0;
        int flagj=0;
        int max= 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j]>max){
                    max = arr[i][j];
                    flagi =i;
                    flagj =j;
                }
            }
        }
        if(max==0){
            System.out.println(0);
            System.exit(0);
        }
        if(flagj==0){
            System.out.println(Math.max(K,max)/Math.min(K,max));
            System.exit(0);
        }
        //找出p1的最大值
        int maxP1= 0;
        Arrays.sort(arrP2);
        for (int i = 0; i < N; i++) {
            if( arr[i][0] > maxP1){
                maxP1 =arr[i][0];
            }
        }

        //构建大数组
        for (int i = 0; i < N; i++) {
            arrP2[i] = arr[i][1] ;
        }
        arrP2[N]=maxP1;
        Arrays.sort(arrP2);
        for (int i = N; i >=0 ; i--) {
            if(arrP2[i]==maxP1){
                if(arrP2[i]==0){
                    System.out.println(0);
                    System.exit(0);
                }
                while (K>0){
                    K-=arrP2[i];
                    ans++;
                }
                break;
            }else {
                K-=arrP2[i];
                ans++;
                if(K<=0){
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
