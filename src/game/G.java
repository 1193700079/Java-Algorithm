package game;

import game.F.Student;

import java.util.Arrays;
import java.util.Scanner;

public class G {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		int num = 1;
		for(int i=0;i<n;i++){
			num*=sc.nextInt();
		}
		String s = Integer.toString(num, 6);
		int ans = 0;
		for(int i=s.length()-1;i>=0;i--){
			if(s.charAt(i)=='0'){
				ans++;
			}else{
				break;
			}
		}
		System.out.println(ans);
		
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
