package _5DP动态规划;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description: LeetCode的题目：
 * 求这个数的全排列在字典序的第K个排列
 * 用到前缀法 也叫入坑法 因为入坑的时候就是有字典序的因为（数组可以弄成字典序）
 * @author: yrq
 * @create: 2020-01-20 15:34
 **/
public class Test_4全排列升级字典序 {
    final static int k = 3;
    static int count;
    public static void main(String[] args) {
        String s= "ABC";
        char[] c= s.toCharArray();
        Arrays.sort(c);
//        getAllList(c,0);
//        System.out.println(res);
        int i =1;
        char j= (char)('0'+i);
        System.out.println(j);
    }

}
