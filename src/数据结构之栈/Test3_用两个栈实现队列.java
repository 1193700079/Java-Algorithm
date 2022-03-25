package 数据结构之栈;

import java.util.Stack;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-22 10:26
 **/
public class Test3_用两个栈实现队列 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.poll();
        myQueue.poll();
        myQueue.offer(4);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peekOfTail());
    }
    static class MyQueue{
        Stack<Integer> stack  ;
        Stack<Integer> buffer  ;   //作为栈的缓存区

        public MyQueue() {
            this.stack  = new Stack<>();
            this.buffer = new Stack<>();
        }

        //入队
        public void offer(int val){
            stack.push(val);
        }

        //出队
        public void poll(){
            while (stack.size()!=1){
                buffer.push(stack.pop());
            }
            stack.pop();
            while (buffer.size()!=0){
                stack.push(buffer.pop());
            }
        }

        //查看队尾元素
        public int peekOfTail(){
            return stack.peek();
        }

        //查看队首元素
        public int peek(){
            while (stack.size()!=1){
                buffer.push(stack.pop());
            }
           int res =  stack.peek();
            while (buffer.size()!=0){
                stack.push(buffer.pop());
            }
            return res;
        }
    }
}
