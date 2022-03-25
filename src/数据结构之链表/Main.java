package 数据结构之链表;

import java.util.*;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-21 20:16
 **/
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        for (int i = 1; i <= 5; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            queue.offer(i);
        }
        System.out.println(queue.element());
        System.out.println(queue.peek());
        for (int i = 1; i <= 5; i++) {
            System.out.print(queue.poll() + " ");
        }

        System.out.println();


    }

}
