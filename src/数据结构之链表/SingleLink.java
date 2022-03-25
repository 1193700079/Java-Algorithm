package 数据结构之链表;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-19 10:29
 **/

public class SingleLink<T>{//一个链表类

    public Node head;//定义链表的头结点
    public int size;
    public SingleLink(){//初始化链表时创建一个头结点
        head = new Node();
        this.size=0;
    }

    class Node {//Node  节点类
        T data;//数据域
        Node next;//地址域

        public Node(){//将头结点初始化为  data=-1   next=null
            data = null;
            next = null;
        }

        public Node(T val){//其他结点所需的构造函数
            data = val;
            next = null;
        }
    }

    public void insertHead(T val){
        //创建一个节点
        Node cur = new Node(val);
        cur.next = head.next;
        head.next = cur;
        this.size++;
    }

    public void insertTail(T val){
        Node tmp;
        Node cur = new Node(val);
        tmp = head;
        /*
         * 遍历链表到最后一个结点
         */
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = cur;
        cur.next = null;
        this.size++;
    }

    public boolean insertPos(int pos,T val){
        if(pos < 0 || pos > getSize()){
            return false;
        }else{
            Node cur = head;
            //找到插入的地方
            for(int i = 0;i <= pos-1;i++){
                cur = cur.next;
            }
            Node node = new Node(val);
            //进行插入
            node.next = cur.next;
            cur.next = node;
            this.size++;
            return true;
        }
    }
    //删除 根据索引删除值
    public void delete(int pos){
        if(pos <0 || pos> getSize()){
            System.out.println("索引不正确");
        }else {
            Node tmp = head;
            Node pre = null;
            for (int i = 0; i <=pos; i++) {
                pre =tmp;
                tmp = tmp.next;
            }
            pre.next=tmp.next;
            tmp.next=null;
            size--;
        }
    }

    //查询  根据索引找到值
    public T query(int pos){
        if(pos <0 || pos> getSize()){
            System.out.println("索引不正确");
            return null;
        }else {
            Node tmp = head;
            for (int i = 0; i <=pos; i++) {
                tmp = tmp.next;
            }
            return tmp.data;
        }

    }
    //查找 根据值返回索引
    public int indexOf(T val){
        Node tmp = head;
        int index =0;
        while (tmp.next!=null){
            tmp = tmp.next;
            if(tmp.data == val){
                return index;
            }
            index++;
        }
        return -1;
    }
    //更新
    public void updata(int pos ,T val){
        if(pos <0 || pos> getSize()){
            System.out.println("索引不正确");
        }else {
            Node tmp = head;
            for (int i = 0; i <=pos; i++) {
                tmp = tmp.next;
            }
            tmp.data = val;
        }

    }
    public int getSize(){
        return this.size;
    }

    public void traverse(){
        if(size==0){
            System.out.println(" ");
        }else {
            Node tmp = head;
            while (tmp.next!=null){
                tmp = tmp.next;
                System.out.print(tmp.data+" ");
            }
        }
    }

    /**
     * 找出倒数第K个元素
     * @param k
     * @return
     */
    public T getLastK(int k){
        int len = getSize();
        int index = len -k;
        Node p = head;
        Node pre = p;
        for (int i = 0; i <=index ; i++) {
            pre = p;
            p = p.next;
        }
        return pre.data;
    }


}

