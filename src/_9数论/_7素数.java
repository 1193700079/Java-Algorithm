package _9数论;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-04 15:42
 **/
public class _7素数 {
    public static void main(String[] args) {
//        Map<Integer,Integer> res = primeFactor(100);
//        for (Map.Entry<Integer,Integer> map:res.entrySet()) {
//            int k = map.getKey();
//            int v = map.getValue();
//            System.out.println(k+" "+v);
//        }
        primeNum(100000);
    }

    /*高斯素数筛选法*/
    public static void primeNum(int N){
        int n = 2;
        while (n/Math.log(n) < N){  //关键确定数组的大小！！
            n++;
        }
        int[] a = new int[n];
        Arrays.fill(a,0);
        int x = 2;
        while (x<n){
            if(a[x]!=0){
                x++;
                continue;
            }
            int k = 2;
            while (x*k<n){
                a[x*k] = -1;
                k++;
            }
            x++;
        }
        int sum = 0;
        for (int i = 2; i < a.length; i++) {
            if(a[i]==0) sum++;
            if(sum==N){
                System.out.println(i);
                return;
            }
        }

    }
    /*效率提高版 只要遍历根号n之前的就可以了*/
    public static boolean isPrime(int n){
        for (int i = 2; i*i < n ; i++) {
            if(n%i==0) return false;
        }
        return true;
    }

    /*质因数分解*/
    public static Map<Integer,Integer> primeFactor(int n){
        Map<Integer,Integer> map = new HashMap<>();   //map是记录每个因子 和每个因子出现的次数
        int len = n;
        for (int i = 2; i*i < len ; i++) {
            while (n%i==0) {  //一个个除尽
                Integer v = map.get(i);
                if(v==null){
                    map.put(i,1);
                }else {
                    map.put(i,v+1);
                }
                n/=i;
            }
        }
        return map;
    }

}
