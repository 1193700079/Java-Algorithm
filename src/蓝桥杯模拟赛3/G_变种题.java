package 蓝桥杯模拟赛3;

/**
 * @program: lanqiaobei2020
 * @description:
 * N!在3进制下尾0的个数
 * @author: yrq
 * @create: 2020-03-07 19:22
 **/
public class G_变种题 {
    public static void main(String[] args) {
        long n = 10;
        System.out.println(numOfZero(n));
        System.out.println(Integer.toString((int)factorial(n),3));
    }

    private static long factorial(long n) {
        if(n==1) return 1;
        return n*factorial(n-1);
    }

    private static long numOfZero(long n) {
        long count=0;
        while(n>0){
            count+=n/3;
            n=n/3;
        }
        return count;
    }
}
