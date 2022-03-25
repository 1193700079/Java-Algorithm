package 数据结构之链表;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-21 09:33
 **/
public class Test2_链表求和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node();
        Node p =head;
        for (int i = 1; i <= 4; i++) {
            int k = sc.nextInt();
            Node newNode = new Node(k);
            p.next = newNode;
            p = p.next;
        }
        System.out.println(p.next);
        Node newHead = new Node();
        p = head;
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
        print(newHead);

    /*    Node head2 = new Node();
        Node p2 =head2;
        for (int i = 1; i <= 4; i++) {
            int k = sc.nextInt();
            Node newNode = new Node(k);
            p2.next = newNode;
            p2 = p2.next;
        }
         p = head;
         p2 = head2;
        while (p.next!=null) {
            p=p.next;
            p2=p2.next;
            p.data += p2.data;
        }

        p =head;
        while (p.next!=null){
            p=p.next;
            System.out.println(p.data);
        }
        System.out.println(head.data+"*");*/

    }

    private static void print(Node newHead) {
        Node p =newHead;
        while (p.next!=null){
            p=p.next;
            System.out.print(p.data+" ");
        }
        System.out.println();
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
