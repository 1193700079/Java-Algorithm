package 蓝桥杯模拟塞2;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:  1208
 * 116280
 * 27202
 * @author: yrq
 * @create: 2020-02-29 13:33
 **/
public class C_四大名著 {
    static int[] res = new int[31];
    public static void main(String[] args) {
        Arrays.fill(res,-1);
        int ans = dfs(30);
        System.out.println(ans);
    }

    private static int dfs(int i) {
        if(i<0){
            return 0;
        }
        if(i==0){
            return 1;
        }
        if(res[i]>0){
            return res[i];
        }

        res[i] = dfs(i-3)+dfs(i-4)+dfs(i-5)+dfs(i-3)+dfs(i-1);
        return res[i];
    }
}
class Main{
    public static int cont=0;
    public static char[] chr= {'a','b','c','d'};
    public static void main(String[] args) {
        int[] arr= {4,3,3,5};
        dfs(arr,31,"");
        System.out.println(cont);
    }
    public static void dfs(int arr[],int k,String st) {
        if(st.length()==4) {
            cont++;
            return;
        }
        if(k<0) {

            return;
        }

        //什么都不看
        dfs(arr, k-1, st);
        //选择一本书
        n1:for (int i = 0; i < 4; i++) {
            //判断是否看过的书
            for (int j = 0; j < st.length(); j++) {
                //System.out.println(st.charAt(j)+"  "+chr[i]);
                if(st.charAt(j)==chr[i]) {
                    continue n1;
                }
            }
            if(k>=arr[i]) {
                dfs(arr, k-arr[i],st+String.valueOf(chr[i]));
            }

        }
    }
}
