package game;

import java.util.Scanner;

public class B {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int y  = sc.nextInt();
		int m = sc.nextInt();
		int d = sc.nextInt();
		int t =sc.nextInt();
		int nd=0,k1=0,nm=0,k2=0;
	
		d--;
		m--;
		//变成13进制  0~12  表示1~13
		d+=t;	
		if(d>=0){
			nd = d%13; //得到新的日期  就是13
			k1 = d/13;                  //进位
		}else{
			nd = d%13+13; //得到新的日期  就是13
			k1 = d/13;                  //进位
		}
		m+=k1;
		if(m>=0){
			nm = m%23;
			k2 = m/23;
		}else{
			nm = m%23+23;
			k2 = m/23;
		}
		
		y+=k2;
		System.out.println(y+" "+(nm+1)+" "+(nd+1));
		
	}
	
}
