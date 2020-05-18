/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo72
 * @Author: LENOVO
 * Date: 2020/5/12 15:01
 * project name: 20200428
 * @Version:
 * @Description:
 */

import java.util.*;

/**
 * 栈和队列都是基于线性表(顺序表+链表)来实现的
 * 栈:入栈 出栈 取栈顶元素
 * 队列:入队列 出队列 取队首元素
 * Stack基于vector/数组来实现 pop push peek
 * 队列 Queue 接口 add remove element 操作失败抛出异常 offer poll peek 操作失败返回错误值
 *
 */
//括号匹配问题 栈
//每次往栈中新增元素的时候从栈底往栈顶增长 先来的元素在栈底 后来的元素在栈顶 先出去的元素是栈顶元素 栈底元素最后才能出去

public class TestDemo72 {
    public boolean isValid(String s){
        //遍历字符串依次取出每个字符 如果是左括号 就把当前字符入栈
        //如果是右括号就去栈顶元素 查看是否匹配
        //如果类型匹配就把栈顶元素出栈 继续去取下一个字符
        //如果类型不匹配 直接判定非法 返回false
        //遍历完整个字符串 栈中内容为空就是合法 不为空就是非法
        //处理多层括号嵌套的问题
        //key左括号 value 右括号
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack =new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            //先判定c是否是左括号 左括号就入栈
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
                continue;//进入下次循环 取下个字符
            }
            if(stack.empty()){
                //当前字符不是左括号并且栈为空 就是非法的
                //前面没有左括号去匹配
                return false;
            }
            //判定c是否是右括号
            Character top=stack.pop();
            //合法1
            /*if(top=='('&&c==')'){
                continue;
            }
            //合法2
            if(top=='['&&c==']'){
                continue;
            }
            //合法3
            if(top=='{'&&c=='}'){
                continue;
            }*/
            //除了上面三种合法情况 其他都非法
            //根据key来查找value map.get(key)
            if(map.get(top)==c){
                continue;
            }
            return false;
        }
        //循环结束就是true 看栈是不是为空 为空才是true
        if(stack.empty()) {
            return true;
        }
        return false;
    }
}
//圈复杂度 if while for语句比较多就是圈复杂度比较高(圈复杂度越高越难理解) 拆分函数  转移表来降低圈复杂度
//内置类型就是比较值==
//引用类型==是比较身份 equals是比较内容 比较相等 compareTo是比较大小
//Stack继承vector 进而继承自List List里面的操作 Stack也支持

/**
 * 使用两个队列模拟实现栈的效果
 * 入栈 把新元素往A队列中入队列即可
 * 出栈 把A队列中的元素往B中倒腾
 * 当A中只剩下一个元素 就直接把最后一个元素直接出队列就可
 * 之后交换AB 保证入栈元素往A中入
 * 取栈顶元素 和出栈类似
 * 判定为空 A和B都为空
 */
class MyStackBy2Queue{
    private Queue<Integer> A=new LinkedList<>();
    private Queue<Integer> B=new LinkedList<>();

    public MyStackBy2Queue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void push(int x){
        //x往A中入队列即可
        A.offer(x);
    }
    public Integer pop(){
        if(empty()){
            return null;
        }
        //把A中元素往B中倒腾
        while(A.size()>1){
            //判定A中只剩一个
            Integer font=A.poll();
            B.offer(font);
        }
        //循环结束A中只有1个元素
        //这个元素就是被出栈的元素
        int ret=A.poll();
        //交换 AB
        swapAB();
        return ret;
    }
    private void swapAB(){
        Queue<Integer> temp=A;
        A=B;
        B=temp;

    }
    public Integer peek(){
        if(empty()){
            return null;
        }
        //把A中元素往B中倒腾
        while(A.size()>1){
            //判定A中只剩一个
            Integer font=A.poll();
            B.offer(font);
        }
        //循环结束A中只有1个元素
        //这个元素就是被出栈的元素
        int ret=A.poll();
        B.offer(ret);//pop 和peek唯一的区别
        //交换 AB
        swapAB();
        return ret;
    }
    public boolean empty(){
        return A.isEmpty();
    }
}