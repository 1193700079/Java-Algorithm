package _4字符串;

/**
 * @program: lanqiaobei2020
 * @description:
 * 复杂度 为(m+n) m为源字符串长度 n为匹配字符串长度
 * 利用了滚动hash
 * 比如 ABCD   AB  n=2
 * A*31+B
 * (A*31+B)*31- A*31^n + C  这么依次递归下去
 * 不过hash计算方法可能会有波动 100百万的冲突在110+波动
 * @author: yrq
 * @create: 2020-02-21 14:57
 **/
public class RabinKarp_进阶 {
    public static void main(String[] args) {
        String s ="ABABABA";
        String p = "ABA";
        match(p,s);
    }
    private static void match(String p, String s) {
        long hash_p = hash_String(p);
        long[] hash = hash(s,p.length());
        for (int i = 0; i < hash.length; i++) {
            if(hash[i]==hash_p){
                //可以继续在这里优化 比较两个字符串是否真的相等！
                System.out.println("match : "+ i);
            }
        }
//        int p_len = p.length();
//        for (int i = 0; i <= s.length()-p_len; i++) {
//            long hash_s = hash_String(s.substring(i,i+p_len));
//            if(hash_s==hash_p){
//                System.out.println("match : "+ i);
//            }
//        }
    }
    private static long[] hash(String s,int n){
        long[] res = new long[s.length()-n+1];
        res[0] = hash_String(s.substring(0,n));
        for (int i = n; i < s.length(); i++) {
            char newChar = s.charAt(i);
            char oldChar = s.charAt(i-n);
            res[i-n+1]= (long) ((res[i-n] *seed - oldChar * Math.pow(seed,n) + newChar ) % Long.MAX_VALUE);
        }
        return res;
    }
    final static int seed = 31;//hash种子
    private static long hash_String(String s){
        int len = s.length();
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = hash * seed + s.charAt(i);
        }
        return hash;
    }
}
