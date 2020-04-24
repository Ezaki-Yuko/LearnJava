import java.util.Stack;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo53
 * @Author: LENOVO
 * Date: 2020/4/16 20:23
 * project name: 20200416
 * @Version:
 * @Description:
 */
public class TestDemo53 {
    Stack<Integer> A=new Stack<>();
    Stack<Integer>B=new Stack<>();
    //AB同步 B存储A对应的元素个数下的最小值
    /** initialize your data structure here. */
    public TestDemo53() {

    }

    public void push(int x) {
        A.push(x);
        if(B.empty()){
            B.push(x);
            return;
        }
        int min =B.peek();//取出上一轮的最小值
        if(x<min){
            min=x;
        }
        B.push(min);
    }

    public void pop() {
        if(A.empty()){
            return;
        }
        A.pop();
        B.pop();
    }

    public int top() {
        if(A.empty()){
            return 0;
        }
        return A.peek();
    }

    public int getMin() {
        if(B.empty()){
            return 0;
        }
        return B.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

