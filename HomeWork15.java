/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork15
 * @Author: LENOVO
 * Date: 2020/3/30 14:55
 * project name: 20200330
 * @Version:
 * @Description:
 */
//实现双向链表(带傀儡节点)代码
class Node{
    public int data;
    public Node prev;
    public Node next;
    public Node(int data){
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}
class LinkedNode{
    Node head;
    Node last;
    public LinkedNode(){
        this.last=null;
        this.head=new Node(-1);
    }
    //打印链表
    public void display(){
        Node cur=this.head.next;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
    //头插法
    public void addFirst(int data){
        Node node=new Node(data);
        if(this.head.next==null){
            node.prev=this.head;
            this.head.next=node;
            this.last=node;
            return;
        }
        node.prev=this.head;
        node.next=this.head.next;
        this.head.next=node;
        node.next.prev=node;
    }
    //尾插法
    public void addLast(int data){
        Node node=new Node(data);
        if(this.last==null){
            this.last=node;
            this.head.next=node;
            node.prev=this.head;
            return;
        }
        this.last.next=node;
        node.prev=this.last;
        this.last=node;
    }
    //链表的长度
    public int size(){
        int count=0;
        Node cur=this.head.next;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    //在任意位置插入 第一个节点 除头结点 为0
    public void addIndex(int index,int key){
        if(index<0||index>size()){
            throw new RuntimeException("index位置不合法!");
        }
        if(index==0){
            addFirst(key);
            return;
        }
        if(index==size()){
            addLast(key);
            return;
        }
        Node cur=this.head.next;
        int a=0;
        while(a<index){
            cur=cur.next;
            a++;
        }
        Node node=new Node(key);
        node.next=cur;
        node.prev=cur.prev;
        cur.prev=node;
        node.prev.next=node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur=this.head.next;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //删除第一次出现key的节点
    public void remove(int key){
        Node cur=this.head.next;
        while(cur!=null){
            if(cur.data==key){
                if(cur==last){
                    cur.prev.next=null;
                    this.last=cur.prev;
                }else{
                    cur.prev.next=cur.next;
                    cur.next.prev=cur.prev;
                }
                return;
            }
            cur=cur.next;
        }
    }
    public void removeAll(int key){
        Node cur=this.head.next;
        while(cur!=null){
            if(cur.data==key){
                if(cur==last){
                    cur.prev.next=null;
                    this.last=cur.prev;
                }else{
                    cur.prev.next=cur.next;
                    cur.next.prev=cur.prev;
                }
            }
            cur=cur.next;
        }
    }
}
public class HomeWork15 {
    public static void main(String[] args) {
        LinkedNode linkedNode=new LinkedNode();
        linkedNode.addLast(12);
        linkedNode.addFirst(11);
        linkedNode.addLast(13);
        linkedNode.addFirst(10);
        linkedNode.addFirst(9);
        linkedNode.addFirst(8);
        linkedNode.display();
        System.out.println(linkedNode.size());
    }
}
