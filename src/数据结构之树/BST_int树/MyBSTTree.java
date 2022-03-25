package 数据结构之树.BST_int树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-25 12:08
 **/
public class MyBSTTree {
    BSTTreeNode root;
    int size;
    public MyBSTTree(BSTTreeNode root) {
        this.root = root;
    }

    public MyBSTTree() {
    }

    //得到根节点
    public BSTTreeNode getRoot(){
        return  root;
    }

    //得到树的高度
    public int getHeight(BSTTreeNode node){
        if(node == null) return 0;  //返回-1 表示第一层为0  返回0 表示第一层为1
        int h1 = getHeight(node.leftSon);
        int h2 = getHeight(node.rightSon);
        return 1+Math.max(h1,h2);
    }
    public boolean isBalance(){
        return !isUnBalance(root);
    }
    /**
     * 从根节点判断是否平衡  要所有结点都要平衡！！
     * @return
     */
    public boolean isUnBalance(BSTTreeNode node){
        if(node == null) return false;
        int h1 = getHeight(node.leftSon);
        int h2 = getHeight(node.rightSon);
        return Math.abs(h1-h2)>1
            || isUnBalance(node.leftSon)
            || isUnBalance(node.rightSon);

    }
    //插入点
    public void insertChild(int val) {
        if(root == null){
            root = new BSTTreeNode(val);
            size++;
            return;
        }
        BSTTreeNode cur =null;
        BSTTreeNode p = root;

        while (p!=null){
            cur = p;
            if((int)p.key>(int)val){
                p = p.leftSon;
            }else if((int)p.key<(int)val){
                p = p.rightSon;
            }else {
                System.out.println("已经存在此值");
                return;
            }
        }
        p = cur;
        BSTTreeNode son = new BSTTreeNode(val);
        if((int)p.key>(int)son.key){
            p.leftSon = son;
            son.parent =p;
        }else if((int)p.key<(int)son.key){
            p.rightSon = son;
            son.parent =p;
        }
        size++;
    }
    //查找节点
    public BSTTreeNode search(int val){
        BSTTreeNode p = root;
        while (p!=null){
            if((int)p.key>val){
                p = p.leftSon;
            }else if((int)p.key<val){
                p = p.rightSon;
            }else{
                return p;
            }
        }
        return null;
    }

    //找后继 比这个结点大一点的值
    public int successor(BSTTreeNode node){
        if(node == null){
            return  -1;
        }
        if(node.key == maxValueOf(root)){
            return -1;
        }
        //存在右儿子
        if(node.rightSon !=null){
            return minValueOf(node.rightSon);
        }

        //不存在右儿子 一直往上找拐点()
        BSTTreeNode p = node.parent;
        while (p!=null &&!p.leftSon.equals(node)){
            p = p.parent;
            node = node.parent;
        }
        return p.key;

    }
    //找前继  比这个结点小一点的值
    public int preSuccessor(BSTTreeNode node){
        if(node == null){
            return  -1;
        }
        if(node.key == minValueOf(root)){
            return -1;
        }
        //存在左儿子
        if(node.leftSon !=null){
            return maxValueOf(node.leftSon);
        }

        //不存在左儿子 一直往上找拐点()
        BSTTreeNode p = node.parent;
        while (p!=null &&!p.rightSon.equals(node)){
            p = p.parent;
            node = node.parent;
        }
        return p.key;
    }

    //删除节点
    public void deleteChild(BSTTreeNode node){
        if(node == null){
            return ;
        }
        int val = node.key;
        BSTTreeNode p = node;
        //1.如果是叶子节点
        if(p.rightSon==null && p.rightSon==null){
            //说明为根节点
            if(p.parent==null){
                root = null;
                return;
            }
            if((int)p.parent.key>val){
                //左叶子节点
                p.parent.leftSon=null;
            }else {
                p.parent.rightSon =null;
            }
            p.parent = null;
            size--;
        }
        //2.如果是单支节点
        //2.1左单支
        else if(p.rightSon ==null){
            if(p.parent == null){
                p.leftSon = root;
                root = null;
            }
            if(p==p.parent.leftSon){
                p.parent.leftSon = p.leftSon;
                p.leftSon.parent = p.parent;
                p.parent = null;
                p.leftSon = null;
            }else {
                p.parent.rightSon = p.leftSon;
                p.leftSon.parent = p.parent;
                p.parent = null;
                p.leftSon = null;
            }
            size--;
        }
        //2.1右单支
        else if(p.leftSon == null){
            if(p.parent == null){
                p.rightSon = root;
                root = null;
                return;
            }
            if(p==p.parent.leftSon){
                p.parent.leftSon = p.rightSon;
                p.rightSon.parent = p.parent;
                p.parent = null;
                p.rightSon = null;
            }else {
                p.parent.rightSon = p.rightSon;
                p.rightSon.parent = p.parent;
                p.parent = null;
                p.rightSon = null;
            }
            size--;
        }
        //3.如果是双支节点
        else {
            //找到右支的最小值！  然后替换既可以   删除min即可
            BSTTreeNode min = minNode(p.rightSon);
            p.key = min.key;
            deleteChild(min); //递归删除  因为一定是单支或者叶子结点

            //这样会破坏其结构
//            AVLTreeNode max = maxNode(p.leftSon);
//            p.key = max.key;
//            deleteChild(max); //递归删除  因为一定是单支或者叶子结点
        }


    }

    /**
     * 最大值
     * @param head
     * @return
     */
    public int maxValueOf(BSTTreeNode head){
        BSTTreeNode p = head;
        while (p.rightSon!=null){
            p = p.rightSon;
        }
        return p.key;
    }

    /**
     * 最大节点
     * @param head
     * @return
     */
    public BSTTreeNode maxNode(BSTTreeNode head){
        BSTTreeNode p = head;
        while (p.rightSon!=null){
            p = p.rightSon;
        }
        return p;
    }

    //最小值
    public int minValueOf(BSTTreeNode head){
        BSTTreeNode p = head;
        while (p.leftSon!=null){
            p = p.leftSon;
        }
        return p.key;
    }
    //最小节点
    public BSTTreeNode minNode(BSTTreeNode head){
        BSTTreeNode p = head;
        while (p.leftSon!=null){
            p = p.leftSon;
        }
        return p;
    }

    //中序遍历
    public void inOrder(BSTTreeNode head) {
        if(head!=null){
            inOrder(head.leftSon);
            System.out.print(head.key+" ");
            inOrder(head.rightSon);
        }
    }

    //层序遍历
    public void levelOrder(BSTTreeNode head) {
        BSTTreeNode node = head;
        Queue<BSTTreeNode> q = new LinkedList<>();
        int last = 1,next = 1,i=0;
        q.offer(node);
        while (!q.isEmpty()){
            node = q.poll();  //注意啊 !!
            i++;
            System.out.print(node.key+" ");

            if(node.leftSon!=null){
                q.offer(node.leftSon);
                next++;
            }
            if(node.rightSon!=null){
                q.offer(node.rightSon);
                next++;
            }
            if(last == i && !q.isEmpty()){
                System.out.println();
                last = next;
            }
        }
    }




    public class BSTTreeNode {
        int key;
        BSTTreeNode parent;
        BSTTreeNode leftSon;
        BSTTreeNode rightSon;
        boolean isLeftSon;

        public BSTTreeNode(int key, BSTTreeNode parent) {
            this.key = key;
            this.parent = parent;
        }

        public BSTTreeNode(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "key=" + key +
                    '}';
        }
    }
}
