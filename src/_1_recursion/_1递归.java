package _1_recursion;

import java.lang.reflect.GenericDeclaration;

public class _1递归 {

    static int m = 1;
    public static void main(String[] args) {
//        System.out.println(fun(5));
//        System.out.println(f1(5));
//        f2(-3,5);
//        int[] arr= new int[]{1, 2, 3, 4, 5};
//        System.out.println(f3(arr,0));
//        System.out.println(f4("小迷最棒"));
//        System.out.println(f4("小迷最棒",0));
//        System.out.println(f4_2("小迷最棒",3));
//        System.out.println(Fibonacci(10));
//        System.out.println(division_algorithm(27216,15750 ));
//        System.out.println(division_algorithm(20,15 ));
//        int[] arr;
//        arr= new int[]{5, 4, 6, 2, 1};
//
//        doInsertSort(arr,arr.length);
//        for (int i :arr) {
//            System.out.println(i);
//        }
        printHanoiTower(2,"A","B","C");
    }
    // Insertion sort   5 4 6 2 1 *  1 2 4 5 6

//                    5 4 6 1 2
//                    5 4
//    先把前面的排序完毕 然后在插入进来
    public static void Insertion_sort(int[] arr,int end){
        if(end == 0)
            return;
        Insertion_sort(arr ,end-1);
        int x= arr[end];
        int index=end-1;  //标记
        while (x < arr[index] && index>-1){
            arr[index+1] = arr[index];
            index --;
        }
        arr[index+1] = x;
    }

    public static void doInsertSort(int[] array,int length){
        for(int index = 1; index<length; index++){//外层向右的index，即作为比较对象的数据的index
            int temp = array[index];//用作比较的数据
            int leftindex = index-1;
            while(leftindex>=0 && array[leftindex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
                array[leftindex+1] = array[leftindex];
                leftindex--;
            }
            array[leftindex+1] = temp;//把temp放到空位上
        }
    }

//    求阶乘
    public static  long fun(int n){
        if(n==0){
            return 1;
        }
        m = n*m;
        fun(n-1);
        return m;
    }

    public static long f1(int n){
        if(n==1)
            return 1;

        return n*f1(n-1);
    }
    //    打印 i~j  1 5
    public static void f2(int i,int j){
        if(i>j){
            return;
        }
        System.out.println(i);
        f2(i+1,j);
    }
    //    数组求和
    public static int  f3(int[] arr, int i){
        if(i>=arr.length){
            return 0;
        }
        return arr[i]+f3(arr,i+1);
    }
//    翻转字符串
    public static String f4(String s){
        return  new StringBuffer(s).reverse().toString();
    }
    public static String f4(String s,int i){
        if(s.length()==1){
            return s;
        }
        return  s.toCharArray()[s.length()-1]+f4(s.substring(i,s.length()-1));
    }

    //    end表示最后一个
    public static String f4_2(String s,int end){
        if(end == 0){
            return s.charAt(0)+"";
        }
        return  s.charAt(end)+f4_2(s,end-1);
    }
//    斐波那契数列 这样求效率低 可以去优化
    public static  int Fibonacci(int n){
        if(n==1 || n ==2){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
//    使用辗转相除 求最大公约数 20 15  5
    public static int division_algorithm(int n ,int m){

        int k = n%m;
        if(k==0)
            return m;
        return division_algorithm(m,k);
    }
// 汉诺塔
    /*
    * A B C 表示柱子
    * N 表示盘子的个数
    * 实现把所有盘子从A移动到B
    * */
    public static void printHanoiTower(int N,String A,String B,String C){
        if(N==1){
            System.out.println("move "+N+" from "+A+" to " +B);
        }else {
            printHanoiTower(N-1,A,C,B);  //把前N-1个盘子从A移动到辅助位置C,以B为载体
            System.out.println("move "+N+" from "+A+" to " +B);
            printHanoiTower(N-1,C,B,A);//把前N-1个盘子从C移动到目标位置B,以A为载体
        }


    }

}
