/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo42
 * @Author: LENOVO
 * Date: 2020/4/14 18:35
 * project name: 20200414
 * @Version:
 * @Description:
 */

/**
 * 栈和队列是基于顺序表和链表来实现的
 *
 * 顺序表和链表都可以支持增删改查各种操作
 * 栈和队列相当于对顺序表链表的功能进行了限制
 * 栈:1.入栈(把元素通过栈顶往下放) 2.出栈(把栈顶元素删除掉) 3.取栈顶元素(获取到最上面的元素) 后进先出
 * 队列:1.入队列(从队尾插入元素) 2.出队列(删除队首的元素)3.取队首元素(获取到队首位置的元素的值) 先进先出
 */
/**
 *队列的变种:
 * 1.普通的队列:先出先进的规则
 * 2.优先出队列:出队列的顺序和入队列的顺序不一样,每次出队列的元素都是优先级最高的元素(本质上是一个堆)
 * 3.消息队列:也不是严格的先进先出,而是按照"类型"来获取元素(业务类型)(实际工作中会用到很多的"消息队列服务器")
 * 4.阻塞队列:当队列为空的时候,出队列操作就会阻塞;当队列为满的时候,入队列操作就会阻塞(代码执行到某个地方就不往下走了,一直等待)
 * 无锁队列:线程安全的队列,不是通过锁来实现线程安全 比较高效 CAS操作来实现的
 */

/**
 * 软件开发过程中 自由程度越灵活往往就越不好
 * 越灵活往往越容易出错
 * 各种设计模式,也是用来限制代码的灵活程度
 */

/**
 * 双端队列:既可以头插头删,也可以尾插尾删.Deque接口
 */

/**
 * 栈和队列很多设计不太一样
 * 1.栈只提供一组操作,队列提供两组操作
 * 2.栈和队列基本操作方法命名规则不统一
 * 3.栈和队列中 判空操作和一般的List风格也不一致
 */
public class TestDemo42 {
    //基于一个顺序表/链表实现
    private int[] array=new int[100];
    //有效元素[0,size) 区间中的元素是栈中的有效元素
    //0号元素相当于栈底;size-1位置元素相当于栈顶
    private int size=0;

    public void push(int value){
        //把value放在数组末尾,此处没有考虑扩容的操作
        array[size]=value;
        size++;
    }
    public Integer pop(){
        if(size<=0){
            //此处可以有两种表示方式
            //可以返回非法值,也可以抛出异常
            return null;
        }
        int ret=array[size-1];
        size--;
        return ret;
    }
    public Integer peek(){
        if(size<=0){
            return null;
        }
        int ret=array[size-1];
        return ret;
    }

    public static void main(String[] args) {
        TestDemo42 testDemo42=new TestDemo42();
        testDemo42.push(1);
        testDemo42.push(2);
        testDemo42.push(3);
        testDemo42.push(4);
        testDemo42.push(5);

        Integer cur=null;
        while((cur=testDemo42.pop())!=null){
            System.out.println(cur);
        }
    }
}
