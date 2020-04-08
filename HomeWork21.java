/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork21
 * @Author: LENOVO
 * Date: 2020/4/8 12:26
 * project name: 20200408
 * @Version:
 * @Description:
 */

/**
 * 复习链表
 */
class Node{
    public int  val;
    public Node next;
    public Node(int val){
        this.val=val;
        this.next=null;
    }
}
public class HomeWork21{
    public Node head;
    public HomeWork21(){
        this.head=null;
    }
    public Node mergeTwoLists(Node l1, Node l2) {
        Node newHead=new Node(-1);
        Node temp=newHead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                temp.next=l1;
                l1=l1.next;
                temp=temp.next;
            }else{
                temp.next=l2;
                l2=l2.next;
                temp=temp.next;
            }
        }
        if(l1!=null){
            temp.next=l1;
        }
        if(l2!=null){
            temp.next=l2;
        }
        return newHead.next;
    }
}