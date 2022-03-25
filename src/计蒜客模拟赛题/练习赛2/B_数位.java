package 计蒜客模拟赛题.练习赛2;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-01 12:48
 **/
public class B_数位 {
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 1; i <=2020 ; i++) {
            String s = i+"";
            if(isOK(s)){
                ans+=i*i;
            }
        }
        System.out.println(ans);
    }

    private static boolean isOK(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='2'||s.charAt(i)=='0'){
                return true;
            }
        }
        return false;
    }
}
