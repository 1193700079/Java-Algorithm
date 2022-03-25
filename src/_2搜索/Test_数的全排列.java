package _2搜索;

import java.util.Scanner;

public class Test_数的全排列 {

    static int n;
    static int[] book;  //标记数组
    static int[] arr;   //结果存放数组
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        book = new int[n];
        arr = new int[n];
        dfs(0);
    }

    private static void dfs(int step) {
        if(step==n){
            //搜索出口最底层
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            if (book[i]==0){
                book[i]=1;
                arr[step]=i+1;
                dfs(step+1);
                book[i]=0;
            }
        }
    }
}
