/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork7
 * @Author: LENOVO
 * Date: 2020/3/25 18:18
 * project name: 20200325
 * @Version:
 * @Description:
 */

/**
 * 单链表
 */
class Node{
    public int data;
    public Node next;
    public Node(int data) {
        this.data = data;
    }
}
public class HomeWork7 {
    //头结点
    public Node head;

    public HomeWork7(Node head) {
        this.head = null;
    }
    //增删改查
    //头插法
    public void addFirst(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
            return;
        }
        node.next=this.head;
        this.head=node;
    }
    //尾插法
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
    //让一个引用先走index-1步
    public Node findIndex(int index){
        Node cur=this.head;
        int count=0;
        while(count<index-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }
    //任意位置插入,第一个数据结点为0号下标
    public void addIndex(int index,int data){
        if(index<0||index>size()){
            throw new RuntimeException("index位置不合法!");
        }
        if(index==1){
            addFirst(data);
            return;
        }
        if(index==size()){
            addLast(data);
            return;
        }
        Node cur=findIndex(index);
        Node node=new Node(data);
        node.next=cur.next;
        cur.next=node;
    }
    //查找关键字key是否在单链表中
    public boolean contains(int key){
        Node cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
        }
        return false;
    }
    //打印单链表
    public void display(){
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }

}















