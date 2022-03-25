package _1_recursion;


public class _5计数排序 {
    static int[] tmp = new int[20];
    public static void main(String[] args) {
        int[] arr = Utils.createRandomArrayNotRepetition(10,0,19);
        Utils.printArrays(arr);
        jishuSort(arr);
    }

    /**
    * @Description: 计数排序  最快的排序算法 不过耗费的空间大
    * @Param: [arr]
    * @return: void
    * @Author: yrq
    * @Date: 2020/1/15
    */
    private static void jishuSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            tmp[arr[i]]++;
        }
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i]>=1){
                while (tmp[i]>0){
                System.out.print(i+" ");
                tmp[i]--;
            }
        }
        }
    }

}
