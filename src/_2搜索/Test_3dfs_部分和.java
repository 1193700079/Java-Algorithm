package _2搜索;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.lang.System.exit;

/**
 * @program: lanqiaobei2020
 * @description:
 * dfs
 * @author: yrq
 * @create: 2020-01-20 19:53
 **/
public class Test_3dfs_部分和 {
    static int[] arr= new int[]{1,2,4,7};
    static LinkedList<Integer> list = new LinkedList<>();
    static int k = 13;
    static int sum;
    static int index;
    public static void main(String[] args) {
        dfs2(13,0);
    }

    private static void dfs( int n) {
        if(n==arr.length||k<0){
            return;
        }
        if(k==0){
            for (Integer integer: list) {
                System.out.print(integer+" ");
            }
            exit(0);
        }
        for (int i = n; i < arr.length; i++) {
            k-=arr[i];
            list.add(arr[i]);
            index++;
            dfs(n+1);
            k+=arr[i];
            index--;
            list.remove(index);
        }

    }

    /**
     * 考虑选与不选！！
     * 瞬间理解了递归的思维  其实你并不需要在意计算递归的过程 因为总会运行到你所期待的那个过程
     * 因此你只要把递归式写出来就好!
     * @param k
     * @param cur
     */
    private static void dfs2(int k,int cur) {
        System.out.println("*");
        if(k<0||cur==arr.length) return;
        if(k==0){
            System.out.println("Yes");
        exit(0);
    }
        dfs2(k,cur+1);  //说明不选
        dfs2(k-arr[cur],cur+1);  //说明选
    }

}
