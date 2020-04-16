/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo43
 * @Author: LENOVO
 * Date: 2020/4/14 19:14
 * project name: 20200414
 * @Version:
 * @Description:
 */
public class TestDemo43 {
    //使用链表也能使用栈,可以用链表头部表示栈顶,链表尾部表示栈底
    //一般表示链表都是用头结点表示链表
    //只要知道头结点,就能获取到后面的所有结点 "借代" 用局部表示整体
    //链表有八种链表
    //1.不带环的 vs 带环的
    //2.单向的 vs 双向的
    //3.带傀儡节点的 vs 不带傀儡结点的
    //此处为了方便写一个带傀儡结点的
    static class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    Node head=new Node(-1);
    public void push(int value){
        //头插
        Node newNode=new Node(value);
        newNode.next=head.next;
        head.next=newNode;
    }
    //接下来pop方法结束 toDelete这个引用就没有了 此时就没有哪个引用保存toDelete的地址了,
    // jvm的垃圾回收机制就会把这个节点判定为垃圾,就可以把这个内存自动释放了(可达性分析)
    public Integer pop(){
        //头删
        Node toDelete=head.next;
        if(toDelete==null){
            //链表为空.删除失败
            return null;
        }
        head.next=toDelete.next;
        return toDelete.val;
    }
    public Integer peek(){
        if(head.next==null){
            return null;
        }
        return head.next.val;
    }
}
