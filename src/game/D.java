package game;

import java.util.Scanner;

public class D {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] c = s.toCharArray();
		StringBuffer sb =new StringBuffer();
		for(int i=c.length-1,j=1;i>=0;i--,j++){
			if(j%3==0&&i!=0){
				sb.append(c[i]+",");
			}else{
				sb.append(c[i]);
			}
		}
		System.out.println(sb.reverse());
		
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
