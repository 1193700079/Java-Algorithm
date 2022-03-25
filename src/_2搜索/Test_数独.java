package _2搜索;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description: dfs 经典模板 解决数独问题
 * 使用 递归加回溯
 * @author: yrq
 * @create: 2020-01-20 19:03
 **/
public class Test_数独 {
    static int n = 9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[9][9];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split("\\s");
            for (int j = 0; j < n; j++) {
                arr[i][j] = s[j].charAt(0);
            }
        }
        dfs(arr,0,0);


    }

    private static void dfs(char[][] arr, int x, int y) {
        if(x==9){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        if(arr[x][y]=='*'){
            for (int i = 1; i <= 9 ; i++) {
                if(check(arr,x,y,i)){ //检查合不合法
                    arr[x][y]=(char)('0'+i);
                    dfs(arr,x+(y+1)/9,(y+1) % 9);// x+(y+1)/9 表示当y到末尾的时候x+1                (y+1) % 9表示y+1一定不会到9
                }
            }
            arr[x][y]='*'; //回溯
        }else {
            dfs(arr,x+(y+1)/9,(y+1)%9);
        }

    }

    private static boolean check(char[][] arr, int x, int y ,int k) {
        //检查同行同列
        for (int i = 0; i < 9; i++) {
            if(arr[x][i]==(char)('0'+k)){
                return false;
            }
            if(arr[i][y]==(char)('0'+k)){ //检查行
                return false;
            }
        }
        //检查每一个九宫格  牛逼啊
        for (int i = (x/3)*3; i < (x/3+1)*3; i++) {
            for (int j = (y/3)*3; j < (y/3+1)*3; j++) {
                if(arr[i][j]==(char)('0'+k)){
                    return false;
                }
            }
        }
        return true;
    }
}
