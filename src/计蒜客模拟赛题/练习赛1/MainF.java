package 计蒜客模拟赛题.练习赛1;

import java.util.*;

/**
 * @program: lanqiaobei2020
 * @description: 寻找重复项
 * @author: yrq
 * @create: 2020-01-18 13:28
 **/
public class MainF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
//        long res = fun(A,B,C);//返回标号
        long res = solve(A,B,C);
        System.out.println(res);
    }
    public static long solve(long A, long B,long C)  {
        HashMap<Long,Integer> map=new HashMap<>();
        map.put(1l, 0);
        long s=1;
        int ans=-1;
        for(int i=1;i<=2000000;i++) {
            s=(A*s+s%B)%C;
            if(map.containsKey(s)) {
                ans=i;
                break;
            }
            map.put(s, i);
        }
        return ans;
    }

//    private static long fun(long a, long b, long c) {
//        long ai = 1L;
//        long an;
//        Set<Long> set = new HashSet<>();
//        int oldLen=0;
//        while (set.size()==oldLen){
//            an = (a*ai+ai%b)%c;
//            oldLen = set.size();
//            set.add(an);
//            if(set.size()>2000000){
//                return -1;
//            }
//            if(set.size()==oldLen){
//                //说明有重复项
//                return (long)(set.size()+1);
//            }
//            ai=an;
//            oldLen=set.size();
//        }
//        return -1;
//    }
}
