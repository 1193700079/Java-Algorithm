package 数据结构之栈;

import java.util.Stack;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-21 21:33
 **/
public class _栈的最小值 {
    public static void main(String[] args) {

    }
    class MinStack {
        class Pair {
            int key;//存放的
            int value; //存放最小值的

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }
        }

        Stack<Pair> s;

        /** initialize your data structure here. */
        public MinStack() {
            s = new Stack<>();
        }

        public void push(int x) {

            if(s.empty()){
                s.push(new Pair(x,x));
            }else {
                s.push(new Pair(x,Math.max(x,getMin())));
            }
        }

        public void pop() {
            s.pop();
        }

        public int top() {
            return s.peek().getValue();
        }

        public int getMin() {
            return s.peek().getKey();
        }
    }
}
