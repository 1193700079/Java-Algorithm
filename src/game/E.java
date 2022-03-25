package game;

import java.math.BigInteger;
import java.util.Scanner;

public class E {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String s1 =sc.next();
		BigInteger a = new BigInteger(s1);
		
		String s2 =sc.next();
		BigInteger b = new BigInteger(s2);
	
		BigInteger mod = new BigInteger("1000000007");

		
		System.out.println((a.multiply(b)).mod(mod));
	}
	
	public static boolean check(int k){
		if(k==2||k==3) return true;
		for(int i=2;i<=k/2;i++){
			if(k%i==0){
				return false;
			}
		}
		return true;
	}
}
