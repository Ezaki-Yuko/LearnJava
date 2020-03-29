/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo19
 * @Author: LENOVO
 * Date: 2020/3/29 15:14
 * project name: 20200329
 * @Version:
 * @Description: 无头双向单链表
 */
class ListNode{
    public int val;
    public ListNode prev;//前驱
    public ListNode next;//后继

    public ListNode(int val){
        this.val=val;
    }
}

public class TestDemo19 {
    //头插法
    public ListNode head;//头
    public ListNode last;//尾
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
            return;
        }
        node.next=this.head;
        this.head.prev=node;
        this.head=node;
    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.last == null){
            this.last = node;
            this.head = node;
            return;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
    }
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index<0||index>size()){
            throw new RuntimeException("index位置不合法");
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==size()){
            addLast(data);
            return;
        }
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        node.next=cur;
        node.prev=cur.prev;
        cur.prev=node;
        node.prev.next=node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                //当前cur是不是头结点
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                //当前cur是不是头结点
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
    public void display(){

    }
    public void clear(){
        this.head=null;
        this.last=null;
    }
}
