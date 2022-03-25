package 蓝桥杯模拟塞2;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-29 14:33
 **/
public class G_卖柠檬养乐多 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //天数
        int a = sc.nextInt();  //需要养乐多的数量
        int b = sc.nextInt();  //需要柠檬片的数量


        int  qian1 = Integer.MAX_VALUE; //任取一个任意大的数
        int  qian2 = Integer.MAX_VALUE; //任取一个任意大的数
        long res = 0;
        int sy = 0; //剩余的数量
        int lmjg=0;
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();  // 卖出的数量
            int pa = sc.nextInt();  // 养乐多的价格
            int pb = sc.nextInt();  // 一盒柠檬的价格
            qian1 = Math.min(qian1,pa);
            qian2 = Math.min(qian2,pb);
            if((c*b-sy)%80!=0){
                lmjg = (c*b-sy)/80*qian2+qian2;  //计算出所购买柠檬的价格
                sy=((c*b-sy)/80+1)*80-c*b;  //再次计算出剩余量
            }else{
                sy=0;
                lmjg = c*b/80*qian2;
            }
            res=res+c*a*qian1+lmjg;
        }
        System.out.println(res);
    }
}
