package 练习_C语言网练习题;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:  合理利用 try catch 以及 字符串转变成数字
 * 题目描述
 * 在基于Internet的程序中，我们常常需要判断一个IP字符串的合法性。
 * 合法的IP是这样的形式：
 * A.B.C.D
 * 其中A、B、C、D均为位于[0, 255]中的整数。为了简单起见，我们规定这四个整数中不允许有前导零存在，如001这种情况。
 * 现在，请你来完成这个判断程序吧^_^
 *
 * 输入
 * 输入由多行组成，每行是一个字符串，输入由“End of file”结束。
 * 字符串长度最大为30，且不含空格和不可见字符
 *
 * 输出
 * 对于每一个输入，单独输出一行
 * 如果该字符串是合法的IP，输出Y，否则，输出N
 *
 * 样例输入
 * 1.2.3.4
 * a.b.c.d
 * 267.43.64.12
 * 12.34.56.bb
 * 210.43.64.129
 * -123.4.5.6
 * 样例输出
 * Y
 * N
 * N
 * N
 * Y
 * N
 * @author: yrq
 * @create: 2020-02-20 16:34
 **/
public class Test3_IP判断 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            fun(s);
        }
    }

    private static void fun(String s) {
        String sc = s.replace("."," ");
        String[] c = sc.split(" ");
        if(c.length != 4){
            System.out.println("N");
            return;
        }
        for (String str:c) {
            if(str.startsWith("0")){
                System.out.println("N");
                return;
            }
            try {
                if(Integer.valueOf(str).intValue() > 255 || Integer.valueOf(str).intValue() < 0){
                    System.out.println("N");
                    return;
                }
            }catch (Exception e){
                System.out.println("N");
                return;
            }
           /* if(str.startsWith("0")){
                System.out.println("N");
                return;
            }
            char[] cc = str.toCharArray();
            int a=0;
            for (int i = 0; i < cc.length; i++) {
                if(cc[i]<'0' || cc[i]>'9') {
                    //说明有非法字符
                    System.out.println("N");
                    return;
                }
                a+= (cc[i]-'0')*(cc.length-1-i)*10;
            }
            if(a>255||a<0){
                System.out.println("N");
                return;
            }*/
        }
        System.out.println("Y");
    }
}

