package 数据结构之链表;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: lanqiaobei2020
 * @description:   将链表进行翻转以后在比较 是否相等就可以了
 * @author: yrq
 * @create: 2020-02-21 19:45
 **/
public class Test_判断回文链 {
    static int len = 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node();
        Node p =head;
        for (int i = 1; i <= len; i++) {
            int k = sc.nextInt();
            Node newNode = new Node(k);
            p.next = newNode;
            p = p.next;
        }
        Node newNode = reverse(head);
        System.out.println(check(head,newNode));
        System.out.println(check2(head));


    }

    private static boolean check2(Node head) {
        Stack<Integer> stack =new Stack<>();
        Node s = head;
        Node f = head;
        if(len%2!=0){
            while (f!=null){
                s=s.next;
                f=f.next.next;
                stack.push(s.data);
            }
            s=s.next;
            stack.pop();
        }else {
            while (f.next!=null){
                s=s.next;
                f=f.next.next;
                stack.push(s.data);
            }
            s=s.next;
        }


        while (s.next!=null){
            if(s.data!=stack.pop()){
                return false;
            }
            s=s.next;
        }
        return true;
    }

    private static boolean check(Node head, Node newNode) {
        Node newP = newNode;
        Node p = head;
        while (p.next!=null&&newP.next!=null){
            p=p.next;
            newP = newP.next;
            if(p.data!=newP.data){
                return false;
            }
        }
        return true;
    }


    private static Node reverse(Node head) {
        Node newHead = new Node();
        Node p = head;
        //反转单链表就是进行头插   最好是新建Node 不然出现了循环链表了
        while (p.next != null){
            p = p.next;
            Node pH = new Node(p.data);
            if(newHead.next ==null){
                newHead.next = pH;
            }else {
                pH.next = newHead.next;
                newHead.next = pH;
            }
        }
        return newHead;
    }

    static class Node{
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.next = null;
            this.data = data;
        }

        public Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }
    }
}
