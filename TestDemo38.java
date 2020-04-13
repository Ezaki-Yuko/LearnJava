import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo38
 * @Author: LENOVO
 * Date: 2020/4/11 16:31
 * project name: 20200411
 * @Version:
 * @Description:
 */
public class TestDemo38 {
    public static void main(String[] args) {
        //1.实例化一个接口
        List<String> list=new ArrayList<>();
        //2.新增元素
        list.add("C语言");
        list.add("C++");
        list.add("Java");
        list.add("Python");
        list.add("PHP");
        //3.打印整个list
        System.out.println(list);
        //4.使用下标访问
        //[注意] 如果当前是ArrayList ,get/set按下标访问的方式,是比较高效的(时间复杂度是O(1))
        //如果当前List是LinkedList,get/set按下标访问比较低效,时间复杂度是O(N),链表更擅长插入
        System.out.println(list.get(0));
        list.set(0,"Go");
        System.out.println(list);
        //5.截取部分内容包含1 不包含3
        System.out.println(list.subList(1,3));
        //6.重新构造一个List 这里的构造是浅拷贝
        List<String> arrayList=new ArrayList<>(list);
        List<String> LinkedList=new LinkedList<>(list);
        System.out.println(arrayList);
        System.out.println(LinkedList);
        //7.基于现有List的引用进行强制转换(向下转型)
        ArrayList<String> arrayList1=(ArrayList<String>) list;
        //不能强转成链表
        LinkedList<String> LinkedList1=(LinkedList<String>) list;
    }
}

/**
 *ArrayList和LinkedList区别
 * 1.ArrayList底层结构是顺序表(基于数组);LinkedList链表
 * 2.ArrayList数据存放在连续的内存空间上.LinkedList不是存放在连续的内存空间上的
 * 3.ArrayList能够高效的进行"随机访问",按照下标操作元素的时间复杂度是O(1)
 * 由于内存具有随机访问能力,那么CPU访问不同的地址差异不大,成本不大,内存能够随机访问,数组才能随机访问,ArrayList基于数组的结构才能随机访问
 * 4.LinkedList能够高效的进行插入删除O(1) 注意 由于LinkedList的指定位置插入add方法也是通过下标来确定位置,取下标操作仍然是O(N)
 * 对于add(index,elem)如果是ArrayList,取下标过程是O(1),插入过程是O(N)
 * 如果是LinkedList,取下标过程是O(N),插入过程是O(1)
 * 5.ArrayList在初始化的时候可以通过capacity参数指定最大容量,当add尾插的时候,如果元素个数小于capacity,效率都很高O(1).
 * 如果达到capacity,此时就会触发扩容操作(一般重新new一个更大的(1.5倍)连续内存空间,把原来的元素搬运过来,再释放旧空间)
 * LinkedList就没有capacity这个概念,每次新插入一个元素,就去new一个特定的节点对象(如果ArrayList没有达到扩容时,插入效率可能会比LinkedList高)
 * 在频繁内存申请和释放的时候就容易产生操作系统的内存碎片,很难找到一块足够大的连续内存空间
 * 6.ArrayList比较害怕内存碎片,LinkedList则不害怕
 * 解决内存碎片:JVM 释放内存=>复制算法,比较消耗
 */
/**
 *ArrayList和Vector的区别 都是顺序表
 * 1.Vector是一个老版本的顺序表 ArrayList是新版本的顺序表
 * 2.Vector是线程安全的(效率比线程不安全版本低).ArrayList是线程安全的,不加锁的
 * 3.现在不太推荐使用Vector.更建议使用JUC中的组件,优化的更好,性能更高
 */