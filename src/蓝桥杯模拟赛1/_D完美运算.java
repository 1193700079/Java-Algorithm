package 蓝桥杯模拟赛1;

/**
 * @program: lanqiaobei2020
 * @description:
public class Main{
    public static void main(String[] args){
        System.out.println("472701");
    }
}
2041210
 * @author: yrq
 * @create: 2020-02-22 14:03
 **/
public class _D完美运算 {

    public static void main(String[] args) {
        String s = Integer.toString(4,3);
        System.out.println(s);
        int ans = 0;
        for (int i = 1; i <=2020 ; i++) {
            int a1 = fun1(i); //求三进制中 1的个数
            int a2 = fun2(i); //求三进制中 2的个数
            for (int j = i; j <=2020 ; j++) {
                int b1 = fun1(j); //求三进制中 1的个数
                int b2 = fun2(j); //求三进制中 2的个数
                if(Math.abs(a1-a2)==Math.abs(b1-b2)){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static int fun2(int i) {
        String s = Integer.toString(i,3);
        char[] c =s.toCharArray();
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            if(c[j]=='2'){
                res++;
            }
        }
        return res;
    }

    private static int fun1(int i) {
        String s = Integer.toString(i,3);
        char[] c =s.toCharArray();
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            if(c[j]=='1'){
                res++;
            }
        }
        return res;
    }
}
