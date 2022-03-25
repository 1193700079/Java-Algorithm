package 蓝桥杯官网练习系统;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-02 10:44
 **/
public class _309进制转换 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
//        int m = Integer.valueOf(s,8); //s作为8进制 输出变成10进制  valueOf 和 parseInt 都是int类型的返回值
        String a = Integer.toOctalString(n);//把n变成 8进制     toOctalString  是String类型的返回值
//        String b = Integer.toString(n,8);
        if(a.equals("0")){
            System.out.println(a);
        }else {
            System.out.println("0"+a);
        }

//        System.out.println("0"+b);
    }
}
