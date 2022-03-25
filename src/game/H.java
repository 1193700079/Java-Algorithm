package game;

import java.util.Scanner;
//找出a b c d的倍数就行 那么也是 a b的倍数 也是 a c的倍数 也是 b c的倍数 也是 abc的倍数 也是 bcd的倍数 也是abcd的倍数
//考察容斥原理
public class H {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		long n =sc.nextLong();
		int a =sc.nextInt();
		int b =sc.nextInt();
		int c =sc.nextInt();
		int d =sc.nextInt();
		long ans = 0;
		for(long i=1;i<=n;i++){
			if(i%a==0||i%b==0||i%c==0||i%d==0){
				ans++;
			}
		}
		System.out.println(ans);
		
	}
	static class Case_gcd{

		public static int gcd (int n,int m){
			return m==0?n:gcd(m,n%m);
		}
		public static int lcm(int a,int b){
			return a*b/gcd(a,b);
		}

		/* 贝祖公式 计算  ax+by = gcd(a,b)  如果是倍数的话 如  ax+by = gcd(a,b)*t  那么x y 只需要再除个t就好了 */
		static long x;
		static long y;
		public static long ex_gcd(long a,long b){
			if(b==0){
				x=1;
				y=0;
				return a;
			}
			long res = ex_gcd(b,a%b);
			long x1 = x;
			x = y;  //更新 x
			y =x1 - (a/b)*y;  // 更新 y  因为java里面用不了指针只能用全局变量来表示了哟
			return res;
		}

		/*线性方程  计算  ax+by = m  其中m如果不是gcd(a,b)的倍数的话则无解  */
		public static long linearEquation(long a,long b,long m) throws Exception {
			long d = ex_gcd(a,b);
			if(d%m!=0) throw new Exception("无解");
			long t =m/d;
			x*=t;
			y*=t;
			return  d;
		}

		/*计算 a在mo下的逆元  就是说 求 ax%mo = 1*/
		public static long inverseElement(long a,long mo) throws Exception {
			long d = linearEquation(a,mo,1);
			x = (x%mo+mo)%mo;
			return x;
		}
	}
}
