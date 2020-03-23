/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo16
 * @Author: LENOVO
 * Date: 2020/3/23 17:49
 * project name: 20200323
 * @Version:
 * @Description:
 */

/**
 * 顺序表底层是数组
 * 目的:如果能够达到 要一个内存 分配一块内存
 * 链表:
 * 不带头节点的单向非循环链表->>不带头的单链表
 * 不带头的双向非循环链表->>不带头的双向链表
 * 单链表是由一个一个的节点来构成的
 *单链表本身是一种类型 但是他又是由节点构成 节点又包含data next
 * 节点类 data域和next域
 * 先定义节点
 * data的类型看自己放什么数据
 * next->保存下一个节点的地址 引用类型
 * Node next
 * 带头结点的头结点的data域是没有意义的
 * java底层的LinedList是双链表
 * 增 删 查 改
 */
//节点类
class Node{
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
    }
    public Node() {

    }
}
//单链表
//优点:随用随取
public class TestDemo16 {

    public Node head;

    public TestDemo16() {
        this.head = null;
    }
    //头插法 O(1)
    //1.首先需要拿到一个Node;
    //2.把它插入到head前面
    //node.next=head;
    //head=node;
    public void addFirst(int data){
        Node node=new Node(data);//node存储这个对象的地址

        if(this.head==null){
            //第一次插入节点
            this.head=node;
            return;
        }
        node.next=this.head;

        this.head=node;

    };
    //尾插法 O(n)
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
    };
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
        //1,让一个引用 先走index-1步
        Node prev=findIndex(index);
        //
        Node node=new Node(data);
        node.next=prev.next;
        prev.next=node;
    };
    //走index-1步
    private Node findIndex(int index){
        Node cur=this.head;
        int count=0;
        while(count<index-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    };

    /**
     * 找到关键字key的前驱
     * @param key
     * @return
     */
    private Node findPrev(int key){
        Node prev=this.head;
        while(prev.next!=null){
            if(prev.next.data==key){
                return prev;
            }
            prev=prev.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点(删一个)
    //1.找到要删除的节点的前驱 是不是头结点
    //2.没有这个节点
    //3.设置next的改变,达到删除的目的
    public void remove(int key){
        if(this.head.data==key){
            this.head=this.head.next;
            return;
        }
        Node prev=findPrev(key);
        if(prev==null){
            System.out.println("没有这个节点!");
            return;
        }
        Node del=prev.next;
        prev.next=del.next;
    };
    //删除所有值为key的节点(删很多)
    public void removeAllKey(int key) {
        //只需要遍历一次单链表,就把所有的key都删掉
        if(this.head==null){
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if(cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = prev.next;//prev=cur;
                cur = cur.next;
            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }
    //得到单链表的长度
    public int size(){
            int count = 0;
            Node cur = head;
            while (cur != null) {
                count++;
                cur = cur.next;
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
    };
    public void clear(){

    };

}