package 计蒜客模拟赛题.练习赛1;

import java.util.*;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-20 20:32
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] c = s.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
        char a = c[0];
        String s1 = a+"";
        for (int i = 1; i < c.length; i++) {
            if(c[i]==a){
                s1 = s1+a;
            }else {
                a=c[i];
                if(i==c.length-1){
                    s1=a+"";
                    arrayList.add(s1);
                }else {
                    arrayList.add(s1);
                    s1=a+"";
                }
            }
        }
        HashSet<String> set = new HashSet<>();
        for (String str:arrayList) {
            set.add(str);
        }
        ArrayList<String> res_new = new ArrayList<>();
        for (String str:set) {
            res_new.add(str);
        }
        Collections.sort(res_new);
        for (String stringBuffer:res_new) {
            System.out.println(stringBuffer);
        }
    }

}
