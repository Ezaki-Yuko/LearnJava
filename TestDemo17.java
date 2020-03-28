/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo17
 * @Author: LENOVO
 * Date: 2020/3/28 9:05
 * project name: 20200328
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
public class TestDemo17 {
    public Node head;

    public TestDemo17() {
        this.head = null;
    }

    //如果cur为空 cur.next会空指针异常
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public Node deleteDuplication() {
        Node cur=this.head;
        Node node=new Node(-1);
        Node temp=node;
        while(cur!=null){
            if(cur.next!=null&&cur.data==cur.next.data){
                while(cur.next!=null&&cur.data==cur.next.data){
                    cur=cur.next;
                }
            }else{
                temp.next=cur;
                temp=temp.next;
                cur=cur.next;
            }
        }
        //尾结点
        temp.next=null;
        return node.next;
    }
    //链表的回文结构
    public boolean chkPalindrome() {
        Node fast=this.head;
        Node slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //slow所指就是中间节点
        Node cur=slow.next;
        while(cur!=null){
            Node curNext=cur.next;
            cur.next=slow;
            slow=cur;
            cur=curNext;
        }
        //slow->单链表的最后一个节点
        while(slow!=this.head){
            if(slow.data!=this.head.data){
                return false;
            }
            if(this.head.next==slow){
                return true;
            }
            slow=slow.next;
            this.head=this.head.next;
        }
        return true;
    }
    //输入两个链表，找出它们的第一个公共结点
    //相交后的状态是Y字型
    //1.两个单链表长度不一样,
    public Node getIntersectionNode(Node head1,Node head2){
        if(head1==null||head2==null){
            return null;
        }
        int len1=0;
        int len2=0;
        Node pL=head1;
        Node ps=head1;

        while(pL!=null){
            len1++;
            pL=pL.next;
        }
        while(ps!=null){
            len2++;
            ps=ps.next;
        }
        //如果不指回来 就是空了
        pL=head1;
        ps=head2;
        int len=len1-len2;
        if(len<0){
            pL=head2;
            ps=head1;
            len=len2-len1;
        }
        //可以保证:
        //1.pL指向长的单链表 ps指向短的
        while(len>0){
            pL=pL.next;
            len--;
        }
        //
        while(pL!=null&&ps!=null&&pL!=ps){
            ps=ps.next;
            pL=pL.next;
        }
        if(pL!=null&&ps!=null&&pL==ps){
            return pL;
        }
        return null;
    }
    //判断单链表有环
    //1个1步 一个2步 (3,4...都可以 但是2时间最短)
    public boolean hasCycle(){
        Node fast=this.head;
        Node slow=this.head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return false;
        }
        return true;
    }
    //相遇点
    public Node meetCycle(){
        Node fast=this.head;
        Node slow=this.head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        return fast;
    }
    //入口点
    public Node detectCycle(){
        Node fast=this.head;
        Node slow=this.head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=this.head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }


}




