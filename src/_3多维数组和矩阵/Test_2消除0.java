package _3多维数组和矩阵;

import _1_recursion.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-01-17 10:46
 **/
public class Test_2消除0 {
    static Map<Integer,Integer> resultMap = new HashMap<>();

    public static void main(String[] args) {
        int[][] arr;
        arr=Utils.createTwo_dimensionalArrays(5,5,0,10);
        Utils.printTwo_dimensionalArrays(arr);
        remove_0_Inmatrix(arr);
        //遍历结果集
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {

            //行清0
            for (int i = 0; i < arr.length; i++) {  //列col
                arr[i][entry.getValue()]=0;   //可以这么写
            }

            //列清0
            for (int j = 0; j < arr[entry.getKey()].length; j++) {  //列col
                arr[entry.getKey()][j]=0;   //可以这么写
            }

            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        //打印结果
        Utils.printTwo_dimensionalArrays(arr);

    }

    private static void remove_0_Inmatrix(int[][] arr) {
        for (int i = 0; i <arr.length ; i++) {   //行row
            for (int j = 0; j < arr[i].length; j++) {  //列col
                if(arr[i][j]==0){
                    //保存在一个map集合中
                    resultMap.put(i,j);
                    break; //遇到0就可以了
                }
            }
        }
    }
}
