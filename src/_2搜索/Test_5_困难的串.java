package _2搜索;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-10 10:01
 **/
public class Test_5_困难的串 {
    static int cnt;
    public static void main(String[] args) {
        int n = 10;
        int l = 3;
        dfs(n,l,"");
    }

    private static void dfs(int n, int l, String prefix) {
        for(char i='A';i<'A'+l;i++){
            if(ishard(prefix,i)){
                String s = prefix+i;
                System.out.println(s);
                cnt++;
                if(cnt==n) System.exit(0);
                dfs(n,l,s);
            }
        }
    }

    /**
     * 该函数可以用来比较最后加进来的字符是否与之前的子串重复
     * 思想就是倒着比较  比如 ABACA
     * 先尝试加入A  不符合 因为ABACAA重复
     * 接着尝试加入B    ABACAB  第一步比较 A B 第二步比较 AC AB 第三步比较 ABA CAB
     * @param prefix
     * @param i
     * @return
     */
    private static boolean ishard(String prefix, char i) {
        int width =  0;//宽度
        for (int j = prefix.length()-1; j >= 0 ; j-=2) {
            final String s1 = prefix.substring(j,j+width+1);
            final String s2 = prefix.substring(j+width+1)+i;
            if (s1.equals(s2)){
                return false;
            }
            width++;
        }
        return true;

    }
}
