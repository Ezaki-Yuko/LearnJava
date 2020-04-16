/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo44
 * @Author: LENOVO
 * Date: 2020/4/14 19:52
 * project name: 20200414
 * @Version:
 * @Description:
 */

/**
 * 实现队列也可以使用链表,也可以使用顺序表
 * 先用链表的方式来实现(更简单一些)
 * 链表的尾部作为队尾(方便插入元素) 链表头部作为队首(方便删除元素)
 * 为了方便的实现尾插,多搞一个引用指向链表的尾部
 */

public class TestDemo44 {
    static class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node head=new Node(-1);
    private Node tail=head;

    private int size;//队列中的元素个数
    //入队列(链表尾插)
    public void offer(int value){
        Node newNode=new Node(value);
        //核心操作就是这一行代码
        tail.next=newNode;
        tail=tail.next;
    }
    //出队列(链表头删)
    public Integer poll(){
        if(head.next==null){
            //队列为空,出队列失败
            return null;
        }
        Node toDelete=head.next;
        head.next=toDelete.next;
        if(head.next==null){
            //此时队列已经为空了.
            //让tail指回傀儡结点
            tail=head;
        }
        return toDelete.val;
        //不要忘了更新尾部
    }
    //取队首元素
    public Integer peek(){
        if(head.next==null){
            //空队列
            return null;
        }
        return head.next.val;
    }

    public static void main(String[] args) {
        TestDemo44 testDemo44=new TestDemo44();
        testDemo44.offer(1);
        testDemo44.offer(2);
        testDemo44.offer(3);
        testDemo44.offer(4);
        while(true){
            Integer cur=testDemo44.poll();
            if(cur==null){
                break;
            }
            System.out.println(cur);
        }
    }
}

