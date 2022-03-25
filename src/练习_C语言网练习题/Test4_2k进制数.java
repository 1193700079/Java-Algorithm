package 练习_C语言网练习题;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-20 19:43
 **/
public class Test4_2k进制数 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int k = sc.nextInt();
        int w = sc.nextInt();
        int sum = (int)Math.pow(2,k);  //说明这是几进制
        int s = 0; //能分成几段
        int count =0;
        if(w%k==0){
            s = w/k;
        }else {
            s = w/k+1;
        }
        sum--;
        //由于至少要两段
        for (int i = 2; i <=s ; i++) {
            sum--;
            for (int j = sum; j >=0 ; j--) {
                count+=j;
            }
        }
        System.out.println(count);
    }
    //排列组合算法  从n中选取m个
    long c(int n,int m){
        if(m>n){
            return 0;
        }
        long ans =1;
        if(m>n-m){
            m = n-m;
        }
        for (int i = n; i > m+1; i--) {
            ans*=i;
        }
        for (int i = m; i >=2 ; i--) {
            ans=i;
        }
        return ans;
    }
}
