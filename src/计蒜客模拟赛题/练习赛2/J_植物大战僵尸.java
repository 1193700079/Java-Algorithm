package 计蒜客模拟赛题.练习赛2;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-01 16:13
 **/
public class J_植物大战僵尸 {
        static int n;
        static long a[];
        static long m;
        static long max = 1000000000002L;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            m = sc.nextLong();
            a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            long l =1,r=10;
            while (l<=r){
                long mid = l+((r-l)>>1);
                if(check(mid)){
                    l = mid+1;
                }else {
                    r = mid-1;
                }
            }
            System.out.println(l-1);
        }

    private static boolean check(long mid) {
            long sum=0,temp=0,tempn=0; //temp是本次需要多少天
        for (int i = 0; i < n; i++) {
            if(mid%a[i]!=0){
                temp = mid / a[i]+1;//正常情况下需要经过的次数
            }else {
                temp = mid / a[i];
            }
            temp-=tempn;  //减去之前经过的次数（如果小于等于0说明之前已经来过 且）
            if(temp<=0){ //（如果小于等于0说明之前已经来过 且使得达到了最大值）
                if(i!=n-1){
                    temp =1;  //如果不是最后一个植物说明 应该继续往后走（把后面的植物填充 所有还是要走一次）
                }else {
                    temp = 0;// 是最后一个植物的话就说明已经全部走完了！
                }
                tempn=0;//
            }else{
                tempn = temp -1;   //tempn 表示之前经过了多少次
            }
            sum+=temp+tempn; //总共需要的天数（本次经历的次数+之前经历的次数 == 需要的天数）
            if(sum>m){
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long m = sc.nextLong();
//        int[] a = new int[n];
//        int[] ans = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//            ans[i] =a[i];
//        }
//        if(m<n){
//            System.out.println(0);
//            System.exit(0);
//        }
//        if(m==n){
//            int min = minOfArr(ans);
//            System.out.println(min);
//            System.exit(0);
//        }
//        int j=n-1;
//        for (long i = n; i < m; i++) {
//            if(i==n){
//                j--;
//                ans[j]+=a[j];
//            }else {
//                int minIndex = minOfArrIndex(ans);
//                if(minIndex<j){
//                    j--;
//                }else {
//                    j++;
//                }
//                ans[j]+=a[j];
//            }
//        }
//        System.out.println(minOfArr(ans));
//    }
//
//    private static int minOfArrIndex(int[] ans) {
//        int min = Integer.MAX_VALUE;
//        int index=-1;
//        for (int i = 0; i < ans.length; i++) {
//            if(ans[i]<min){
//                min = ans[i];
//                index = i;
//            }
//
//        }
//        return index;
//    }
//
//    private static int minOfArr(int[] ans) {
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < ans.length; i++) {
//            min = Math.min(min,ans[i]);
//        }
//        return min;
//    }
}
