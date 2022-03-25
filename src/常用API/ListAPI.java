package 常用API;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-19 14:09
 **/
public class ListAPI {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("yrq",28));
        students.add(new Student("xht",22));
        students.add(new Student("pxz",49));
        students.add(new Student("yzx",51));

        //传递了一个比较器comparator 也可以让Student类 实现comparable接口
        Collections.sort(students,(o1, o2) -> {return  o1.getAge()-o2.getAge();});
        System.out.println(students);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(12);
        linkedList.add(18);
        System.out.println(linkedList.get((linkedList.size()-1)-0));
    }
}
