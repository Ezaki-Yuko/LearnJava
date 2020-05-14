/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo68
 * @Author: LENOVO
 * Date: 2020/5/11 20:46
 * project name: 20200428
 * @Version:
 * @Description:
 */
/**
 * java中的一些框架 所谓框架的本质就是限制写代码的灵活性
 * 栈的实际应用场景很多 队列的实际应用场景更多
 * 入栈 出栈 取栈顶元素 后进先出
 * 入队列 出队列 取队首元素 先进先出
 * 栈和队列只支持三个核心操作
 */
/**
 * 实现栈
 * 数据结构与语言无关
 * jvm的内存区域划分(jvm的内存模型)=>jvm栈=>特指jvm中的那个内存区域
 *
 */
public class TestDemo68 {
    //管理一些int元素即可 也不考虑扩容
    private int[] array=new int[100];
    private int size=0;//栈中存在几个元素
    //入栈
    public void push(int x){
        array[size]=x;
        size++;
    }
    //取栈顶元素 最后进来的
    public int peek(){
        return  array[size-1];
    }
    //出栈
    public int pop(){
        int ret=array[size-1];
        size--;
        return ret;
    }
}
