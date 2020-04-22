import java.util.LinkedList;
import java.util.Queue;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo51
 * @Author: LENOVO
 * Date: 2020/4/16 19:17
 * project name: 20200416
 * @Version:
 * @Description:
 */
public class TestDemo51 {
    Queue<Integer> A=new LinkedList<>();
    Queue<Integer> B=new LinkedList<>();
    /** Initialize your data structure here. */
    public TestDemo51() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        //直接把元素往A中入队即可
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //如果栈为空 单独处理
        if(empty()){
            return 0;
        }
        //需要把A中的所有元素都往B中倒腾 倒腾到只剩一个元素,再把最后一个元素删掉
        while(A.size()>1){
            Integer cur=A.poll();
            B.offer(cur);
        }
        //循环结束A中只有一个元素 这个元素就是栈顶元素
        int top=A.poll();
        //完成操作之后记得交换AB
        swapAB();
        return top;
    }
    public void swapAB(){
        Queue<Integer>temp=A;
        A=B;
        B=temp;
    }

    /** Get the top element. */
    public int top() {
        if(empty()){
            return 0;
        }
        //需要把A中的所有元素都往B中倒腾 倒腾到只剩一个元素,再把最后一个元素删掉
        while(A.size()>1){
            int cur=A.poll();
            B.offer(cur);
        }
        int top=A.poll();
        B.offer(top);
        swapAB();
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
