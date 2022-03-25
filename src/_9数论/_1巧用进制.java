package _9数论;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-04 09:22
 **/
public class _1巧用进制 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        String s= Integer.toString(n,3);
        int[] a = new int[s.length()+1];
        Arrays.fill(a,0);
        for (int i = 0; i <s.length() ; i++) {
            a[i] = s.charAt(s.length()-1-i)-'0';
        }
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if(a[i]==2){
                a[i] = -1;
                a[i+1]++;
            }else if(a[i]==3){
                a[i] = 0;
                a[i+1]++;
            }
        }
        for (int i = 0; i < a.length; i++) {
            a[i]*= Math.pow(3,i);
        }
        for (int i = a.length-1; i >= 0; i--) {
            if(a[i]==0) continue;
            if(a[i]>0&&i!=a.length-1) ans = ans+"+"+a[i];
            else  ans+=a[i];
        }
        System.out.println(ans);

    }
}
