package 计蒜客模拟赛题.练习赛2;

/**
 * @program: lanqiaobei2020
 * @description:  4271*4271*4271-1972*1972*1972-4126*4126*4126
 * -4126 -1972 4271
 * @author: yrq
 * @create: 2020-03-01 12:52
 **/
public class C_立方和 {
    public static void main(String[] args) {
        System.out.println(4271*4271*4271-1972*1972*1972-4126*4126*4126);
//        for (long i = -5000; i <=5000 ; i++) {
//            for (long j = -5000; j <=5000 ; j++) {
//                for (long k = -5000; k <=5000 ; k++) {
//                    if(isok(i,j,k)){
//                        System.out.println(i+" "+j+" "+k);
//                    }
//                }
//            }
//        }
    }

    private static boolean isok(long i, long j, long k) {
        long a  = i*i*i;
        long b  = j*j*j;
        long c  = k*k*k;
        if(a+b+c==87){
            return true;
        }
        return false;
    }
}
