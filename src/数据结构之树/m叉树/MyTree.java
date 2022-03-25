package 数据结构之树.m叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-24 14:37
 **/
public class MyTree<T> implements ITree<T> {

    int size = 0 ;  //节点数
    TreeNode root; //根节点

    public MyTree(TreeNode root) {
        this.root = root;
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getHeight(){ //得到树的高度  注意是向下求
        return getHeight(root);
    }
    //求树的高度要用到dfs  树为一个节点的时候高度为0
    int max = 0;
    public int getHeight(TreeNode<T> x) { //得到节点 x的高度  注意是向下求
        if( x.childrens == null){
            return 0;
        }
        int h = 0;
        for (TreeNode<T> node: x.childrens) {
            h= Math.max(h,getHeight(node));
        }
        return h+1;
    }

    @Override
    public TreeNode<T> getRoot() {
        return root;
    }

    @Override
    public TreeNode<T> getParent(TreeNode<T> x) {
        return x.parent;
    }

    @Override
    public TreeNode<T> getFirstChild(TreeNode<T> x) {
        List<TreeNode<T>> childrens = x.childrens;
        return childrens.get(0);
    }

    @Override
    public TreeNode<T> getNextBrother(TreeNode<T> x) {
        List<TreeNode<T>> children  = x.parent.childrens;
        int i = children.indexOf(x);
        try {
            return  children.get(i);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void insertChild(TreeNode<T> father, TreeNode<T> son) {
        if(father.childrens!=null){
            father.childrens.add(son);
        }else{
            //本身没有孩子的话
            List<TreeNode<T>> newchildren = new ArrayList<>();
            newchildren.add(son);
            father.childrens = newchildren;
            son.parent = father;
        }
        size++;

    }

    @Override
    public void deleteChild(TreeNode<T> father, int i) {
            father.childrens.remove(i);
            size--;

    }

    @Override
    public void preOrder(TreeNode<T> head) {
        if(head==null){
            return ;
        }
        System.out.print(head.key+" ");
        if(head.childrens!=null) {
            postOrder(head.childrens.get(0));
        }
        if(head.childrens!=null&& head.childrens.size()>1){
            postOrder(head.childrens.get(1));
        }
//        if(head.childrens!=null){
//            preOrder(head.childrens.get(0));
//            preOrder(head.childrens.get(1));
//        }
//        for (TreeNode<T> son :head.childrens) {
//            preOrder(son);
//        }

    }

    @Override
    public void postOrder(TreeNode<T> head) {
        if(head==null){
            return ;
        }
        if(head.childrens!=null) {
            postOrder(head.childrens.get(0));
        }
        if(head.childrens!=null&& head.childrens.size()>1){
            postOrder(head.childrens.get(1));
        }
        System.out.print(head.key+" ");

    }

    public void inOrder(TreeNode<T> head) {
        if(head!=null){
        if(head.childrens!=null){
            inOrder(head.childrens.get(0));
        }
            System.out.print(head.key+" ");
        if(head.childrens!=null && head.childrens.size()>1){
            inOrder(head.childrens.get(1));
        }
        }
    }

    /**
     * bfs  使用队列  弹一个加 n个  一直到只出不进   + 层序打印（双指针标记 ）
     * 哨兵  用来定位
     * 游兵  游标移动
     * @param head
     * @return
     */
    @Override
    public void levelOrder(TreeNode<T> head) {
        TreeNode<T>  node = head;
        Queue<TreeNode<T>> q = new LinkedList<>();
        int last = 1,next = 1,i=0;
        q.offer(node);
        while (!q.isEmpty()){
            node = q.poll();  //注意啊 !!
            i++;
            System.out.print(node.key+" ");
            if(node.childrens!=null){
                for (TreeNode<T>  newNode :node.childrens) {
                    q.offer(newNode);
                    next++;
                }
            }
            if(last == i){
                System.out.println();
                last = next;
            }
        }
    }


    public List<List<TreeNode<T>>> levelOrder2(TreeNode<T> head) {
        List<List<TreeNode<T>>> res = new ArrayList<>();
        List<TreeNode<T>> list = new ArrayList<>();
        res.add(list);
        TreeNode<T>  node = head;
        Queue<TreeNode<T>> q = new LinkedList<>();
        int last = 1,next = 1,i=0;  //last表示标记上一行最后一个元素 next表示标记下一行最后一个元素 i表示进入队列的数
        q.offer(node);
        while (!q.isEmpty()) {
            node = q.poll();  //注意啊 !!
            i++;
            list.add(node);
//            System.out.print(node.key+" ");
            if (node.childrens != null) {
                for (TreeNode<T> newNode : node.childrens) {
                    q.offer(newNode);
                    next++;
                }
            }
            if (last == i && !q.isEmpty()) {
                list = new ArrayList<>();
                res.add(list);
//                System.out.println();
                last = next;
            }
        }
        return res;
    }

}
