package _5DP动态规划;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * 根据选与不选 可以构建二进制选择树
 * @author: yrq
 * @create: 2020-01-20 11:56
 **/
public class Test_3_1打印非空真子集 {
    public static void main(String[] args) {
        int[] arr= new int[]{1,2,3};
        ArrayList<ArrayList<Integer>> res = getSubset(arr);
        System.out.println(res);


        //以下是求部分和
        int k=3;
        int sum=0;
        for (ArrayList<Integer> arrayList:res) {
            for (Integer integer:arrayList) {
                sum+=integer;
            }
            if(sum==k&&arrayList.size()>1){
                System.out.println(arrayList);
            }
            sum=0;
        }

    }

    /**
     * 二进制法的缺陷就是无法打印出字典序 只能打印出逆字典序 所以可以呢进行翻转
     * @param arr
     * @return
     */
    private static ArrayList<ArrayList<Integer>> getSubset(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();  //最终的大集合
        int N = arr.length;
        for (int i =  (int)Math.pow(2,N)-1; i >= 1; i--) {  // 1 to 2^N-1 为了使用字典序
            ArrayList<Integer> arrayList = new ArrayList<>();  //每一个数字就是一个集合
            for (int j = N; j>=0 ; j--) {  //检查每个数二进制位含有1的情况
                if((( i >> j)&1)==1){
                    arrayList.add(arr[j]);
                }
            }
            res.add(arrayList);
        }
        return res; //最后返回的结果是逆序！
    }
}
