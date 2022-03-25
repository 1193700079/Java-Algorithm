package 数据结构之树.BST_int树.完整版;

import javax.imageio.stream.IIOByteBuffer;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-25 19:40
 **/
public class Test {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.levelOrder();
        TreeOperationPrint.show(tree.mRoot);
        tree.insert(4);
        TreeOperationPrint.show(tree.mRoot);
        tree.insert(5);
        TreeOperationPrint.show(tree.mRoot);
        tree.insert(6);
        TreeOperationPrint.show(tree.mRoot);
        tree.insert(7);
        TreeOperationPrint.show(tree.mRoot);
        tree.insert(8);
        TreeOperationPrint.show(tree.mRoot);
        tree.insert(9);
        TreeOperationPrint.show(tree.mRoot);
        System.out.println(tree.numOfLeaf());
    }
}
