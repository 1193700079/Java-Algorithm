package _2019蓝桥杯真题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-20 21:50
 **/
public class Test3_任务相关性分析 {
    static int k;
    static int count;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        k = sc.nextInt();
        String s=sc.nextLine();
        s=sc.nextLine(); //这样输入就是指输入一行
        String ss = s.replace(" ",".");
        String[] str = ss.split("\\.");
        String s1 ="Alice";
        String s2 ="Bob";
        int[] index1 = new int[str.length] ;
        Arrays.fill(index1,0);
        int[] index2 = new int[str.length] ;
        Arrays.fill(index2,0);
        for (int i = 0; i < str.length; i++) {
            if(str[i].equals(s1)){
                //找到Alice了
                index1[i] = 1;
            }
            if(str[i].equals(s2)){
                index2[i] = 1;
            }
            if(!str[i].equals(s1) && !str[i].equals(s2)) continue;

        }
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {
                if(Math.abs(i-j)>k/2) continue;
                if(index1[i]==0) break ;
                if(index1[i]>0 && index2[j]>0){
                    fun(i,j,str);
                }
            }
        }
        System.out.println(count);
    }

    private static void fun(int index1, int index2,String[] str) {
        if(index1>=0&&index2>=0){
            int l = Math.abs(index1-index2);
            int a = Math.max(index1,index2);
            int b = Math.min(index1,index2);
            int sum = 0;
            for (int j = b+1; j < a ; j++) {
                sum+=str[j].length();
            }
            if(sum+l<=k){
                count++;
            }
        }
    }
}
