package 数据结构之栈;

import java.util.ArrayList;

/**
 * @program: lanqiaobei2020
 * @description:
 * 0表示入栈 1表示出栈
 * @author: yrq
 * @create: 2020-02-21 21:57
 **/
public class _操作栈 {
    public static void main(String[] args) {
        int[][] opt = new int[][]{
                {12,0},{-10,0},{25,0}
                ,{26,0},{1000,1},{-16,0},{15,0},{99,1}};
        int size = 2;
        //动态二维数组
        ArrayList<ArrayList<Integer>> res =   fun(opt,size);
        for (ArrayList<Integer> curStack: res) {
            for (Integer e:curStack) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> fun(int[][] optt, int size) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curStack = new ArrayList<>(size);
        res.add(curStack);
        for (int[] opt: optt) {
            int op = opt[1];
            int value = opt[0];
            if(op==0){
                if(curStack.size()==size){
                    curStack = new ArrayList<>(size);
                    res.add(curStack);
                }
                //表示入栈
                curStack.add(value);
            }else {
                if(curStack.size()==0){
                    res.remove(curStack);
                    curStack = res.get(res.size()-1);
                }
                //表示出栈
                curStack.remove(curStack.size()-1);

            }
        }
        return res;
    }
}
