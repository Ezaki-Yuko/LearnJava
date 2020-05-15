/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo69
 * @Author: LENOVO
 * Date: 2020/5/11 21:19
 * project name: 20200428
 * @Version:
 * @Description:
 */
//通过链表
public class TestDemo69 {
    //Node叫内部类 ,定义在某个类或方法中的类
    //static 的效果 创建Node实例不依赖TestDemo69的实例
    static class Node{
        public int val;
        Node next=null;

        public Node(int val) {
            this.val = val;
        }
    }
    //创建一个链表要有头结点
    //此处的head节点不是傀儡结点
    //基于链表实现队列 尾插头删 头插尾删
    //无论哪种都要记录头尾
    private Node head=null;
    private Node tail=null;
    //入队列 标准库中的队列就是offer
    //头出 尾进
    public void offer(int val){
        Node newNode=new Node(val);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        //如果当前不是空链表
        tail.next=newNode;
        tail=tail.next;
    }
    //出队列
    public Integer poll(){
        //如果当前队列就是空队列 再去poll显然不科学
        if(head==null){
            return null;
        }
        int ret=head.val;
        head=head.next;
        if(head==null){
            tail=null;
        }
        return ret;
    }
    //取队首元素
    public Integer peek(){
        if(head==null){
            return null;
        }
        return head.val;
    }
}
