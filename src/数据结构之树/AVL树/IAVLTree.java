package 数据结构之树.AVL树;

import 数据结构之树.m叉树.TreeNode;

public interface IAVLTree {
    void insertChild(AVLTreeNode father,  char val);
    void insertChild(AVLTreeNode father,  int val);
//    void deleteChild(int i); //删掉第几个儿子节点
    void deleteChild(AVLTreeNode node); //删掉第几个儿子节点
    //中序遍历
    void inOrder(AVLTreeNode head);
    int min(AVLTreeNode head);
    int max(AVLTreeNode head);

    //查找 二叉查找数最重要的！！ n个结点 最多查找n-1次 最少查找logn+1次(logn向下取整)   二分查找的另一半  根据高度
    boolean lookValue(Integer val);
    boolean lookValue(Character val);
    AVLTreeNode search(AVLTreeNode node);
}
