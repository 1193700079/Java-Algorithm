package _4字符串;

/**
 * @program: lanqiaobei2020
 * @description:
 * 时间复杂度是O(n*m)。  和暴力法没什么区别
 * @author: yrq
 * @create: 2020-02-21 14:36
 **/
public class RabinKarp {
    public static void main(String[] args) {
        String s ="ABABABA";
        String p = "ABA";
        match(p,s);

    }

    private static void match(String p, String s) {
        long hash_p = hash_String(p);
        int p_len = p.length();
        for (int i = 0; i <= s.length()-p_len; i++) {
            long hash_s = hash_String(s.substring(i,i+p_len));
            if(hash_s==hash_p){
                System.out.println("match : "+ i);
            }
        }
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
