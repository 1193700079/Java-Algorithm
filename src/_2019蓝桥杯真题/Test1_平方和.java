package _2019蓝桥杯真题;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-20 21:20
 **/
public class Test1_平方和 {
    public static void main(String[] args) {
        long sum =0;
        for (int i = 1; i <=2019 ; i++) {
            String s = i+"";
            char[] c = s.toCharArray();
            boolean flag =true;
            for (int j = 0; j < c.length; j++) {
                if(c[j]=='2'||c[j]=='0'||c[j]=='1'||c[j]=='9'){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                sum+=(i*i);
            }
        }
        System.out.println(sum);
    }
}
