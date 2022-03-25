package 数据结构之链表;

import java.util.HashSet;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-21 10:45
 **/
public class Test3_判断有无环链表 {
    public static void main(String[] args) {
        Node head = new Node();
        Node p = head;
        Node p2 = new Node();
        for (int i = 1; i <=5 ; i++) {
            p.next = new Node(i);
            p=p.next;
            if(i==3){
                p2 = p;
            }
        }
        p.next = p2;
//        print(head);
        HashSet<Node> set = new HashSet<>();
        p=head;
        while (true){
            if(set.contains(p)){
                System.out.println(p.data);
                break;
            }else {
                set.add(p);
                p=p.next;
            }
        }
        System.out.println(hasCircle(head));
    }

    private static Boolean hasCircle(Node head) {
        Node s = head;
        Node f = head;
        while (true){
            s = s.next;
            f = f.next.next;
            if(s==f){
                return true;
            }
            if(f.next==null){
                return false;
            }
        }
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
