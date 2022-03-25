package _2搜索;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-03 15:09
 **/
public class Test1_全排列_2_字典序排列 {
    static String s = "AABC";
    static int cnt = 0;
    static int k = 10;
    public static void main(String[] args) {

        char[] c= s.toCharArray();
        dfs(c,"");
    }

    private static void dfs(char[] c, String new_S) {
        if(new_S.length() == s.length()){
            cnt++;
            System.out.println(new_S);
            if(cnt==k){
                System.out.println(new_S);
                System.exit(0);
            }
            return;
        }

        for (int j = 0; j < c.length; j++) {
            char cc = c[j];
            if(count(cc,new_S)<count(cc,s)){
                dfs(c,new_S+c[j]);
            }
        }
    }

    private static int count(char cc, String ss) {
        int ans = 0;
        for (int i = 0; i < ss.length(); i++) {
            if(ss.charAt(i)==cc){
                ans++;
            }
        }
        return ans;
    }
}
