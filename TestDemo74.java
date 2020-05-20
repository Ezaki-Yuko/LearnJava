/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo74
 * @Author: LENOVO
 * Date: 2020/5/12 17:41
 * project name: 20200428
 * @Version:
 * @Description:
 */

import java.util.Stack;

/**
 * 实现一个最小栈 常数时间内检索最小元素 遍历的复杂度是O(N)
 * 只能用空间换时间
 * A正常按照栈的规则来插入删除元素
 * B存放的是当前栈中的最小值
 * B的栈顶元素本来就是A的最小值
 * B中插入的元素 是取出当前B的栈顶元素和A的新元素比 取最小值插入B中
 * 需要保证B中插入的值是当前A中的最小值
 * 此时无论对A进行怎样的操作B的栈顶元素始终表示A中的最小元素的值
 */
public class TestDemo74 {
    private Stack<Integer> A=new Stack<>();
    private Stack<Integer> B=new Stack<>();
    public void push(int x){
        A.push(x);
        if(B.isEmpty()){
            B.push(x);
            return;
        }
        int min=B.peek();
        if(x<min){
            min=x;
        }
        B.push(min);
    }
    public Integer pop(){
        if(A.isEmpty()){
            return null;
        }
        //AB是同步的数量
        B.pop();
        return A.pop();
    }
    public Integer peek(){
        if(A.isEmpty()){
            return null;
        }
        return A.peek();
    }
    public Integer getMin(){
        if(B.isEmpty()){
            return null;
        }
        return B.peek();
    }
}
