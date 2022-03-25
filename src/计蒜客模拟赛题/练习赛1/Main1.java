package 计蒜客模拟赛题.练习赛1;

/**
 * @program: lanqiaobei2020
 * @description: 有趣的数
 * @author: yrq
 * @create: 2020-01-18 13:02
 **/
public class Main1 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 100000; i++) {
            if(isPrime(i)){
                //如果是质数
                if(isContainFive(i)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isContainFive(int i) {
        String s = i+"";
        char[] c= s.toCharArray();
        for (int j = 0; j < c.length; j++) {
            if(c[j]=='5'){
                return true;
            }
        }
        return false;

    }

    private static boolean isPrime(int i) {
        //0和1既不是质数、也不是合数。2是质数
        if(i==1&&i==2){
            return true;
        }
        for (int j = 2; j < i; j++) {
            if(i%j==0){
                return false;
            }
        }
        return true;
    }

}
