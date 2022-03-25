package _2搜索;

import java.util.ArrayList;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-03 15:45
 **/
public class Test2_子集_二进制 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int n  =a.length;

       ArrayList<ArrayList<Integer>> res =  getSubsets(a,n);
        System.out.println(res.toString());
    }

    private static ArrayList<ArrayList<Integer>> getSubsets(int[] a, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = (int)pow(2,n)-1; i > 0 ; i--) {  //二进制数的个数有
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = n-1; j >=0 ; j--) {    //二进制位 一共有n个 然后不断右移比较
                if(((i>>j)&1)==1){
                    list.add(a[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

    //    logN 复杂度的 幂运算 a^n 尽量用long 表示的数能够更大
    public static long pow(long a, long n){
        if(n==0) return 1;
        long res = a ;//res是result的简写
        long ex = 1;  //ex是指数部分的简写
        while ((ex<<1)<=n){
            res*= res;
            ex<<=1;   //等价于ex = ex<<1  要更新指数嘛 相当于 2乘2
        }
        //还差n-ex次方没有计算
        return res*pow(a,n-ex);
    }
}
