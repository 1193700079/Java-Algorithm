package _4字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-21 15:43
 **/
public class KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String src = in.readLine();
        String p = in.readLine();
        ArrayList<Integer> arrayList = indexOfAll(src,p);
        StringBuilder sb = new StringBuilder();
        if(arrayList.size()==0){
            System.out.println(-1);
        }else {
            for (Integer e:arrayList) {
                sb.append(e+" ");
            }
            System.out.println(sb.substring(0,sb.length()-1));
        }

    }

    private static  ArrayList<Integer> indexOfAll(String s, String p){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(s.length()==0 || p.length()==0) return arrayList;
        if(p.length()>s.length()) return arrayList;

        int[] next = next3(p);
        int i=0; //s指针
        int j=0; //p指针
        int sLen = s.length();
        int pLen = p.length();

        while (i < sLen){
            if(j < 0||s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];  //j进行回溯
            }
            if(j==pLen){
                arrayList.add(i-j);
                j=0;
//                return (i-j);
            }
        }
        return arrayList;
    }

    /**
     * N 的复杂度
     * @param s
     * @return
     */
    private static int[] next2(String s){
        int[] res = new int[s.length()];
        res[0] = -1;
        res[1] = 0;
        for (int i = 2; i <s.length() ; i++) {
            if(s.charAt(i-1) == s.charAt(res[i-1])){
                res[i] = res[i-1]+1;
            }else {
                //如果失配的话
//                res[i] = 0;
            }
        }
        return res;
    }
    private static int[] next3(String s){
        int[] res = new int[s.length()];
        res[0] = -1;
        if(s.length() <= 1){
            return res;
        }
        res[1] = 0;
        int j = 1;
        int k = res[j];
        while (j < s.length()-1 ) {
            if(k < 0 || s.charAt(j) == s.charAt(k) ){
                res[++j] = ++k;
            }else {
                //如果失配的话
                k = res[k];
            }
        }
        return res;
    }

    /**
     *  N^2 的复杂度
     * @param s
     * @return
     */
    private static int[] next(String s){
        int[] res = new int[s.length()];
        res[0] = -1;
        res[1] = 0;
        int j = 1;
        int count = 0;
        for (int i = 2; i < s.length(); i++) {
            while (true){
                if(s.substring(0,j).equals(s.substring(i-j,i))){
                    count = j;
                }
                j++;
                if(j>=i){
                    break;
                }
            }
            res[i] = count;
            j=1;
            count = 0;
        }
        return res;
    }
}
