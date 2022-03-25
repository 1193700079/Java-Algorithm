package _1_recursion;

import java.util.Arrays;

public class Test_合并数组 {
    public static void main(String[] args) {
        int[] a = new int[10];
        int blength = 4;
        int acount = 0;
        for (int i = 0; i < a.length-blength; i++) {
            a[i] = i+1;
            acount++;
        }
        Utils.printArrays(a);
        int[] b = Utils.createRandomArray(blength,1,15);
        Utils.printArrays(b);
        Arrays.sort(b);
        //合并
        int sp = a.length-1;
        int asp = acount-1;
        int bsp = b.length-1;
        while (asp>=0&&bsp>=0){
            if(a[asp]>=b[bsp]){
                a[sp--]=a[asp--];
            }else {
                a[sp--]=b[bsp--];
            }
        }
        while (asp>=0){
            a[sp--]=a[asp--];
        }
        while (bsp>=0){
            a[sp--]=b[bsp--];
        }

        Utils.printArrays(a);
    }
}
