package 数据结构之树.AVL树;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-24 21:31
 **/
public class AVLTreeNode {
    int key;
    AVLTreeNode parent;
    AVLTreeNode leftSon;
    AVLTreeNode rightSon;


    public AVLTreeNode( int key, AVLTreeNode parent) {
        this.key = key;
        this.parent = parent;
    }

    public AVLTreeNode( int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                '}';
    }
}
