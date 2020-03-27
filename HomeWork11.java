/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork11
 * @Author: Fan yuxuan
 * Date: 2020/3/27 14:16
 * project name: 20200327
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
public class HomeWork11 {
    public Node head;

    public HomeWork11(){
        this.head=null;
    }
    //头插法
    public void addFirst(int data){
        Node node=new Node(data);
        //第一次插入
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
    //打印单链表
    public void display(){
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
    //让一个引用先走index-1步
    public Node findIndex(int index){
        int count=0;
        Node cur=this.head;
        while(count<index-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }
    //在任意位置插入 第一个数据为0号下标
    public void addIndex(int index,int data){
        if(index<0||index>size()){
            throw new RuntimeException("插入位置不合法!");
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
    //查找是否包含关键字key在单链表中
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
    public Node findPre(int key){
        Node cur=this.head;
        //只有头结点和链表为空都是null
        //两个以上进去判断
        while(cur.next!=null){
            if(cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        //没有这个关键字
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head==null){
            return;
        }
        Node prev=this.head;
        Node cur=this.head.next;
        while(cur!=null){
            if(cur.data==key){
                prev.next=cur.next;
                cur=cur.next;
                break;
            }else{
                prev=prev.next;
                cur=cur.next;
            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }
    //删除第一次为key的
    public void remove2(int key){
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
}
