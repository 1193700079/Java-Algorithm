package _2搜索;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: lanqiaobei2020
 * @description:   建图 队列 标志
 * @author: yrq
 * @create: 2020-01-20 09:42
 **/
public class _1BFS {
    public static void main(String[] args) {
        ArrayList<Character> A_list = new ArrayList<>();
        A_list.add('B');
        A_list.add('C');
        A_list.add('D');
        ArrayList<Character> B_list = new ArrayList<>();
        A_list.add('E');
        A_list.add('F');
        ArrayList<Character> C_list = new ArrayList<>();
        A_list.add('G');
        A_list.add('H');
        ArrayList<Character> D_list = new ArrayList<>();
        A_list.add('I');
        Map<Character,ArrayList<Character>> graphic = new HashMap<>();
        graphic.put('A',A_list);
        graphic.put('B',B_list);
        graphic.put('C',C_list);
        graphic.put('D',D_list);

        char start = 'A';
//        bfs(start,)
    }
}
