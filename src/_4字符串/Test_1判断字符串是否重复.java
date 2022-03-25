package _4字符串;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-18 10:57
 **/
public class Test_1判断字符串是否重复 {
    public static void main(String[] args) {
        String s  = "abcdefg";
        boolean res = isDifferentString(s);
        System.out.println(res); //true 表示无重复
        StringBuffer sb = new StringBuffer("abcdefg");
        sb=sb.reverse();
        System.out.println(sb.toString());
    }

    private static boolean isDifferentString(String s) {
        if(s.length()==0){
            return true;
        }
        int[] flag = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if(flag[c]>0) return  false;
            else flag[c]++;
        }
        return true;
    }
}
