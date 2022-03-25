package 数据结构之链表;

/**
 * @program: lanqiaobei2020
 * @description:
 * @author: yrq
 * @create: 2020-02-19 11:30
 **/
public class DoubleLinkTest {
    public static void main(String[] args) {
        DoubleLink<String> doubleLink = new DoubleLink<>();
        doubleLink.insertTail("yrq");
        doubleLink.insertTail("abc");
        doubleLink.insertTail("ddd");
        doubleLink.traverse();
        doubleLink.delete(1);
        doubleLink.traverse();
        doubleLink.insertHead("qwer");
        doubleLink.traverse();
    }
}
