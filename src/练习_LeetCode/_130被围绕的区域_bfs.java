package 练习_LeetCode;

import java.sql.PseudoColumnUsage;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description:
 * 反着考虑的bfs
 * @author: yrq
 * @create: 2020-02-25 08:29
 **/
public class _130被围绕的区域_bfs {
    public static class Pos{
        int i;
        int j;
        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[4][4];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String s= sc.next();
                board[i][j] = s.charAt(0);
            }

        }
        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isEdge = i==0||j==0||i==board.length-1||j==board[0].length-1;
                if(isEdge && board[i][j]=='O' ){
                    Queue<Pos> q = new LinkedList<>();
                    q.add(new Pos(i,j));
                    while (!q.isEmpty()){
                        Pos cur = q.poll();
                        board[cur.i][cur.j] ='#';
                        if( cur.j+1<board[0].length && board[cur.i][cur.j+1]=='O' ){
                            q.add(new Pos(cur.i,cur.j+1));
                        }
                        if( cur.i+1<board.length && board[cur.i+1][cur.j]=='O'  ){
                            q.add(new Pos(cur.i+1,cur.j));
                        }
                        //左
                        if(cur.j-1> 0 && board[cur.i][cur.j-1]=='O' ){
                            q.add(new Pos(cur.i,cur.j-1));
                        }
                        //上
                        if(cur.i-1>0 && board[cur.i-1][cur.j]=='O') {
                            q.add(new Pos(cur.i-1,cur.j));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
