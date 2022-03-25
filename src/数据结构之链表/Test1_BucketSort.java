package 数据结构之链表;

import _1_recursion.Utils;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-19 14:41
 **/
public class Test1_BucketSort {
    public static void main(String[] args) {
        int[] arr =  Utils.createRandomArray(20,0,100);
        int len = arr.length;
        Node[] bucket = new Node[len];
        int maxValue = Utils.arrOfMax(arr);
        for (int i = 0; i < len; i++) {
            int value = arr[i];
            int hash = value*len/(maxValue+1);
            if(bucket[hash]==null){
                bucket[hash] = new Node(value);
            }else {
                //插入链表
                insertInBucket(value,bucket[hash],bucket,hash);
            }
        }
        int k = 0;
        for (Node node: bucket) {
            if(node!=null){
                while (node!=null){
                    arr[k++] = node.getData();
                    node = node.getNext();
                }
            }
        }
        Utils.printArrays(arr);
    }

    /**
     *
     * @param value
     * @param head  头结点
     * @param bucket
     * @param hash
     */
    private static void insertInBucket(int value, Node head, Node[] bucket, int hash) {
        Node tmp = new Node(value);
        //存放在头结点
        if(value<=head.getData()){
            bucket[hash] = tmp;
            tmp.next = head;
            return;
        }
        //找到一个比当前节点大的值
        Node p = head;
        Node pre = p; //记录上一个指针
        while (p!=null && value > p.getData()){
            pre = p;
            p=p.next;
        }
        if(p == null){  //说明到了最后了
            pre.next = tmp;
        }else {
            pre.next =tmp;
            tmp.next = p;
        }
    }


    static class Node{
        int data;
        Node next;

        public Node() {
            this.data=0;
            this.next=null;
        }

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
