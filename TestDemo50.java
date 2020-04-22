/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo50
 * @Author: LENOVO
 * Date: 2020/4/16 18:28
 * project name: 20200416
 * @Version:
 * @Description:
 */

/**
 * 栈的特点:后进先出 基本操作:入栈 出栈 取栈顶元素
 * 队列的特点:先进先出 基本操作:入队列 出队列 取队首元素
 * 基于顺序表和链表的方式来实现 搞栈和队列是为了限制线性表的操作,灵活不一定是好事
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 圈复杂度:用来描述一段代码复杂程度的指标
 * 一个方法中 每次遇到if圈复杂度+1 遇到else也加1 遇到for/while也+1 遇到switch 每个case都加一 &&加1 ||加1
 * 一个方法中圈复杂度不应该超过10
 * 优化:拆分成多个方法 转移表/表
 */
public class TestDemo50 {
    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        //1.创建一个栈
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack=new Stack<>();
        //2.循环遍历字符串,取出字符看是左括号还是右括号
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(map.get(c)!=null){
                stack.push(c);
                continue;
            }
            if(stack.empty()){
                return false;
            }
            Character top=stack.pop();
            if(map.get(c).equals(top)){
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
