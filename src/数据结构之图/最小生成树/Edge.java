package 数据结构之图.最小生成树;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-26 22:14
 **/
public class Edge implements Comparable<Edge>{
    String start;
    String end;
    int val;    //权值

    public Edge(String start, String end, int val) {
        this.start = start;
        this.end = end;
        this.val = val;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", val=" + val +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.val-o.val;
    }
}
