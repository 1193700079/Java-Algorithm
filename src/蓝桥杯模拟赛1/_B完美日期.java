package 蓝桥杯模拟赛1;

/**
 * @program: lanqiaobei2020
 * @description:
public class Main{
    public static void main(String[] args){
        System.out.println("2022/03/07");
    }
}
 * @author: yrq
 * @create: 2020-02-22 13:30
 **/
public class _B完美日期 {
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 2020; i <= 2030; i++) {
            String si = i+"";
            for (int j = 1; j <=12 ; j++) {
                if(i==2020&&j==1){
                    continue;
                }
                String sj =j+"";
                if(sj.length()==1){
                    sj = "0"+sj;
                }
                for (int k = 1; k <=31 ; k++) {
                    if(i==2020&&j==2&&k<22){
                        continue;
                    }
                    String sk =k+"";
                    if(sk.length()==1){
                        sk = "0"+sk;
                    }
                    if(j==2){
                        if(i%4==0){
                            //说明为闰年
                            if(k==30){
                                break;
                            }
                        }
                        if(k==29){
                            break;
                        }
                    }
                    if(j==4||j==6||j==9||j==10){
                        if(k==31){
                            break;
                        }
                    }
                    String str =si+sj+sk;
                    char[] c = str.toCharArray();
                    int sum = 0;
                    for (int l = 0; l < c.length; l++) {
                        if(c[l]=='4'){
                            sum = 1;
                            break;
                        }
                        sum+= (c[l]-'0');
                    }
                    if(sum%8==0){
                        cnt++;
                    }
                    if(cnt == 88){
                        System.out.println(str);
                        System.exit(0);
                    }

                }
            }
        }
    }
}
