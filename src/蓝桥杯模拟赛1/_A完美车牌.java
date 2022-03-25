package 蓝桥杯模拟赛1;

/**
 * @program: lanqiaobei2020
 * @description:  125
 * @author: yrq
 * @create: 2020-02-22 13:08
 **/
public class _A完美车牌 {
    public static void main(String[] args) {
        int cnt=0;
        for (int i = 0; i <= 999999 ; i++) {
            String sb= i+"";
            if(sb.length()<6){
                int len = 6-sb.length();//5
                for (int j = 0; j < len; j++) {
                    sb = "0"+sb;
                }
            }
            char[] c = sb.toCharArray();
            int sum = 0;
            int len = c.length;
            for (int j = 0; j < c.length/2; j++) {
                if(c[j]=='0'){
                   if( c[len-j-1]=='0')  sum++;
                }else if (c[j]=='1'){
                    if( c[len-j-1]=='1')  sum++;
                }else if(c[j]=='8'){
                    if( c[len-j-1]=='8')  sum++;
                }else if (c[j]=='6'){
                    if( c[len-j-1]=='9')  sum++;
                }else if(c[j]=='9'){
                    if( c[len-j-1]=='6')  sum++;
                }
            }
            if(sum==3){
                cnt++;
                System.out.println(sb);
            }
        }
        System.out.println(cnt);
    }
}
