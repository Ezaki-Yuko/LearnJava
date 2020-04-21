import java.util.Stack;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo49
 * @Author: LENOVO
 * Date: 2020/4/14 21:19
 * project name: 20200414
 * @Version:
 * @Description:
 */
public class TestDemo49 {
    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        //1.创建一个栈
        Stack<Character> stack=new Stack<>();
        //2.循环遍历字符串,取出字符看是左括号还是右括号
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
                continue;
            }
            if(stack.empty()){
                return false;
            }
            Character top=stack.pop();
            if(top=='('&&c==')'){
                continue;
            }
            if(top=='['&&c==']'){
                continue;
            }
            if(top=='{'&&c=='}'){
                continue;
            }
            return false;
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
