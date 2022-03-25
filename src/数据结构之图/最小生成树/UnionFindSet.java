package 数据结构之图.最小生成树;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-26 22:28
 **/
public class UnionFindSet {

    //寻找并查集的根节点
    public static UnionFindNode find(UnionFindNode node){
        if(node == null){
            UnionFindNode p = new UnionFindNode();
            return p;
        }
        UnionFindNode p =node;
        Set<UnionFindNode> set = new HashSet<>();//做一个优化  让所有结点的父节点都指向一个 方便查询
        while (p.parent!=null){
            set.add(p);
            p=p.parent;
        }
        //
        for (UnionFindNode n: set) {
            n.parent = p;
        }
        return p;

    }
    //让两个点变成一个新的集合
    public static void union(UnionFindNode x,UnionFindNode y){
        find(y).parent = find(x);
    }

    public static class UnionFindNode{
        UnionFindNode parent;
    }
}