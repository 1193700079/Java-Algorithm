package 蓝桥杯模拟赛1;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 *
 * import java.math.BigInteger;
 * import java.util.Scanner;
 * public class  Main {
 *     public static void main(String[] args) {
 *         Scanner sc = new Scanner(System.in);
 *         int n = sc.nextInt();
 *         BigInteger m = new BigInteger("2");
 *         System.out.println(m.pow(n-1));
 *     }
 * }
 * @author: yrq
 * @create: 2020-02-22 14:16
 **/
public class _G_JMboy去爬山 {
    static int n;
    static int[] book;  //标记数组
    static int[] arr;   //结果存放数组
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n<=2){
            System.out.println(1);
            System.exit(0);
        }
        book = new int[n];
        arr = new int[n];


        dfs(0);
        System.out.println(ans);
    }

    private static void dfs(int step) {
        if(step==n){
            //搜索出口最底层
            for (int i = 1; i < n-1; i++) {
                if(arr[i-1]>arr[i] && arr[i]<arr[i+1]){
                    return;
                }
            }
           ans++;
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
