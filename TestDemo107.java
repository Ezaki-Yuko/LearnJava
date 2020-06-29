/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo107
 * @Author: LENOVO
 * Date: 2020/6/4 17:34
 * project name: 20200603
 * @Version:
 * @Description:
 */

/**
 * Set可以用做去重
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 复制带随机指针的链表 该指针可以指向链表中任何节点/空节点 要求返回这个链表的深拷贝
 * 1.先把链表按照普通链表的方式复制一份,遍历每个节点,看节点random指针指向的位置相对于头结点的偏移量是几(从头结点出发走几步能到达random指向位置,根据这个偏移量来决定新链表中每个节点random的指向
 * 2.更简单的办法 创建一个map<Node,Node> key就是旧链表上的节点,value旧链表对应节点的拷贝(新链表的节点)
 *
 * Map结构准备好了之后,再次遍历旧链表,取出的节点在Map中找到对应的value
 * 新1.next=map.get(旧1.next)
 * 新1.random=map.get(旧1.random)
 *
 */
public class TestDemo107 {
    static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val){
            this.val=val;
            this.next=null;
            this.random=null;
        }
    }
    public Node copyRandomList(Node head){
        //1.遍历旧链表,把旧链表的每个节点依次插入到map中,key是旧链表节点,value是拷贝出来的新节点
        Map<Node,Node> map=new HashMap<>();
        for(Node cur=head;cur!=null;cur=cur.next){
            map.put(cur,new Node(cur.val));
        }
        //2.再次遍历链表,修改新链表的next和random
        for(Node cur=head;cur!=null;cur=cur.next){
            //先从map中找到该cur对应的新链表节点
            Node newCur=map.get(cur);
            newCur.next=map.get(cur.next);
            newCur.random=map.get(cur.random);

        }
        //需要返回新链表头结点
        return map.get(head);
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,10);
        map.put(2,20);
        map.put(3,30);
        map.put(4,40);
        map.put(5,50);
        //1.使用迭代器
        //Entry表示一个键值对
        //entrySet包含Entry的Set Set<Entry<Integer,Integer>>

        //Map<Integer,Integer>(可以根据key找到value)和Set<Entry<Integer,Integer>>(把刚才的Entry作为一个整体成为Set的Key)
        Iterator<Map.Entry<Integer,Integer>> iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> entry =iterator.next();
            //entry中有获取getkey/getvalue方法
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        //2.使用foreach
        //本质上也是靠迭代器来遍历
        //迭代器代码由编译器自动生成的
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
