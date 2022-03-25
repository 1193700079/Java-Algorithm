package 数据结构之图.练习题;

import java.util.*;


/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-29 09:35
 **/
public class Test7_分酒问题 {

    static Set<Node> set = new HashSet<>();
    static int[] v = new int[]{9,7,4,2}; //每个杯子的最大容量
    static Queue<Node> queue = new LinkedList<>();
    static Node st = new Node("9,0,0,0",0);
    static Node end;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String en = "";
        en+=sc.nextInt()+",";
        en+=sc.nextInt()+",";
        en+=sc.nextInt()+",";
        en+=sc.nextInt();
        end = new Node(en);
        add(queue,st);
        int res = bfs();
        System.out.println(res);
    }

    private static int bfs() {
        while (!queue.isEmpty()){
            Node n = queue.poll();
            if(n.equals(end)){
                return n.depth;
            }
            //把相同状态的都加入队列当中
            int[] state = n.getState();
            for (int i = 0; i < state.length; i++) {   //源头
                if(state[i]>0){
                    for (int j = 0; j < state.length; j++) {  //目标
                        if(i==j) continue;

                        //把i倒完的条件
                        int j_kongjian = v[j]-state[j];
                        if(j_kongjian>=state[i]){
                            int temp = state[i];
                            state[i] = 0;
                            state[j]+= temp;
                            add(queue,new Node(intArr2String(state),n.depth+1));
                            state[i] =temp;
                            state[j]-=temp;
                        }


                        //把j倒满的条件
                        if(j_kongjian>0 &&state[i]>=j_kongjian){
                            int temp = state[i];
                            state[i] -= j_kongjian;
                            state[j] += j_kongjian;
                            add(queue,new Node(intArr2String(state),n.depth+1));
                            state[i] =temp;
                            state[j] -= j_kongjian;
                        }

                    }
                }
            }

        }
        return -1;
    }

    private static String intArr2String(int[] state) {
        String s="";
        for (int i = 0; i < state.length-1; i++) {
            s+=state[i]+",";
        }
        s+=state[state.length-1];
        return s;
    }

    private static void add(Queue<Node> queue, Node st) {
        if(!set.contains(st)){
            set.add(st);
            queue.add(st);
        }
    }

    static class Node{
        String val; //9,0,0,0
        int depth; //深度

        public Node(String val, int depth) {
            this.val = val;
            this.depth = depth;
        }

        public Node(String val) {
            this.val = val;
        }

        public int[] getState(){
            String[] arr = val.split(",");
            int[] res = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                res[i] = Integer.parseInt(arr[i]);
            }
            return  res;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(obj == null || getClass()!=obj.getClass()) return false;
            Node n = (Node)obj;
            return val.equals(n.val);
        }

        @Override
        public int hashCode() {
            return val.hashCode();
        }
    }
}
