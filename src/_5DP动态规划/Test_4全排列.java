package _5DP动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @program: lanqiaobei2020
 * @description:  递归+回溯  等价于 dfs？
 * 先纵后横
 * @author: yrq
 * @create: 2020-01-20 14:47
 **/
public class Test_4全排列 {
    static ArrayList<String> res = new ArrayList<>();
    public static void main(String[] args) {
        String s= "AAB";
        char[] c= s.toCharArray();
        Arrays.sort(c);
        getAllList(c,0);
        System.out.println(res);

        //ArrayList 去重复 并且排序的方法
        HashSet<String> set = new HashSet<>();
        for (String str:res) {
            set.add(str);
        }
        ArrayList<String> res_new = new ArrayList<>();
        for (String str:set) {
            res_new.add(str);
        }
        Collections.sort(res_new);
        System.out.println(res_new);

        int k=0;
        for (String str:res_new) {
            if((++k)==3){
                System.out.println(str);
            }
        }
    }

    private static void getAllList(char[] c, int k) {
        if(k==c.length-1){
            res.add(new String(c));
        }
        for (int i = k; i <c.length ; i++) {
            swap(c,k,i);
            getAllList(c,k+1);
            swap(c,k,i);  //这就是回溯
        }
    }
    private static void swap(char[] c,int a,int b){
        char temp =c[a];
        c[a]=c[b];
        c[b]=temp;
    }
}
