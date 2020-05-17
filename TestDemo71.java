/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo71
 * @Author: LENOVO
 * Date: 2020/5/11 22:25
 * project name: 20200428
 * @Version:
 * @Description:
 */

import java.util.Stack;

/**
 * 演示标准库的栈
 */
public class TestDemo71 {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        int ret=stack.pop();
        System.out.println(ret);
        //标准库中的stack为空 再次pop或者peek都会异常
        ret=stack.pop();
        System.out.println(ret);
        ret=stack.pop();
        System.out.println(ret);
        ret=stack.pop();
        System.out.println(ret);


    }
}
