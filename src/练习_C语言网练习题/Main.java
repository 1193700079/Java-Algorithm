package 练习_C语言网练习题;


import java.util.Scanner;



public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {

			String s = sc.nextLine();

			String arr[] = s.split("\\."); //注意转换

			char dex = 'Y';

			for (int i = 0; i < arr.length; i++) {

				if (arr[i].startsWith("0")) {

					dex = 'N';

					break;

                               }

				try//-----尝试，如果不是整数dex=‘N’，跳出

               {

				if (Integer.valueOf(arr[i]).intValue() <= 255//将arr【i】转换成整数

						& Integer.valueOf(arr[i]).intValue() >= 0) {

               } else {

					dex = 'N';

					break;

               }

               } catch (Exception e)

               {

				dex='N';

				break;

               }
 			}

		System.out.println(dex);
		}

	}

}
