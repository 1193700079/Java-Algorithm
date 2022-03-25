package 数据结构之树.m叉树;

import java.util.List;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-24 14:26
 **/
public class TreeNode<T>  {
    T key;
    TreeNode<T> parent;
    List<TreeNode<T>> childrens;

    public TreeNode( T key ,TreeNode<T> parent) {
        this.key = key;
        this.parent = parent;
        this.childrens = null;
    }
    public TreeNode( T key ) {
        this.key = key;
        this.parent = null;
        this.childrens = null;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                '}';
    }
}
