import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-02 15:23
 **/
public class Main {
    static  int vis[] = new int[10];
    static  double a[] = new double[100];
    static int aa;
    static int bb;
    static int cc;
    static int ans=0;
    static double s;
    static double x;
    static List<String> list = new ArrayList<>();
    static long[][][] rec;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            long a =sc.nextLong();
            long b =sc.nextLong();
            long c= sc.nextLong();
            if(a==-1&&b==-1&&c==-1){
                System.exit(0);
            }
            rec =new long[21][21][21];
           if(a<=0||b<=0||c<=0){
                System.out.println("w("+a+", "+b+", "+c+")"+" = "+1);
            }else if(a>20||b>20||c>20){
               long ans = dfs(20,20,20);
               System.out.println("w("+a+", "+b+", "+c+")"+" = "+ans);
           }else {
               long ans = dfs((int)a,(int)b,(int)c);
               System.out.println("w("+a+", "+b+", "+c+")"+" = "+ans);
           }

        }

    }

    private static long dfs(int a, int b, int c) {
        if(rec[a][b][c]>0){
            return rec[a][b][c];
        }

        if(a<=0||b<=0||c<=0) return 1;
        if(a>20||b>20||c>20) {
            rec[20][20][20] = dfs(20,20,20);
            return rec[20][20][20];
        }

        if(a<b&&b<c) {
            rec[a][b][c] = dfs(a,b,c-1)+dfs(a,b-1,c-1)-dfs(a,b-1,c);
            return  rec[a][b][c];
        }


        rec[a][b][c] = dfs(a-1,b,c)+dfs(a-1,b-1,c)+dfs(a-1,b,c-1)-dfs(a-1,b-1,c-1);
        return rec[a][b][c];
    }


}
