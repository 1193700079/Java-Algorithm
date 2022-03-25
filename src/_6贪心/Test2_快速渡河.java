package _6贪心;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-10 14:00
 **/
public class Test2_快速渡河 {
    static int ans;
    public static void main(String[] args) {
        int n = 4;
        int[] arr = new int[]{1,2,3,4};
        f(n,arr);
        System.out.println(ans);
    }

    private static void f(int n, int[] arr) {
        int left = n;
        while (left>0){
            if(left==1){
                ans+=arr[0];
                break;
            }else if (left==2){
                ans+=arr[1];
                break;
            }else if(left==3){
                ans+=arr[1]+arr[0]+arr[2];
                break;
            }else {
                // 1,left出发 1返回 1,left-1出发 1返回   (只靠1带)
                int a1 = arr[left-1]+arr[0]+arr[left-2]+arr[0];
                // 1,2出发 1返回 最后两个出发 2返回   (靠1,2带)
                int a2 = arr[1]+arr[0]+arr[left-1]+arr[1];
                ans+=Math.min(a1,a2);
                left-=2;
            }

        }
    }
}
