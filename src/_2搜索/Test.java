package _2搜索;

import java.util.ArrayList;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-09 11:07
 **/
public class Test {
    static int[] arr= new int[]{1,2,4,7};
    static int g=13;
    public static void main(String[] args) {
        int k = g;
        ArrayList<Integer> arrayList  = new ArrayList<>();
        dfs2(k,0,arrayList);

    }

    /**
     * 注意递归的出口
     * 然后再是递归的条件 顺序不要错！
     * @param k
     * @param cur
     */
    public static void dfs(int k,int cur){
        if(k==0){
            System.out.println("Yes");
            System.exit(0);
        }
        if(k<0||cur==arr.length) return;
        dfs(k,cur+1);
        dfs(k-arr[cur],cur+1);
    }

    /**
     * 如果需要记录其值的话
      * @param k
     * @param cur
     */
    public static void dfs2(int k,int cur,ArrayList<Integer> arrayList){
        if(k==0){
            System.out.println("Yes");
            int size = arrayList.size();
            System.out.print(g+" = ");
            for (int i = 0; i < size; i++) {
                System.out.print(arrayList.get(i)+(i==size-1?"":" + "));

            }
            System.exit(0);
        }
        if(k<0||cur==arr.length) return;
        dfs2(k,cur+1,arrayList);

        arrayList.add(arr[cur]);
        int index = arrayList.size()-1;
        dfs2(k-arr[cur],cur+1,arrayList);
        arrayList.remove(index); //回溯
    }
}
