package 规则;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-17 17:45
 **/
import java.util.Scanner;
import java.util.Vector;
class Main {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int m = input.nextInt();
//        System.out.println(f(n, m));
//        String s = "1|2|3|4";
//        String[] strs = new String[4];
//              strs =  s.split("|");
//        System.out.println(strs.length);
//        String s1 = "156";
//        String s2 = "124";
//        String s3 = "2";
//        System.out.println(s.compareTo(s2));
//        System.out.println(s2.compareTo(s3));
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println(a+b);
//        }
        System.out.println(c(10,3));
        String s= "abced";
        System.out.println(s.substring(s.length()-4));


    }
    //排列组合算法  从n中选取m个
    static long c(int n, int m){
        if(m>n){
            return 0;
        }
        long ans =1;
        if(m>n-m){
            m = n-m; //因为C 5 2 和 C 5 3等价
        }
        int j=m;
        for (int i = n; j>0; i--) {
            ans*=i;
            j--;
        }
        for (int i = m; i >=2 ; i--) {
            ans/=i;
        }
        return ans;
    }
    public static int f(int n, int m) {
        n = n % m;
        Vector<Integer> v = new Vector<Integer>();

        for(;;) {
            v.add(n);
            n *= 10;
            n = n % m;
            if(n == 0) return 0;
            if(v.indexOf(n) >= 0) {  //indexOf 表示查询n的下标 有则返回一个>=0 的数
                // 在下面填入代码
                return v.size()-v.indexOf(n);
            }
        }
    }
}
