package 数据结构之树.BST_int树;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-25 14:07
 **/
public class MyAVLTree extends  MyBSTTree {
    //插入 维持一个BST  高度不变化话
    public void insert(int val){
        super.insertChild(val);
        BSTTreeNode node = search(val);

        //不平衡的话 就要找到不平衡的点pqs然后变成平衡
        BSTTreeNode[] pqs = firstUnBalance(node);
        if(pqs!=null){
            System.out.println("asd as");
            reBalance(pqs);
        }

    }

    private void reBalance(BSTTreeNode[] pqs) {

        BSTTreeNode p = pqs[0];
        BSTTreeNode q = pqs[1];
        BSTTreeNode s = pqs[2];
        if(p.rightSon.key==q.key && q.rightSon.key ==s.key){
            //右右类型  左旋
            leftRotate(p,q);
        }else if(p.rightSon.equals(q) && q.leftSon.equals(s)){
            //右左类型   先变成右右类型        然后左旋
            rightRotate(q,s);
            leftRotate(p,s);
        }else if(p.leftSon.equals(q) && q.leftSon.equals(s)){
            rightRotate(p,q);
        }else if(p.leftSon.equals(q) && q.rightSon.equals(s)){
            leftRotate(q,s);
            rightRotate(p,s);
        }
    }

    private void rightRotate(BSTTreeNode q, BSTTreeNode s) {
    }

    private void leftRotate(BSTTreeNode p, BSTTreeNode q) {
        BSTTreeNode pp = p.parent;
        boolean isLeftson = false;
        if(pp!=null && pp.leftSon==p){
            //说明为左儿子
            isLeftson = true;
        }
        //处理 p b 的关系
        if(q.leftSon !=null){
            BSTTreeNode B = q.leftSon;
            B.parent = p;
            p.rightSon = B;
        }

        //处理p q的关系
        p.parent = q;
        q.leftSon = p;

        //处理 q pp的关系
        q.parent = pp;
        if(isLeftson){
            pp.leftSon = q;
        }else {
            if(pp!=null){
                pp.rightSon =q;
            }
        }

    }

    private BSTTreeNode[] firstUnBalance(BSTTreeNode node) {
        if(node==null) return  null;
        BSTTreeNode s = node;
        BSTTreeNode q = s.parent;
        if(q==null) return null;
        BSTTreeNode p = q.parent;
        if(p==null) return null;
        if(isUnBalance(p)){
            //如果平衡的话  就继续找不平衡的点
            return new BSTTreeNode[]{p,q,s};
        }else {
            return firstUnBalance(node.parent);
        }
    }
}
