package _2搜索;

/**
 * @program: lanqiaobei2020
 * @description:  交换回缩大法。。  实在不理解就用标记数组法
 * @author: yrq
 * @create: 2020-03-03 14:48
 **/
public class Test1_全排列_2_回溯 {
    public static void main(String[] args) {
        String s = "ABCD";
        char[] c= s.toCharArray();
        dfs(c,0);
    }

    private static void dfs(char[] c, int k) {
        if(k==c.length){
            System.out.println(new String(c));
            return;
        }
        for (int i = k; i <c.length ; i++) {
            swap(c,i,k);
            dfs(c,k+1);
            swap(c,i,k);
        }
    }

    private static void swap(char[] c, int i, int k) {
        char temp = c[i];
        c[i] = c[k];
        c[k] = temp;
    }
}
