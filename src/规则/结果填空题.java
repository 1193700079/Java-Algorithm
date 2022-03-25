package 规则;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-17 17:38
 **/
public class 结果填空题 {
    public static void main(String[] args) {
        int res=0;
        for (int i = 1; i <=100 ; i++) {
            res+=sum(i);
        }
        System.out.println(res);
    }
    private static int sum(int i){
        return (1+i)*i/2;
    }
}
