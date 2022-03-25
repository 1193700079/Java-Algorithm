package 数据结构之树.AVL树;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-24 21:36
 **/
public class MyAVLTree implements IAVLTree {

    AVLTreeNode root;

    public MyAVLTree(AVLTreeNode root) {
        this.root = root;
    }

    @Override
    public void insertChild(AVLTreeNode father, char val) {

    }

    @Override
    public void insertChild(AVLTreeNode father, int val) {

        AVLTreeNode cur =null;
        AVLTreeNode p = father;

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
        AVLTreeNode son = new AVLTreeNode(val);
        if((int)p.key>(int)son.key){
            p.leftSon = son;
            son.parent =p;
        }else if((int)p.key<(int)son.key){
            p.rightSon = son;
            son.parent =p;
        }
    }

    @Override
    public void deleteChild(AVLTreeNode node){
        int val = node.key;
        if(lookValue(val)){
            //找到了
            AVLTreeNode p = valueNode(node);
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
            }
            //3.如果是双支节点
            else {
                AVLTreeNode min = minNode(p.rightSon);
                p.key = min.key;
                deleteChild(min);
            }

        }else {
            //无
            System.out.println("删除失败");
        }
    }



    private AVLTreeNode maxNode(AVLTreeNode head) {
        AVLTreeNode p = head;
        while (p.rightSon!=null){
            p = p.rightSon;
        }
        return p;

    }
    private AVLTreeNode minNode(AVLTreeNode head) {
        AVLTreeNode p = head;
        while (p.leftSon!=null){
            p = p.leftSon;
        }
        return p;

    }

    @Override
    public int min(AVLTreeNode head) {
        AVLTreeNode p = head;
        while (p.leftSon!=null){
            p = p.leftSon;
        }
        return p.key;
    }

    @Override
    public  int max(AVLTreeNode head) {
        AVLTreeNode p = head;
        while (p.rightSon!=null){
            p = p.rightSon;
        }
        return p.key;
    }

    @Override
    public boolean lookValue(Integer val) {
        return false;
    }


    public boolean lookValue(int val) {
        AVLTreeNode p = root;
        while (p!=null){
            if((int)p.key>val){
                p = p.leftSon;
            }else if((int)p.key<val){
                p = p.rightSon;
            }else{
                System.out.println("找到了 "+p.key );
                return true;
            }
        }
        System.out.println("没有找到");
        return false;
    }

    @Override
    public boolean lookValue(Character val) {
        return false;
    }

    @Override
    public AVLTreeNode search(AVLTreeNode node) {
        return null;
    }

    public AVLTreeNode valueNode(java.lang.Integer val) {
        AVLTreeNode p = root;
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

    public AVLTreeNode valueNode(AVLTreeNode node) {
        AVLTreeNode p = root;
        while (p!=null){
            if((int)p.key>node.key){
                p = p.leftSon;
            }else if((int)p.key<node.key){
                p = p.rightSon;
            }else{
                return p;
            }
        }
        return null;
    }


    public AVLTreeNode search(int val) {
        AVLTreeNode p = root;
        while (p!=null){
            if((int)p.key>(int)val){
                p = p.leftSon;
            }else if((int)p.key<(int)val){
                p = p.rightSon;
            }else{
                System.out.println("找到了 "+p.key );
                return p;
            }
        }
        System.out.println("没有找到");
        return null;
    }


    @Override
    public void inOrder(AVLTreeNode head) {
        if(head!=null){
            inOrder(head.leftSon);
            System.out.print(head.key+" ");
            inOrder(head.rightSon);
        }
    }

}
