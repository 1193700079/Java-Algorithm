package _1_recursion;

import java.util.Random;

import static _1_recursion._3排序.swap;


public class Utils {

    /**
     * 创建随机的二维数组
     * @param Rowlen 行长
     * @param Collen 列长
     * @param min 最小值
     * @param max 最大值
     * @return
     */
    public static int[][] createTwo_dimensionalArrays(int Rowlen,int Collen,int min,int max){
        int[][] arr = new int[Rowlen][Collen];
        max++;  //为了产生[min,max]的值
//        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
//            int randNumber = r.nextInt(bound);   0~bound-1
            for (int j = 0; j < arr[i].length; j++){
                int ran2 = (int) (Math.random()*(max-min)+min); //这是产生[min,max+1)的随机数
                arr[i][j]=ran2;
            }

        }
        return arr;
    }

    /**遍历二维数组
     */
    public static void printTwo_dimensionalArraysChar(char[][] arr){
        //打印结果
        for (char[] col:arr) {
            for (char data:col){
                System.out.print(data+" ");
            }
            System.out.println();
        }
//        for (int i = 0; i <arr.length ; i++) {   //行row
//            for (int j = 0; j < arr[i].length; j++) {  //列col
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println();
    }
    /**遍历二维数组
     */
    public static void printTwo_dimensionalArrays(int[][] arr){
        //打印结果
        for (int[] col:arr) {
            for (int data:col){
                System.out.print(data+" ");
            }
            System.out.println();
        }
//        for (int i = 0; i <arr.length ; i++) {   //行row
//            for (int j = 0; j < arr[i].length; j++) {  //列col
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println();
    }


    /**
     * 一维数组清0  或者赋值为0
     * @param arr
     */
    public static void clearArray(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            arr[i]=0;
        }

    }
    /**
     * 求数组的最大值
     * @param arr
     */
    public static int arrOfMax(int[] arr){
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;

    }
    /**
     * 数组的数据交换
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    /**遍历数组
     */
    public static void printArrays(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    /**分析算法性能  消耗多少s 1000ms=1s
    **/
    public static void duration(long times){
        long t = Math.abs(System.currentTimeMillis()-times);
        System.out.println(t+"ms");
    }

    /**
     * 随机指定范围内N个不重复的数
     * 在初始化的无重复待选数组中随机产生一个数放入结果中，
     * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换
     * 然后从len-2里随机产生下一个随机数，如此类推
     * @param max  指定范围最大值
     * @param min  指定范围最小值
     * @param n  随机数个数
     * @return int[] 随机数结果集
     */
    public static int[] createRandomArrayNotRepetition(int n,int min,int max){
        int len = max-min+1;

        if(max < min || n > len){
            return null;
        }

        //初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min+len; i++){
            source[i-min] = i;
        }

        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            //待选数组0到(len-2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            //将随机到的数放入结果集
            result[i] = source[index];
            //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }
    /**生成的是0~19的随机数组
     * len 表示数组长度
     * min 表示随机数的最小值
     * max 表示随机数的最大值
    * */
    public static int[] createRandomArray(int len,int min,int max){
        int[] arr = new int[len];
        max++;  //为了产生[min,max]的值
//        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
//            int randNumber = r.nextInt(bound);   0~bound-1
            int ran2 = (int) (Math.random()*(max-min)+min); //这是产生[min,max+1)的随机数
            arr[i]=ran2;
        }
        return arr;
    }


    public static void main(String[] args) {
        System.out.println(f6(72));
    }

    public static long f6(int n) {
        double result = 0;
        double temp = Math.sqrt(5.0);
        result = (Math.pow((1 + temp) / 2, n) - Math.pow((1 - temp) / 2, n)) / temp;
        return (long) result;
    }







    private static void mergeSort(int[] arr, int begin, int end) {
        if(begin<end){
            int mid= begin+((end-begin)>>1);
            mergeSort(arr,begin,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,begin,mid,end);
        }
    }

    private static void merge(int[] arr, int begin, int mid, int end) {
        int[] tmp = new int[arr.length];
        int left = begin;
        int right = mid+1;
        int index = begin;
        while (left<=mid&&right<=end){
            if(arr[left]<=arr[right]){
                tmp[index++]=arr[left++];
            }else {
                tmp[index++]=arr[right++];
            }
        }
        while (left<=mid){
            tmp[index++]=arr[left++];
        }
        while (right<=end){
            tmp[index++]=arr[right++];
        }
        for (int i = begin; i <= end; i++) {
            arr[i] = tmp[i];
        }
    }


    public static void quickSort(int[] arr,int begin,int end){
        if(begin<end){
            int p = partition2(arr,begin,end);
            quickSort(arr,begin,p-1);
            quickSort(arr,p+1,end);
        }
    }

    private static int partition2(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int left = begin+1;
        int right = end;
        while (left<=right){
            while (left<=right&&arr[left]<=pivot){
                left++;
            }
            while (left<=right&&arr[right]>pivot){
                right--;
            }
            if(left<=right){
                swap(arr,left,right);
            }
        }
        swap(arr,begin,right);
        return right;
    }

    //单向扫描
    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int sp = begin+1;
        int bigger = end;
        while (sp<=bigger){
            if(arr[sp]<pivot){
                sp++;
            }else {
                swap(arr,sp,bigger);
                bigger--;
            }
        }
        swap(arr,begin,bigger);
        return bigger;
    }

    //双向扫描
}
