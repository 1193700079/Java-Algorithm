package _0蓝桥杯基础问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:     直到输入-1才停止输入
 * @author: yrq
 * @create: 2020-01-16 19:32
 **/
public class _1输入问题 {

    public static void main(String[] args) {

    }

    /**
     * 输入多组数据，不告知组数，也没有截止符
     */
    private static void method(){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){//判断是否数据结束
            int a=s.nextInt();
            int b=s.nextInt();
        }
    }

    /**
     * 输入多组数据，-1为截止符号
     */
    private static void method2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n!=-1){
            deal(n);
            n = sc.nextInt();
        }
    }

    /**
     * 使用更高效的buffer  不过要抛出异常
     */
    private static void method3() throws IOException {
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取第一行数据
        String line = br.readLine();
        // 将字符串根据空格进行分隔
        String[] strings = line.trim().split(" ");
        // 分别将其中的每个数值读出
        int r = Integer.parseInt(strings[0]);
        int c = Integer.parseInt(strings[1]);
    }

    private static void deal(int n) {
    }

}
