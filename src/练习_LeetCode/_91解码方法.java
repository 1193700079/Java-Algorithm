package 练习_LeetCode;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: yrq
 * @create: 2020-02-20 13:32
 **/
public class _91解码方法 {
    public static void main(String[] args) {

    }
    static int[] rec;
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        rec = new int[s.length()];
        Arrays.fill(rec,-1);
        return digui(s, 0);
    }

    //递归的套路，加一个index控制递归的层次
    private int digui(String s, int start) {
        //递归的第一步，应该是加终止条件，避免死循环。
        if (s.length() == start) {
            return 1;
        }
        //以0位开始的数是不存在的
        if (s.charAt(start) == '0') {
            return 0;
        }
        if(rec[start]>=0){
            return rec[start];
        }
        //递归的递推式应该是如果index的后两位小于等于26，
        // digui(s, start) = digui(s, start+1)+digui(s, start+2)
        // 否则digui(s, start) = digui(s, start+1)
        int ans1 = digui(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1) {
            if(s.substring(start,start+2).compareTo("26")<=0){
                ans2 = digui(s, start + 2);
            }
        }
        rec[start] = ans1+ans2;
        return ans1 + ans2;
    }
    private int DP(String s){
        int len = s.length();

        int help = 1;
        int res;
        if(s.charAt(len-1)=='0'){
            res = 0;
        }else {
            res = 1;
        }
        for (int i = len-2; i >=0 ; i--) {
            if(s.charAt(i)=='0'){
                help =res;
                res = 0;
            }else if(s.substring(i,i+2).compareTo("26")<=0){
                res+=help;
                help = res-help;
            }else {
                help = res;
            }
        }
        return res;
    }
    /**
     * 题目最坑的地方就是找0！！ 而且反着思考 还不太容易思考
     */
   /* public int numDecodings(String s) {
        if(s.charAt(0)=='0' || s.substring(s.length()-1).equals("00")){
            return 0;
        }
        if(s.length()<=1){
            if(s.charAt(0)=='0'){
                return 0;
            }else {
                return 1;
            }
        }
        int len = s.length();
        boolean flag = true;
        char[] c= s.toCharArray();
        for (int i = 0; i < len; i++) {
            if(c[i]=='0'){
                flag =false;
            }
        }
        if(flag){
            return  DP(s,len)+1;
        }else {
            return  DP(s,len);
        }
    }

    private int DP(String s, int len) {
        if(len ==2){
            if(s.compareTo("26")<=0 && s.compareTo("00")>0 &&s.charAt(len-2)!='0'){
                return 1;
            }else {
                return 0;
            }
        }
        String newString  = s.substring(0,len-1);
        if(s.substring(s.length()-2).compareTo("26")<=0 && s.compareTo("00")>0 && s.charAt(len-2)!='0'){
            //说明比26小
            return 1+DP(newString,len-1);
        }else {
            return DP(newString,len-1);
        }
    }*/
}
