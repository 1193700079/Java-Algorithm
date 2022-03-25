package 数据结构之图.练习题;

import 数据结构之图.邻接表.GraphNode_AL;

import java.util.List;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-26 21:11
 **/
public class Test5_图的着色_二分图 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.add(n2);
        n1.add(n4);

        n2.add(n1);
        n2.add(n3);

        n3.add(n2);
        n3.add(n4);

        n4.add(n1);
        n4.add(n3);


        System.out.println(dfs(n1,1));
    }

    private static boolean dfs(Node n, int i) {
        n.color = i;
        for (int j = 0; j <n.getSize() ; j++) {
            Node node = (Node)n.getNeighbor(j);
            if(node.color==i){
                return false;
            }
            //一票否决机制  布尔型递归的特点
            if(node.color == 0 && dfs(node,-i)==false){
                return false;
            }
        }
        return true;

    }

    static class Node extends GraphNode_AL{
        int color ;
        public Node(int val) {
            super(val);
        }

        public Node(int val, int color) {
            super(val);
            this.color = color;
        }
    }
}
