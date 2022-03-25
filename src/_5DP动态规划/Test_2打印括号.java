package _5DP动态规划;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: lanqiaobei2020
 * @description:  利用递归法  其实递归写法和迭代写法 本质上是一样的
 * 递推式 就是  左边加 右边加 中间加
 * @author: yrq
 * @create: 2020-01-20 10:03
 **/
public class Test_2打印括号 {
    public static void main(String[] args) {
         Set<String> res = obj(4);
        System.out.println(res);
        Set<String> res2 = obj(4);
        System.out.println(res2);
    }

    /**
     *
     * @param n
     * @return
     */
    private static Set<String> obj(int n) {
        Set<String> set_n = new HashSet<>();
        set_n.add("()");
        if(n==1){
            return set_n;
        }
        Set<String> set_n_1 = obj(n-1);
        for (String s:set_n_1) {
            set_n.add(s+"()");
            set_n.add("()"+s);
            set_n.add("("+s+")");
        }
        return set_n;
    }

    /**
     * 迭代做法
     */
    private static Set<String> obj2(int n) {
        Set<String> set_n = new HashSet<>();
        if(n==1){
            set_n.add("()");
            return set_n;
        }
        for (int i = 2; i <=n ; i++) {
            for (String s:set_n) {
                set_n.add(s+"()");
                set_n.add("()"+s);
                set_n.add("("+s+")");
            }
        }
        return set_n;
    }

}
