package 蓝桥杯模拟赛3;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-07 18:32
 **/
public class C_日期进制 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int YY=scanner.nextInt();int modY=0,modM=0,modD=0;
        int MM=scanner.nextInt();
        int DD=scanner.nextInt();
        int d=scanner.nextInt();
        if(d>0){
            while (d-->0){
                DD++;
                if(DD==14){
                    MM++;DD=1;
                }
                if(MM==24){
                    YY++;MM=1;
                }
            }
        }else {
            d*=-1;
            while (d-->0){
                DD--;
                if(DD==0){
                    MM--;DD=13;
                }
                if(MM==0){
                    YY--;MM=23;
                }
            }
        }
        System.out.println(YY+" "+ MM+" "+DD);

    }
}
