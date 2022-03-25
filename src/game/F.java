package game;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class F {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader sc = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);

		int n =sc.nextInt();
		Student[] s = new Student[n];
		for(int i=0;i<n;i++){
			int len = sc.nextInt();
			int age = sc.nextInt();
			s[i] = new Student(len,age,i+1);

		}
		Arrays.sort(s);
		for(int i=0;i<n;i++){
			out.print(s[i].num+" ");
		}
		out.flush();

	}
//	static class cmp implements Comparator<Student> {
//
//
//		@Override
//		public int compare(Student ss, Student s) {
//			// TODO Auto-generated method stub
//			if(ss.len!=s.len){
//				return ss.len-s.len;
//			}
//			if(ss.age != s.age){
//				return ss.age-s.age;
//			}
//			return ss.num-s.num;
//		}
//	}
	static class Student implements Comparable<Student>  {
		int len;
		int age;
		int num;

		public Student(int len,int age,int num){
			this.len = len;
			this.age = age;
			this.num = num;
		}

		@Override
		public int compareTo(Student s) {
			// TODO Auto-generated method stub
			if(this.len!=s.len){
				return this.len-s.len;
			}
			if(this.age != s.age){
				return this.age-s.age;
			}
			return this.num-s.num;

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
