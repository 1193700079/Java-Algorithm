package _2019蓝桥杯真题;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-20 23:32
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int k = sc.nextInt();
        String s=sc.nextLine();
        s=sc.nextLine(); //这样输入就是指输入一行
        String name1 = "Alice";
        String name2 = "Bob";
        int length = k;
        int result = getNum(s,name1,name2,length);
        System.out.println(result);
    }
    public static int getNum(String string,String name1,String name2,int length){
        int num = 0;
        int first; // 第一次出现的地方索引
        String name;  // 要匹配的名字
        String cName; // 当前名字
        // 1.截取第一次出现后的20个字符
        while (string.length() != 0) {
            int name1First = string.indexOf(name1);
            int name2First = string.indexOf(name2);
            // 使用了第一次出现的较早的索引，匹配的名应该为第一次出现的较晚的名字
            first = name1First > name2First ? name2First : name1First;
            name = name1First > name2First ? name1 : name2;
            cName = name1First > name2First ? name2 : name1;
            if(first == -1){
                break;
            }
            String subString;
            try{
                subString = string.substring(first, first + length);
            }catch (Exception e){
                subString = string.substring(first);
            }
            // 2.遍历这20个字符内是否包含有另外一个名字
            for (int i = 0; i < subString.length() - name.length(); i++) {
                String temp = subString.substring(i, i + name.length());
                // 3.若有，判断前后是否有字母：有，继续2；没有++；继续2；
                if (temp.equals(name)) {
                    // 判断前后是否是字母
                    if (!isLetter(subString.charAt(i - 1)) && !isLetter(subString.charAt(i + name.length()))) {
                        num++;
                    }
                }
            }
            string = string.substring(first+cName.length());
        }
        // 4.若没有，截去开头到这个名字后的字符串，拿后半段继续执行1
        return num;
    }

    public static boolean isLetter(char c) {
        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
            return true;
        }
        return false;
    }
}
