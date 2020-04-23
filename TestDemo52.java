/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo52
 * @Author: LENOVO
 * Date: 2020/4/16 19:49
 * project name: 20200416
 * @Version:
 * @Description:
 */

import java.util.Stack;

/**
 * A专门用来入队列
 * B专门用来出队列
 */
public class TestDemo52 {
    private Stack<Integer>A=new Stack<>();
    private Stack<Integer>B=new Stack<>();
    /** Initialize your data structure here. */
    public TestDemo52() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        //要保证所有的元素都在A中,然后再把X插入到A中
        while(!B.isEmpty()){
            Integer top=B.pop();
            A.push(top);
        }
        A.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        //先把A中的元素都往B中倒腾 再取B的栈顶元素出栈
        if(empty()){
            return 0;
        }
        while(!A.isEmpty()){
            Integer top=A.pop();
            B.push(top);
        }
        return B.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(empty()){
            return 0;
        }
        while(!A.isEmpty()){
            Integer top=A.pop();
            B.push(top);
        }
        return B.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return A.empty()&&B.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
