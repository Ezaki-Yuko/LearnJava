/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork9
 * @Author: LENOVO
 * Date: 2020/3/26 16:29
 * project name: 20200326
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
//不带头结点的单向链表
public class HomeWork9 {
    public Node head;

    public HomeWork9(){
        this.head=null;
    }
    //头插
    public void addFirst(int data){
        Node node=new Node(data);
        if(this.head==null){
            //第一次插入节点
            this.head=node;
            //如果没有return就会自己指向自己,打印时陷入循环
            return;
        }
        node.next=this.head;
        this.head=node;
    }
    //尾插
    public void addLast(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
            return;
        }
        Node cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }
    //得到单链表的长度
    public int size(){
        Node cur=this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    //打印单链表
    public void display(){
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
    public void display2(Node newHead){
        Node cur=newHead;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
    //让一个引用先走index-1步
    public Node findIndex(int index){
        Node cur=this.head;
        int count=0;
        while(count<index-1){
            count++;
            cur=cur.next;
        }
        return cur;
    }
    //在任意位置插入,第一个数据为0号下标
    public void addIndex(int index,int data){
        if(index<0||index>size()){
            throw new RuntimeException();
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==size()){
            addLast(data);
            return;
        }
        Node node=new Node(data);
        Node pre=findIndex(index);
        node.next=pre.next;
        pre.next=node;
    }
    //查找是否包含关键字key在单链表当中
    public boolean contains(int key){
        Node cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //找关键字的前驱
    //没有判断头结点
    //头结点没有前驱
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
    //判断是不是有这个关键字
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
    //内存泄漏发生在程序运行的时候 JVM回收内存的时候 当该对象没有人引用的时候就会被自动回收
    //如何测试内存泄漏: cmd中的命令jps jmap
    //任何的数据结构都有可能发生内存泄漏
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
    //第二种方法可以拿到一个节点就头插
    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点
    //如果有两个中间结点，则返回第二个中间结点。
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
