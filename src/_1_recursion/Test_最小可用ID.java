package _1_recursion;

import java.util.Arrays;

public class Test_最小可用ID {

    public static void main(String[] args) {

        int[] arr = Utils.createRandomArrayNotRepetition(1000*1000,1,1000*1000*2);
        long now = System.currentTimeMillis();
        int id = findMinID(arr);
        System.out.println(id);
        Utils.duration(now);

        int[] arr2 = Utils.createRandomArrayNotRepetition(1000*1000,1,1000*1000*2);
        now = System.currentTimeMillis();
        int id2 = findMinID4(arr2,0,arr2.length-1);
        System.out.println(id2);
        Utils.duration(now);

        int[] arr3 = Utils.createRandomArrayNotRepetition(1000*1000,1,1000*1000*2);
        now = System.currentTimeMillis();
        int id3 = findMinID3(arr3);
        System.out.println(id3);
        Utils.duration(now);
    }

    //NlogN的算法
    private static int findMinID(int[] arr) {
        Arrays.sort(arr);
        int id=-1;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]!=(i+1)){
                id=i+1;
                break;
            }
        }
        if(id==-1){
            return arr.length+1;
        }else {
            return id;
        }
    }

    //N 的算法  但是有点浪费空间
    private static int findMinID2(int[] arr){
        int[] tmp = new int[arr.length*10];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i]=0;
        }
        for (int i = 0; i < arr.length; i++) {
            tmp[arr[i]-1]=1; //数字转下标  记得减1
        }
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i]==0){
                return i+1;
            }
        }
        return arr.length+1;
    }

    private static int findMinID3(int[] arr){
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i]=0;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=arr.length){   //因为数组里的数字的大小大于了数组长度肯定不是最小ID 可以直接忽略
                continue;
            }
            tmp[arr[i]-1]=1; //数字转下标  记得减1
        }
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i]==0){
                return i+1;
            }
        }
        return arr.length+1;
    }

    /**还可以采用二分法
     * 思路是看中间的数 下标和值是否相等 如果相等就说明左边紧凑直接考虑右边
     * 反之 不相等就说明左边不紧凑
     * */
    private static int findMinID4(int[] arr,int left,int right){
        if(left>right){
            return left+1;
        }
        int mid = left+((right-left)>>1);
        int p = quickSortK(arr,left,right,mid-left+1);  //找到第*位置
        int t = mid+1;   //期望值
        if(p==t){
            // 左边紧凑
            return findMinID4(arr,mid+1,right);
        }else {
            // 左边稀疏
            return findMinID4(arr,left,mid-1);
        }
    }


    public static int quickSortK(int[] arr,int left,int right,int k){
        int q = partition(arr,left,right);//划分得出的主元位置
        int qk = q-left+1; //主元是第几个元素  从1开始
        if(k<qk){
            return quickSortK(arr,left,q-1,k);
        }else if(k>qk){
            return quickSortK(arr,q+1,right,k-qk); //k-qk是关键
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
