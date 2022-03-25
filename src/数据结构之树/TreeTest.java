package 数据结构之树;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-22 12:09
 **/
public class TreeTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(1);
        Tree.Node n = tree.head;
        tree.addLeftNode(n,2);
        tree.addRightNode(n,3);
        Tree.Node nL = n.left;
        tree.addLeftNode(nL,4);
        tree.addRightNode(nL,5);
        Tree.Node nR = n.right;
        tree.addLeftNode(nR,6);
//        tree.addRightNode(nR,7);

//        tree.bfs();
        tree.inOrder(tree.head);

    }
}
