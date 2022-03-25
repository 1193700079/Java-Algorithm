package 计蒜客模拟赛题.练习赛2;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * 推出数学公式以后
 * modInverse
 * @author: yrq
 * @create: 2020-03-01 13:53
 **/
public class F_火星救援 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = sc.nextInt();
        double[] a = new double[1000000];
        a[0] = 1;
        for (int i = 1; i < a.length; i++) {
            a[i] =  a[i-1]+ 1.0/(i+1);
        }
        for (int i = 0; i < t; i++) {
            double n =sc.nextDouble();
            double s =sc.nextDouble();  //装满油最多行驶的距离
            double ans = a[(int) n-1]*s;

            System.out.println(ans);
        }
    }
    static class InputReader {
        StreamTokenizer tokenizer;

        public InputReader(InputStream stream) {
            tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(stream)));
            tokenizer.ordinaryChars(33, 126);
            tokenizer.wordChars(33, 126);
        }

        public String next() throws IOException {
            tokenizer.nextToken();
            return tokenizer.sval;
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public boolean hasNext() throws IOException {
            int res = tokenizer.nextToken();
            tokenizer.pushBack();
            return res != tokenizer.TT_EOF;
        }

        public double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(next());
        }

        public BigInteger nextBigInteger() throws IOException {
            return new BigInteger(next());
        }
    }
}
