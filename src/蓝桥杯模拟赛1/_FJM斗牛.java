package 蓝桥杯模拟赛1;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-22 17:30
 **/
public class _FJM斗牛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = new char[5];
        for (int i = 0; i <5 ; i++) {
            String s =sc.next();
            c[i] =s.charAt(0);
        }
        for (int i = 0; i < c.length; i++) {
            if(c[i]=='S'||c[i]=='J'||c[i]=='Q'||c[i]=='K'||c[i]=='1'){
                    c[i]='0';
            }else if(c[i]=='A'){
                c[i]='1';
            }
        }
        int ans = -1; //-1表示没牛 0表示牛牛
        a1:for (int i = 0; i < c.length-2; i++) {
            for (int j = i+1; j < c.length-1; j++) {
                for (int k = j+1; k < c.length; k++) {
                    if(check(c[i],c[j],c[k])){
                        //有牛
                        int res = fun(i,j,k,c);
                        if(res==0){
                            ans = 0;
                            break a1;
                        }
                        ans = Math.max(ans,res);
                    }
                }
            }
        }
        if(ans==-1){
            System.out.println("so sad!");
        }else if(ans==0){
            System.out.println("so cool!");
        }else{
            System.out.println(ans);
        }
    }

    private static boolean check(char i, char j, char k) {
        int res = (i-'0') + (j-'0') + (k-'0');
        if( res==0||res%10==0){
            //说明有牛
            return  true;
        }
        return false;
    }

    private static int fun(int i, int j, int k,char[] c) {
        char a = ' ';
        char b = ' ';
        boolean flag = false;
        for (int l = 0; l < c.length; l++) {
            if(!flag && l!=i && l!=j && l!=k){
                a=c[l];
                flag =true;
                continue;
            }
            if(flag && l!=i && l!=j && l!=k){
                b=c[l];
                break;
            }
        }
        int ans = (a-'0') + (b-'0');
        return ans%10;

    }
}
