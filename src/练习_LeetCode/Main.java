package 练习_LeetCode;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-25 09:43
 **/
public class Main {
    public static void main(String[] args) {
        int i=0;
        int j=1;
        int m = 5;
        int n = 5;
        boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
        System.out.println(isEdge);
    }
}
