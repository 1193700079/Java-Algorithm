package game;

import java.util.Scanner;

public class I {
    static int n;
    static int k;
    static double[] a;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		n =sc.nextInt();
		k =sc.nextInt();
		a = new double[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextDouble()*100;

		}

		int  l=0,r =Integer.MAX_VALUE;
		while (l<=r){
            int  mid = l+((r-l)>>1);
            if(check(mid)){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        double ans = 1.0*(double)r/100.0;
        System.out.printf("%.2f",ans);
	}

    private static boolean check(double mid) {
	    int cnt = 0;
        for (int i = 0; i < n ; i++) {
            cnt+= a[i] / mid;
            if(cnt>=k) return true;
        }
        return cnt >= k;
    }
}
