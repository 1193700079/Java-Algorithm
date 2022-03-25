package 数据结构之图.最小生成树;

import java.util.*;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-26 22:13
 **/
public class Kruskal {

    public static List<Edge> edges;
    public static Set<Edge> T = new HashSet<>(); //代表最小生成树的边的集合
    public static int n;//总顶点数
    public static Map<String, UnionFindSet.UnionFindNode> v_UFN = new HashMap<>();//让边和并查集结点有映射关系
    public Kruskal(List<Edge> edges, int n) {
        this.edges = edges;
        for (Edge e:edges) {
            v_UFN.put(e.getStart(),new UnionFindSet.UnionFindNode());
            v_UFN.put(e.getEnd(),new UnionFindSet.UnionFindNode());
        }
        this.n = n;
    }


    public static void main(String[] args) {
        List<Edge> list = build();

        Kruskal obj = new Kruskal(list,5);
        Collections.sort(edges);

        for (Edge e:obj.getT()) {
            System.out.println(e);
        }
    }

    private static List<Edge> build() {
        List<Edge> list = new ArrayList<>();
        list.add(new Edge("A","E",9));
        list.add(new Edge("A","D",8));
        list.add(new Edge("B","D",7));
        list.add(new Edge("B","E",6));
        list.add(new Edge("B","C",5));
        list.add(new Edge("D","E",3));
        list.add(new Edge("A","B",3));
        list.add(new Edge("C","E",2));
        list.add(new Edge("C","A",1));
        list.add(new Edge("C","D",1));
        return list;
    }

    private Set<Edge> getT(){
        getMST();
        return T;
    }
    private void getMST() {

        for (Edge e:edges) {
            if(!isok(e)) continue;
            T.add(e);
            if(T.size() == n -1){
                return ;
            }
        }
    }

    private boolean isok(Edge e) {
        UnionFindSet.UnionFindNode x =  v_UFN.get(e.getStart());
        UnionFindSet.UnionFindNode y =  v_UFN.get(e.getEnd());
        if(UnionFindSet.find(x) != UnionFindSet.find(y)){
            UnionFindSet.union(x,y);
            return true;
        }
        return false;
    }
}
