package 数据结构之树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-22 11:48
 **/
public class Tree<T> {
    class Node{
        T data;
        Node left;
        Node right;
        Node father;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.father = null;
        }

    }
    Node head;

    public Tree(T data) {
        head = new Node(data);
        head.left = null;
        head.right = null;
        head.father = null;
    }

    public Tree() {
    }

    public void addLeftNode(Node node, T data){
        Node NewNode = new Node(data);
        node.left = NewNode;
        NewNode.father = node;
    }

    public void addRightNode(Node node,T data){
        Node NewNode = new Node(data);
        node.right = NewNode;
        NewNode.father = node;
    }

    // 层序遍历
    public void bfs(){
        Node p  = head;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(p); //入队
        while (!queue.isEmpty()){
            Node n = queue.poll();
            //没有了相邻结点的元素就出队
            System.out.println(n.data);
            //所以相邻的入队
            if(n.left!=null){
                queue.offer(n.left);
            }
            if(n.right!=null){
                queue.offer(n.right);
            }
        }
    }

    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.print(node.data+" ");
            inOrder(node.right);
        }
    }


}
