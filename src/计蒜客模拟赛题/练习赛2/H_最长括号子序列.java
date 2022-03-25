package 计蒜客模拟赛题.练习赛2;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-03-01 14:25
 **/
public class H_最长括号子序列 {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            int flag = 0;
            int ans=0;
            for (int j = 0; j < n; j++) {
                if(s.charAt(j)=='('){
                    flag++;
                }else if(flag>0){
                    flag--;
                    ans+=2;
                }
            }
            out.println( ans);
        }
        out.flush();
        out.close();
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
