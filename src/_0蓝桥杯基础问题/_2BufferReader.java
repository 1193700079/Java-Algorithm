package _0蓝桥杯基础问题;

/**
 * @program: lanqiaobei2020
 * @description:  BufferReader的效率大概是Scanner的十倍左右 对于海量数组的读取还是用这个
 * @author: yrq
 * @create: 2020-01-19 11:33
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class _2BufferReader{


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.valueOf(br.readLine());
        while (q-- > 0) {
            String[] parts = br.readLine().split(" ");
            int l = Integer.valueOf(parts[0]);
            int r = Integer.valueOf(parts[1]);

            int k = (r-l+1)/2;
            int res = 0;
            if(l%2==0)
                res = -k;
            else
                res = k;
            if((r-l+1)%2==1){
                if(r%2==0)
                    res += r;
                else
                    res -=r;
            }
            System.out.println(res);
        }
    }
}