package 数据结构之链表;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-19 11:16
 **/
public class DoubleLink<T> {
    public Node head;//定义链表的头结点
    public Node tail;//定义链表的尾结点
    public int size;
    public DoubleLink(){//初始化链表时创建一个头结点
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.size=0;
    }

    class Node {//Node  节点类
        T data;//数据域
        Node next;//地址域
        Node pre;//地址域

        public Node(){//将头结点初始化为  data=-1   next=null
            data = null;
            next = null;
            pre = null;
        }

        public Node(T val){//其他结点所需的构造函数
            data = val;
            next = null;
            pre =null;
        }
    }

    public void insertHead(T val){
        //创建一个节点
        Node cur = new Node(val);
        Node curNext = head.next; //做一个记录也行 顺序不重要了！
        head.next = cur;
        cur.next = curNext;
        cur.pre = head;
        curNext.pre = cur;
        this.size++;
    }

    public void insertTail(T val){
        Node cur = new Node(val);
        tail.pre.next = cur;
        cur.pre = tail.pre;
        tail.pre = cur;
        cur.next = tail;
        size++;
    }

//    public boolean insertPos(int pos,T val){
//        if(pos < 0 || pos > getSize()){
//            return false;
//        }else{
//            SingleLink.Node cur = head;
//            //找到插入的地方
//            for(int i = 0;i <= pos-1;i++){
//                cur = cur.next;
//            }
//            SingleLink.Node node = new SingleLink.Node(val);
//            //进行插入
//            node.next = cur.next;
//            cur.next = node;
//            this.size++;
//            return true;
//        }
//    }
    //删除 根据索引删除值
    public void delete(int pos){
        if(pos <0 || pos> getSize()){
            System.out.println("索引不正确");
        }else {
            Node tmp = head;
            Node preNode = null;
            for (int i = 0; i <=pos; i++) {
                preNode = tmp;
                tmp = tmp.next;
            }
            preNode.next=tmp.next;
            tmp.next.pre=preNode;
            tmp.next=null;
            tmp.pre=null;
            size--;
        }
    }
//
//    //查询  根据索引找到值
//    public T query(int pos){
//        if(pos <0 || pos> getSize()){
//            System.out.println("索引不正确");
//            return null;
//        }else {
//            SingleLink.Node tmp = head;
//            for (int i = 0; i <=pos; i++) {
//                tmp = tmp.next;
//            }
//            return tmp.data;
//        }
//
//    }
//    //查找 根据值返回索引
//    public int indexOf(T val){
//        SingleLink.Node tmp = head;
//        int index =0;
//        while (tmp.next!=null){
//            tmp = tmp.next;
//            if(tmp.data == val){
//                return index;
//            }
//            index++;
//        }
//        return -1;
//    }
    //更新
    public void update(int pos , T val){
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
            System.out.print("[ ");
            while (tmp.next!=tail){
                tmp = tmp.next;
                System.out.print(tmp.data + (tmp.next!=tail?",":" "));
            }
            System.out.println("]");
        }
    }
}
