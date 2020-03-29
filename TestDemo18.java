/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo18
 * @Author: LENOVO
 * Date: 2020/3/29 14:21
 * project name: 20200329
 * @Version:
 * @Description:
 */
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class TestDemo18 {
    public Node head;

    public TestDemo18() {
        this.head = null;
    }
    //虚拟节点也叫傀儡节点
    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public Node mergeTwoLists() {
        TestDemo18 List1=new TestDemo18();
        TestDemo18 List2=new TestDemo18();
        Node headA=List1.head;
        Node headB=List2.head;
        Node newHead=new Node(-1);
        Node temp=newHead;
        while(headA!=null&&headB!=null) {
            if (headA.data < headB.data) {
                temp.next = headA;
                headA = headA.next;
                temp = temp.next;
            } else {
                temp.next = headB;
                headB = headB.next;
                temp = temp.next;
            }
        }
        //循环退出有可能是两种情况 headA!=null headB!=null
        if(headA!=null){
            temp.next=headA;
        }
        if(headB!=null){
            temp.next=headB;
        }
        return newHead.next;
    }
}
