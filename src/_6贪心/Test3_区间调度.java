package _6贪心;

import java.util.Arrays;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-10 14:22
 **/
public class Test3_区间调度 {
    public static void main(String[] args) {
        int[] s = new int[]{13,11,9,8,5,1,4,2,1};
        int[] f = new int[]{16,14,11,10,9,8,7,5,3};
        Job[] jobs = new Job[s.length];
        for (int i = 0; i < s.length; i++) {
            jobs[i] = new Job(s[i],f[i]);
        }
        Arrays.sort(jobs);
        for (Job job:jobs) {
            System.out.println(job.s+"**"+job.t);
        }
        int n = s.length;
        int res = f(jobs,n);
        System.out.println(res);
    }
    static int cnt=1;
    private static int f(Job[] jobs, int n) {
        int y =jobs[0].t;
        for (int i = 0; i < n; i++) {
            if(jobs[i].s>y){
                cnt++;
                y=jobs[i].t;
            }
        }
        return cnt;
    }

    /**
     * 自定义对象排序
     */
    private static class Job implements Comparable<Job>{
        int s;
        int t;
        public Job(int s,int t){
            this.s=s;
            this.t=t;
        }
        @Override
        public int compareTo(Job other) {
            int x = this.t-other.t; //先比较结束时间
            if (x==0){
                return this.s-other.s;  //比较开始时间
            }
            return x;
        }
    }
}

