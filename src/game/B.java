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
		//���13����  0~12  ��ʾ1~13
		d+=t;	
		if(d>=0){
			nd = d%13; //�õ��µ�����  ����13
			k1 = d/13;                  //��λ
		}else{
			nd = d%13+13; //�õ��µ�����  ����13
			k1 = d/13;                  //��λ
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
