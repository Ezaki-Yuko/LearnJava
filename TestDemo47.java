/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo47
 * @Author: LENOVO
 * Date: 2020/4/14 21:03
 * project name: 20200414
 * @Version:
 * @Description:
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 标准库中的队列是一个接口
 */
public class TestDemo47 {
    //只能实例化一个实现Queue接口的类
    //标准库中的队列是基于链表实现的
    public static void main(String[] args) {


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        while(!queue.isEmpty()){
            Integer cur=queue.poll();//元素为空返回null
            //Integer cur=queue.remove();//元素为空抛出异常
            System.out.println(cur);
        }
    }
}