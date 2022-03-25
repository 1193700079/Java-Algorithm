package _1排序;

import _1_recursion.Utils;

public class Test_逆序对 {
    static int nixuNumber= 0;
    public static void main(String[] args) {
        int[] arr = Utils.createRandomArrayNotRepetition(5,1,100);
        Utils.printArrays(arr);
        mergeSort(arr,0,arr.length-1);
        System.out.println(nixuNumber);

    }
    public static void mergeSort(int[] arr,int left ,int right){
        if(left<right){
            int mid = left + ((right-left)>>1);
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        while (i<=mid&&j<=right){
            if(arr[i]<=arr[j]){
                i++;
            }else {
                j++;
                nixuNumber+=mid-i+1;
            }
        }
    }

}
