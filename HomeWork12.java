/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork12
 * @Author: LENOVO
 * Date: 2020/3/27 20:17
 * project name: 20200327
 * @Version:
 * @Description:
 */
public class HomeWork12 {
    public Node head;

    public HomeWork12(){
        this.head=null;
    }
    public Node findPre(int key){
        Node cur=this.head;
        while(cur.next!=null){
            if(cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点(删一个)
    public void remove(int key){
        if(this.head.data==key){
            this.head=this.head.next;
            return;
        }
        Node prev=findPre(key);
        if(prev==null){
            System.out.println("没有这个节点!");
            return;
        }
        prev.next=prev.next.next;
    }
    //删除所有值为key的节点
    public void removeAllkey(int key){
        //prev指向前驱,cur指向当前要删除的节点
        if(this.head==null){
            return;
        }
        Node prev=this.head;
        Node cur=this.head.next;
        while(cur!=null){
            if(cur.data==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=prev.next;
                cur=cur.next;
            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }
    public void clear1(){
        this.head=null;
    }
    //一个一个节点释放
    public void clear2(){
        while(this.head!=null){
            Node del=this.head.next;
            this.head.next=del.next;
        }
        this.head=null;
    }
    //反转单链表的一种方法
    public Node reverseList() {
        Node cur=this.head;
        Node prev=null;
        Node newHead=null;
        while(cur!=null){
            Node curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
    }
    public Node middleNode(){
        Node fast=this.head;
        Node slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //输入一个链表，输出该链表中倒数第k个结点
    public Node FindKthToTail(int k) {
        if (this.head == null || k <= 0) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        for (int i = 1; i < k; i++) {
            if(fast.next==null){
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public Node partition(int x) {
        if (this.head == null) {
            return null;
        }
        //两段链表
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while(cur!=null){
            if(cur.data<x){
                if(bs==null){
                    bs=cur;
                    be=bs;
                }else{
                    be.next=cur;
                    be=be.next;
                }
            }else{
                if(as==null){
                    as=cur;
                    ae=as;
                }else{
                    ae.next=cur;
                    ae=ae.next;
                }
            }
            cur=cur.next;
        }
        //第一个段没有数据
        if(bs==null){
            //只能返回第二个段
            return as;
        }
        //代码走到这里 说明bs!=null! 那么拼接两个段
        be.next=as;
        //只要第二个段不为空
        if(as!=null){
            as.next=null;
        }
        return bs;
    }
}
