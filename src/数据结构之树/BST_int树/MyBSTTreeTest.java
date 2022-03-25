package 数据结构之树.BST_int树;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-25 12:16
 **/
public class MyBSTTreeTest {
    public static void main(String[] args) {
//        MyBSTTree tree = new MyBSTTree();
//        tree.insertChild(4);
//        tree.insertChild(2);
//        tree.insertChild(7);
//        tree.insertChild(1);
//        tree.insertChild(3);
//        tree.insertChild(6);
//        tree.insertChild(10);
//        tree.insertChild(5);
//        tree.insertChild(9);
//        tree.insertChild(11);
//        tree.inOrder(tree.getRoot());
//        tree.deleteChild(tree.search(7));
//        System.out.println();
//        tree.inOrder(tree.getRoot());
//        System.out.println();
//        System.out.println(tree.maxValueOf(tree.getRoot()));
//        System.out.println(tree.minValueOf(tree.getRoot()));
//        System.out.println(tree.size);
//        System.out.println(tree.getRoot().key);
//        System.out.println(tree.successor(tree.search(11)));
//        System.out.println(tree.getHeight(tree.root));
//        TreeOperationPrint.show(tree.root);
////        System.out.println(tree.preSuccessor(tree.search(7)));


        MyAVLTree avlTree = new MyAVLTree();
        avlTree.insert(1);
        TreeOperationPrint.show(avlTree.root);
        System.out.println(avlTree.isUnBalance(avlTree.root));
        avlTree.insert(2);
        TreeOperationPrint.show(avlTree.root);
        System.out.println(avlTree.isUnBalance(avlTree.root));
        avlTree.insert(3);
        System.out.println(avlTree.size);
//        avlTree.levelOrder(avlTree.root);
//        System.out.println(avlTree.isUnBalance(avlTree.root));
//        avlTree.insert(4);
        TreeOperationPrint.show(avlTree.root);
//        System.out.println(avlTree.isUnBalance(avlTree.root));
//        avlTree.insert(5);
//        TreeOperationPrint.show(avlTree.root);
//        System.out.println(avlTree.isUnBalance(avlTree.root));

    }
}
