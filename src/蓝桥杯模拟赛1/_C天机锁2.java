package 蓝桥杯模拟赛1;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-22 19:22
 **/
public class _C天机锁2 {
    static  int arr[] = new int[8];
    static  int cnt;
    public static void main(String[] args) {
       dfs(-1,0);
        System.out.println(cnt);
    }

    private static void dfs(int j, int n) {
        if(j==7) {
            int sum = 0;
            boolean flag2 = false;
            int count4 = 0;
            int count9 = 0;
            for (int k = 0; k < arr.length; j++) {
                if(!flag2 &&arr[k]==2){
                    flag2 = true;
                }
                sum+=arr[k];
                if(sum>52){
                    break;
                }
                else if(arr[k]==4){
                    count4++;
                }
                else if(arr[k]==9){
                    count9++;
                }
            }
            if(flag2 && count4==count9){

                cnt++;
            }
            return;
        }
        for (int i = 0; i <=9 ; i++) {
            arr[n] = i;
            dfs(j+1,arr[n]);//第一个表示第几位 第二个表示位的值
        }
    }

}
