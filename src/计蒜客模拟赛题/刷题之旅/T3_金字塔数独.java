package 计蒜客模拟赛题.刷题之旅;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-26 16:01
 **/
public class T3_金字塔数独 {
    static int n = 9;
    static int[][] points=new int[][]{
            {6,6,6,6,6,6,6,6,6},
            {6,7,7,7,7,7,7,7,6},
            {6,7,8,8,8,8,8,7,6},
            {6,7,8,9,9,9,8,7,6},
            {6,7,8,9,10,9,8,7,6},
            {6,7,8,9,9,9,8,7,6},
            {6,7,8,8,8,8,8,7,6},
            {6,7,7,7,7,7,7,7,6},
            {6,6,6,6,6,6,6,6,6},
    };
    static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new char[9][9];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split("\\s");
            for (int j = 0; j < n; j++) {
                arr[i][j] = s[j].charAt(0);
            }
        }
        dfs(arr,0,0);
        System.out.println(max);


    }
    public static int max = -1;
    public static int[][] a = new int[9][9];

    static int getPoint() {
        int sum = 0;
        for(int i =0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sum = sum + (arr[i][j]-'0') * points[i][j];
            }
        }
        return sum;
    }

    private static void dfs(char[][] arr, int x, int y) {
        if(x==9){
           max = Math.max(max,getPoint());
            return;
        }
        if(arr[x][y]=='0'){
            for (int i = 1; i <= 9 ; i++) {
                if(check(arr,x,y,i)){ //检查合不合法
                    arr[x][y]=(char)('0'+i);
                    dfs(arr,x+(y+1)/9,(y+1) % 9);// x+(y+1)/9 表示当y到末尾的时候x+1                (y+1) % 9表示y+1一定不会到9
                }
            }
            arr[x][y]='0'; //回溯
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


//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    a[i][j] = arr[i][j]+'0';
//                }
//            }
//            int ans =a[4][4]*10;
//            //上  下  左 右
//            for (int i = 3,j=5; i >=0&&j<n ; i--,j++) {
//                int b= i+6;
//                ans+=(a[i][4]*b);
//                ans+=(a[j][4]*b);
//                ans+=(a[4][i]*b);
//                ans+=(a[4][j]*b);
//                ans+=(a[i][i]*b);
//                ans+=(a[j][j]*b);
//                ans+=(a[i][j]*b);
//                ans+=(a[j][i]*b);
//            }