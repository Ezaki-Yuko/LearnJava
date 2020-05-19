/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo73
 * @Author: LENOVO
 * Date: 2020/5/12 17:01
 * project name: 20200428
 * @Version:
 * @Description:
 */

import java.util.Stack;

/**
 * 用两个栈实现队列
 * A用来入队列 B用来出队列
 * 实现入队列 先把B中所有的元素倒腾到A中 然后直接往A中入栈即可
 * 实现出队列 先把A中的所有元素倒腾到B中 对B进行出栈
 * 取队首元素 把A中的元素都倒腾到B中 取B的栈顶元素就是队首元素
 */

/**
 * 刚进行完push 都在A
 * 刚进行完peek/pop 所有元素都在B
 * 元素存在在B 相当于队首在栈顶 操作队首
 * 所有元素在A 相当于队尾放在栈顶
 */
public class TestDemo73 {
    private Stack<Integer> A=new Stack<>();
    private Stack<Integer> B=new Stack<>();
    public void offer(int x){
        //先把B中的元素倒腾到A
        while(!B.isEmpty()){
            int temp=B.pop();
            A.push(temp);
        }
        //新元素入A
        A.push(x);

    }
    public  Integer poll(){
        //如果为空直接返回
        if(empty()){
            return null;
        }
        //把A中的元素都倒腾给B
        while(!A.isEmpty()){
            int temp=A.pop();
            B.push(temp);

        }
        //针对B进行出栈
        return B.pop();
    }
    public  Integer peek(){
        //如果为空直接返回
        if(empty()){
            return null;
        }
        //把A中的元素都倒腾给B
        while(!A.isEmpty()){
            int temp=A.pop();
            B.push(temp);

        }
        //针对B进行取栈顶元素
        return B.peek();
    }
    public boolean empty(){
        return A.isEmpty()&&B.isEmpty();
    }
}
