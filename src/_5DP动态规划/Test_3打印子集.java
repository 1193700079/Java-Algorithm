package _5DP动态规划;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: lanqiaobei2020
 * @description:
 * 递推式就是  加与不加
 * 增量构造法
 * @author: yrq
 * @create: 2020-01-20 10:39
 **/
public class Test_3打印子集 {
    public static void main(String[] args) {
        int[] arr= new int[]{1,2,3};
        HashSet<HashSet<Integer>> res = getSubSet(arr);
        System.out.println(res);
        for (HashSet<Integer> set: res) {
            if(set.size()==0){
                set.clear();
                System.out.println(set);
            }
        }
        System.out.println(res);
    }

    /**
     * 必须要嵌套集合！！
     * @param arr
     * @return
     */
    private static HashSet<HashSet<Integer>> getSubSet(int[] arr) {
        HashSet<HashSet<Integer>> sets = new HashSet<>();
        sets.add(new HashSet<>());
        for (int i = 0; i <=arr.length-1 ; i++) {
            HashSet<HashSet<Integer>> clone_sets = new HashSet<>();
            clone_sets.addAll(sets);  //不加
            //加
            for (HashSet<Integer> e: sets) {
                HashSet clone = (HashSet) e.clone();
                clone.add(arr[i]);
                clone_sets.add(clone);
            }
            sets=clone_sets;
        }
        return sets;

    }
}
