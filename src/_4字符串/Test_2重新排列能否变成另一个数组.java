package _4字符串;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-18 11:19
 **/
public class Test_2重新排列能否变成另一个数组 {
    public static void main(String[] args) {
        String s1 = "abd";
        String s2 = "bac";
        boolean res = fun(s1,s2);
        System.out.println(res);
    }

    /**
     * 复杂度为n
     * @param s1
     * @param s2
     * @return
     */
    private static boolean fun(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        int[] flag = new int[128];
        Arrays.fill(flag,0);
        for (int i = 0; i < s1.length(); i++) {
            int c = s1.charAt(i);
            flag[c]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int c = s2.charAt(i);
            flag[c]--;
            if(flag[c]<0){
                return false;
            }
        }
        for (int i = 0; i < flag.length; i++) {
            if(flag[i]>0)
                return false;
        }
        return true;
    }

}
