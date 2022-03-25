package _1_recursion;

public class _2查找 {
    //递归联系 上楼梯
    static int sum;
    public static void fun1(int n){
        if(n<0){
            return;
        }
        if(n==0){
            sum+=1;
        }
        fun1(n-1);
        fun1(n-2);
        fun1(n-3);
    }
    public static int fun2(int n){
        if(n<0) return 0;
        if(n==0) return 1;
        if (n==1) return 1;
        if (n==2) return 2;
        return fun2(n-1)+ fun2(n-2) + fun2(n-3);
    }
    public static void main(String[] args) {
//        int[] arr = new int[]{5,4,3,2,1,6};
////        System.out.println(arr[binarySearch(arr,0,4,1)]);
////        shellSort(arr);
//        Arrays.sort(arr);
//        for (int a:arr
//             ) {
//            System.out.print(a+" ");
//        }
//        fun1(4);
//        System.out.println(sum);
//        System.out.println(fun2(4));
//        System.out.println(fun(new int[]{6,7,2,3,4,5}));
//        System.out.println(fun(new int[]{1,0,1,1,1}));  //是个坑如果遇到这样的只能用扫描法了
//        System.out.println(fun3(new String[]{"a","","","","b"},"b"));
//        int[] arr2 = new int[]{1,9,2,5,7,3,4,6,8,0};
//        int[] arr = new int[]{7,2,1,3,5,7,8,1,2,5,3};
//        int[] result = fun4(arr);
//        System.out.println(result[0]);
//        for (int i = result[1]; i <result[2] ; i++) {
//            System.out.print(arr[i]+" ");
//        }
        System.out.println(pow(2,32));
    }


//    二分查找
    /*指针找法
    * */
    public static int binarySearch(int[] arr,int left,int right,int key){
        if(right<left){
            return -1;
        }
        int mid = left+ ((right-left)>>1);
        int midValue = arr[mid];
        if(midValue < key){  //如果查找的值大于中间值的话
            return binarySearch(arr,mid+1,right,key);
        }else if(midValue > key)
            return binarySearch(arr,left,mid-1,key);
        else
            return mid;

    }
//    希尔排序  插入排序的升级 冒泡选择插入希尔 基础排序算法
//    也叫减小增量排序
    public static void shellSort(int[] arr){
        for (int interval = arr.length; interval > 0 ; interval/=2) {
            //插入排序
            for (int i = interval;i<arr.length;i++){
                int target = arr[i];
                int j = i-interval;
                while (j >-1 && arr[j]>target){
                    arr[j+interval]=arr[j];
                    j-=interval;
                }
                arr[j+interval]=target;
            }
        }
    }
    public static int fun(int[] arr){
        int left = 0;
        int right = arr.length-1;
        if(arr[left]<arr[right]) return arr[left];
        while (left+1 < right){
            int mid = left+((right-left)>>1);
            if(arr[mid]>arr[mid-1]){
                //左边有序  只考虑右边
                left = mid;
            }else{
                //右边有序 只考虑左边
                right = mid;
            }
        }
        return arr[right];
    }
    public static int fun3(String[] arr,String goal){
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid = left+((right-left)>>1);
            while (arr[mid].equals("")){
                mid++;
                if(mid>right){
                    return -1;   //也说明没有找到
                }
            }
            if(arr[mid].compareTo(goal)>0){
                //说明中间值比目标值要大 所以往左边找
                right = mid -1;
            }else if(arr[mid].compareTo(goal)<0){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        //说明没找到
        return -1;
    }
    static int maxLen=0;  //连续子序列长度
    static int leftIndex=0;
    static int rightIndex=0;
    public static int[] fun4(int[] arr){
        int left = 0;
        int right = 0;
        while (right<arr.length-1){
            while (right<arr.length-1 && arr[right+1]>arr[right] ){
                right++;
            }
            right++;
            int Len=right-left;
            if(Len>maxLen) {
                maxLen=Len;
                leftIndex=left;
                rightIndex=right;
            }
            left=right;
        }
        return new int[]{maxLen,leftIndex,rightIndex};
    }
//    logN 复杂度的 幂运算 a^n
    public static long pow(int a, int n){
        if(n==0) return 1;
        long res = a ;//res是result的简写
        int ex = 1;  //ex是指数部分的简写
        while ((ex<<1)<=n){
            res*= res;
            ex<<=1;
        }
        //还差n-ex次方没有计算
        return res*pow(a,n-ex);
    }
}
