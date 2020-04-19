import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo48
 * @Author: LENOVO
 * Date: 2020/4/14 21:08
 * project name: 20200414
 * @Version:
 * @Description:
 */
public class TestDemo48 {
    //双端队列Deque接口
    //队列和双端队列是可以起到限制灵活性的
    public static void main(String[] args) {
        Deque<Integer> deque=new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);
    }
}
