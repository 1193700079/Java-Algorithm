package game;

public class A {
		public static void main(String[] args){
			int flag =0;
			for(int i=2;;i++){
				if(check(i)){
					flag++;
					if(flag==300){
						System.out.println(i);
						break;
					}
					
				}
			}
			System.out.println("hello");
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
