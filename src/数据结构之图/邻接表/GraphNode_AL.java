package 数据结构之图.邻接表;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-26 10:10
 **/
public class GraphNode_AL {
    public int val;
    public List<GraphNode_AL> neighbor;
    public boolean check; //判断是否被访问过

    public GraphNode_AL(int val) {
        this.val = val;
    }

    public GraphNode_AL getNeighbor(int i ){
        return neighbor.get(i);
    }

    public void  add(GraphNode_AL node){
        if(neighbor == null)
            neighbor = new ArrayList<>();
        neighbor.add(node);
    }

    public int getSize(){
        return neighbor.size();
    }

    @Override
    public String toString() {
        return "GraphNode_AL{" +
                "val=" + val +
                '}';
    }
}
