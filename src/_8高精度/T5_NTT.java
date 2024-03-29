//package _8高精度;
//
//import java.math.BigInteger;
//import java.util.Scanner;
//
///**
// * @program: lanqiaobei2020
// * @description:
// * @author: yrq
// * @create: 2020-02-29 21:14
// **/
//public class T5_NTT {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        String A= sc.next();
//        String B= sc.next();
//        int len=0;
//
//        Prepare(A, B, a, b, len);
//        Conv(a, b, len);
//        Transfer(a, len);
//        Print(a, len);
//
//    }
//    void Prepare(char A[], char B[], LL a[], LL b[], int &len)  
//    {  
//    len = 1;  
//    int len_A = strlen(A);  
//    int len_B = strlen(B);  
//    while(len <= 2 * len_A || len <= 2 * len_B) len <<= 1;  
//    for(int i=0; i<len_A; i++)  
//        A[len - 1 - i] = A[len_A - 1 - i];  
//    for(int i=0; i<len - len_A; i++)  
//        A[i] = '0';  
//    for(int i=0; i<len_B; i++)  
//        B[len - 1 - i] = B[len_B - 1 - i];  
//    for(int i=0; i<len - len_B; i++)  
//        B[i] = '0';  
//    for(int i=0; i<len; i++)  
//        a[len - 1 - i] = A[i] - '0';  
//    for(int i=0; i<len; i++)  
//        b[len - 1 - i] = B[i] - '0';  
//    }  
//              
//    void Rader(LL a[], int len)  
//    {  
//    int j = len >> 1;  
//    for(int i=1; i<len-1; i++)  
//    {  
//        if(i < j) swap(a[i], a[j]);  
//        int k = len >> 1;  
//        while(j >= k)  
//        {  
//            j -= k;  
//            k >>= 1;  
//        }  
//        if(j < k) j += k;  
//    }  
//    }  
//              
//    void NTT(LL a[], int len, int on)  
//    {  
//    Rader(a, len);  
//    int id = 0;  
//    for(int h = 2; h <= len; h <<= 1)  
//    {  
//        id++;  
//        for(int j = 0; j < len; j += h)  
//        {  
//            LL w = 1;  
//            for(int k = j; k < j + h / 2; k++)  
//            {  
//                LL u = a[k] % P;  
//                LL t = w * (a[k + h / 2] % P) % P;  
//                a[k] = (u + t) % P;  
//                a[k + h / 2] = ((u - t) % P + P) % P;  
//                w = w * wn[id] % P;  
//            }  
//        }  
//    }  
//    if(on == -1)  
//    {  
//        for(int i = 1; i < len / 2; i++)  
//            swap(a[i], a[len - i]);  
//        LL Inv = quick_mod(len, P - 2, P);  
//        for(int i = 0; i < len; i++)  
//            a[i] = a[i] % P * Inv % P;  
//    }  
//    }  
//              
//    void Conv(LL a[], LL b[], int n)  
//    {  
//    NTT(a, n, 1);  
//    NTT(b, n, 1);  
//    for(int i = 0; i < n; i++)  
//        a[i] = a[i] * b[i] % P;  
//    NTT(a, n, -1);  
//    }  
//              
//    void Transfer(LL a[], int n)  
//    {  
//    int t = 0;  
//    for(int i = 0; i < n; i++)  
//    {  
//        a[i] += t;  
//        if(a[i] > 9)  
//        {  
//            t = a[i] / 10;  
//            a[i] %= 10;  
//        }  
//        else t = 0;  
//    }  
//    }  
//              
//    void Print(LL a[], int n)  
//    {  
//    bool flag = 1;  
//    for(int i = n - 1; i >= 0; i--)  
//    {  
//        if(a[i] != 0 && flag)  
//        {  
//            printf("%d", a[i]);  
//            flag = 0;  
//        }  
//        else if(!flag)  
//            printf("%d", a[i]);  
//    }  
//    puts("");  
//    }  
//}
