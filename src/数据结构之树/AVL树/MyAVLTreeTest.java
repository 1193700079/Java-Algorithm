package 数据结构之树.AVL树;

import javax.print.DocFlavor;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-24 21:45
 **/
public class MyAVLTreeTest {
    public static void main(String[] args) {
        AVLTreeNode root = new AVLTreeNode(4);
        MyAVLTree myAVLTree = new MyAVLTree(root); //传值吗？
        myAVLTree.insertChild(root,2);
        myAVLTree.insertChild(root,7);
        myAVLTree.insertChild(root,1);
        myAVLTree.insertChild(root,3);
        myAVLTree.insertChild(root,6);
        myAVLTree.insertChild(root,9);
        myAVLTree.inOrder(root);
        AVLTreeNode node2 = myAVLTree.search(2); //查找到这个节点
        myAVLTree.deleteChild(node2);  //删除节点
        myAVLTree.inOrder(root);
//        AVLTreeNode<Character> root = new AVLTreeNode<>('d');
//        MyAVLTree<Character> myAVLTree = new MyAVLTree<>(root);
//        myAVLTree.insertChild(root,'b');
//        myAVLTree.insertChild(root,'g');
//        myAVLTree.insertChild(root,'a');
//        myAVLTree.insertChild(root,'c');
//        myAVLTree.insertChild(root,'f');
//        myAVLTree.insertChild(root,'h');
//        myAVLTree.inOrder(root);
//        System.out.println();
//        System.out.println(myAVLTree.min(root));
//        System.out.println(myAVLTree.max(root));
//        myAVLTree.lookValue('a');
//        myAVLTree.lookValue('z');
    }
}
