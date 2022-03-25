package _9数论;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-04 09:51
 **/
public class _2Nim游戏 {
    public static void main(String[] args) {
        int[] a = new int[]{3,4,5};
        boolean flag = slove(a);
        if(flag){
            System.out.println("Alice 赢");
        }else {
            System.out.println("Bob 赢");
        }
    }

    private static boolean slove(int[] a) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            res^=a[i];
        }
        return res!=0;
    }


}
