package 计蒜客模拟赛题.练习赛1;

/**
 * @program: lanqiaobei2020
 * @description:爬楼梯
 * @author: yrq
 * @create: 2020-01-18 13:13
 **/
public class Main2 {
    public static void main(String[] args) {
        int n =10; //10个台阶
        int ans = fun(n);
        System.out.println(ans);
    }
    public static int fun(int n){
        if(n==0||n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else if(n==3){
            return 4;
        }else if(n==4){
            return 8;
        }else if(n==5||n==7){
            return 0;
        }else {
            return fun(n-1)+fun(n-2)+fun(n-3)+fun(n-4);
        }
    }
}
