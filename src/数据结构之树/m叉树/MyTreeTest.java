package 数据结构之树.m叉树;

import 数据结构之树.m叉树.MyTree;
import 数据结构之树.m叉树.TreeNode;

import java.util.List;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-24 15:00
 **/
public class MyTreeTest {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        MyTree<Integer> myTree = new MyTree<>(root);
        TreeNode<Integer> A = new TreeNode<>(2);
        TreeNode<Integer> B = new TreeNode<>(3);
        TreeNode<Integer> C = new TreeNode<>(4);
        TreeNode<Integer> D = new TreeNode<>(5);
        TreeNode<Integer> E = new TreeNode<>(6);
        TreeNode<Integer> F = new TreeNode<>(7);
//        TreeNode<Integer> G = new TreeNode<>(8);
        myTree.insertChild(root,A);
        myTree.insertChild(root,B);
        myTree.insertChild(A,C);
        myTree.insertChild(A,D);
        myTree.insertChild(B,E);
        myTree.insertChild(B,F);
//        myTree.insertChild(C,G);
//        myTree.insertChild(G,new TreeNode<>(9));
//        System.out.println(myTree.getHeight(root));
//        System.out.println(myTree.getSize());
//        myTree.levelOrder(root);
        List<List<TreeNode<Integer>>> lists = myTree.levelOrder2(root);

        for (List<TreeNode<Integer>> list:lists) {
            for (TreeNode<Integer> node:list) {
                System.out.print(node.key+" ");
            }
            System.out.println();
        }
        myTree.preOrder(root);
        System.out.println();
        myTree.inOrder(root);
        System.out.println();
        myTree.postOrder(root);

    }

}
