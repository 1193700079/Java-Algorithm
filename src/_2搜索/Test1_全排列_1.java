package _2搜索;

/**
 * @program: lanqiaobei2020
 * @description:
 * 逐步生成大法。。。
 * @author: yrq
 * @create: 2020-03-03 14:25
 **/
public class Test1_全排列_1 {
    public static void main(String[] args) {
        String s = "ABCDEFGHI";
        String st = "A";
        dfs(s,1,st);
        System.out.println(cnt);
    }

    static int cnt=0;
    private static void dfs(String s, int i,String st) {
        if(i==s.length()){
            System.out.println(st);
            cnt++;
            return;
        }
        String new_S  = st + s.charAt(i);
        dfs(s,i+1,new_S);
        new_S  = s.charAt(i)+st;
        dfs(s,i+1,new_S);
        for (int j = 1; j < st.length() ; j++) {
            new_S = st.substring(0,j)+s.charAt(i)+st.substring(j);
            dfs(s,i+1,new_S);
        }
    }
}
