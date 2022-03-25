package 蓝桥杯模拟赛1;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-23 22:52
 **/
public class Main {
    public static void main(String[] args) {
        long ans = comb(36,13);
        System.out.println(ans);
    }
    static Map<String,Long> map= new HashMap<String, Long>();
    private static long comb(int m,int n){
        String key= m+","+n;
        if(n==0)
            return 1;
        if (n==1)
            return m;
        if(n>m/2)
            return comb(m,m-n);
        if(n>1){
            if(!map.containsKey(key))
                map.put(key, comb(m-1,n-1)+comb(m-1,n));
            return map.get(key);
        }
        return -1;
    }
}
