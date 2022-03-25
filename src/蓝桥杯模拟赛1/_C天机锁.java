package 蓝桥杯模拟赛1;

import java.util.ArrayList;

/**
 * @program: lanqiaobei2020
 * @description:
public class Main{
    public static void main(String[] args){
        System.out.println("19811435");
    }
}
19843796
19836103
 * @author: yrq
 * @create: 2020-02-22 13:40
 **/
public class _C天机锁 {
    public static void main(String[] args) {
        int cnt = 0;
        int le = 8;
        for (int i = 2; i <= 99999999 ; i++) {
            String sb= i+"";
            if(sb.length()<le){
                int len = le-sb.length();//5
                for (int j = 0; j < len; j++) {
                    sb = "0"+sb;
                }
            }
            char[] c= sb.toCharArray();
            int sum=0;
            int tow = 0;
            int count4 = 0;
            int count9 = 0;
            for (int j = 0; j < c.length; j++) {
                if(c[j]=='2'){
                    tow++;
                }
                else if(c[j]=='4'){
                    count4++;
                }
                else if(c[j]=='9'){
                    count9++;
                }
                sum+=(c[j]-'0');
            }
            if(tow>0 && count4==count9 &&sum<=52){
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
