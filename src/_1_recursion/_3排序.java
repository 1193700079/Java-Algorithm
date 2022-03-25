package _1_recursion;

import java.util.Arrays;

public class _3排序 {


//加上了分析刚好占一半的情况
    public static void main(String[] args) {
        int[] arr = new int[]{2,0,1,1,1,1,2,2};
//        int mid = 0+((arr.length-1-0)>>1);
//        quickSort(arr,0,arr.length-1);
//        System.out.println(arr[mid]);
        System.out.println( fun(arr));;

    }
//    消除法
    public static int fun(int[] arr){
       int pivot = arr[0];
       int countOfLast = 0; //统计最后一个数组出现的次数
       int times = 1 ;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==arr[arr.length-1]){
                countOfLast++;
            }
            if(times==0){
                pivot=arr[i];
            }
            if(arr[i]==pivot){
                times++;
            }else {
                times--;
            }
        }
        if(countOfLast==arr.length/2){
            return arr[arr.length-1];
        }else {
            return pivot;
        }

    }

    public static void quickSort(int[] arr,int begin,int end){
        if(begin<end){
            int p = partition(arr,begin,end);
            quickSort(arr,begin,p-1);
            quickSort(arr,p+1,end);
        }
    }

    public static int quickSort(int[] arr,int left,int right,int k){
        int q = partition(arr,left,right);//划分得出的主元位置
        int qk = q-left+1; //主元是第几个元素
        if(k<qk){
            return quickSort(arr,left,q-1,k);
        }else if(k>qk){
            return quickSort(arr,q+1,right,k-qk);
        }else {
            return arr[q];
        }
}
    public static int partition(int[] arr,int begin,int end){   //begin表示初始位置 end表示末位置
        int pivot = arr[begin]; //定主元
        int left=begin+1; //左指针
        int right = end; //右指针
        while (left<=right){
            if(arr[left]<=pivot){
                left++;
            }else {
                swap(arr,left,right);
                right--;
            }
        }
        //然后开始交换主元位置  到这一步left一定等于right！
        swap(arr,begin,right);
        return right;
    }
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

}
