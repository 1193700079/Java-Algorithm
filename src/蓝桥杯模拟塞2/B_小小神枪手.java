package 蓝桥杯模拟塞2;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-29 13:21
 **/
public class B_小小神枪手 {
    public static void main(String[] args) {
        double a = 0.75;
        int i = 0;
        int n = 1;
        double m=1;
        double[] d = new double[10];//命中的概率
        double[] e = new double[10];//不命中的概率
        while (true){

            d[i] = a*Math.pow(0.9,i); //记录没枪的命中率
            e[i] = 1-d[i];
            if(d[i]<0.5){
                break;
            }
            i++;
        }

        n=1;
        i--;
        double[] ans = new double[i];
        double res=0;
        for (int j = 0; j < i ; j++,n++) {
            double r=1;
            for (int k = 0; k < j; k++) {
                r*=(e[k]);
            }
            ans[j]=d[j]*r;
            res += n*ans[j];
        }
        System.out.println(res);
    }
}
