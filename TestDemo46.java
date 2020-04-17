import java.util.Stack;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo46
 * @Author: LENOVO
 * Date: 2020/4/14 20:55
 * project name: 20200414
 * @Version:
 * @Description:
 */
public class TestDemo46 {
    public static void main(String[] args) {
        //标准库中的Stack是一个class
        Stack<Integer> stack=new  Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        //标准库中的stack如果针对空栈pop或者peep就会抛出空栈异常
        while(!stack.empty()){
            Integer cur=stack.pop();

            System.out.println(cur);
        }
        //由于标准库中的Stack是继承自Vector的类,Vector能执行的操作,Stack也一样可以
        //Stack并没有起到限制灵活性的效果,反而增加了代码的复杂程度
        //实际使用Stack尽量避免这些本不该是Stack的操作
        stack.add(2,100);
        stack.get(0);
        stack.contains(2);
    }
}
