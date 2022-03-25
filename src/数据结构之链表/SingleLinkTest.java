package 数据结构之链表;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-19 10:34
 **/
public class SingleLinkTest {

    public static void main(String[] args) {
        SingleLink<Integer> linkList = new SingleLink<>();
        linkList.insertTail(10);
        linkList.insertTail(11);
        System.out.println(linkList.getSize());
        linkList.insertPos(1,8);
        linkList.insertPos(0,99);
        linkList.updata(0,100);
        linkList.updata(3,100);
        linkList.traverse();
        System.out.println();
        System.out.println(linkList.query(2));
        System.out.println(linkList.indexOf(100));
        linkList.delete(3);
        linkList.traverse();
        System.out.println();
        System.out.println(linkList.getLastK(2));

    }
}
