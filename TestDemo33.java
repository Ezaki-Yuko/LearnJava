/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo33
 * @Author: LENOVO
 * Date: 2020/4/11 9:07
 * project name: 20200411
 * @Version:
 * @Description:
 */
/**
 * 数据结构是把很多数据按照一定方式,组织在一起,方便进行增删查改
 * 顺序表 链表 栈 队列 优先级队列(堆) 树 二叉树(二叉搜索树 AVL树 红黑树) 哈希表 图 排序法
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 集合框架 容器 集合类 在java.util包下已经创建好了
 * 一个集合类对象,内部可以包含许多元素
 * 通常也会提供一些增删查改接口
 * Iterable接口 可迭代的 逐步的逼近目标值 可以使用迭代器/for each进行遍历
 *Collection 这个接口提供一些基本的增删查改
 * List线性表(顺序表和链表) Vector ArrayList顺序表 Queue 队列 Set 集合(元素不能重复 之间没有顺序要求)
 * List:[1,2,3,4] List:[2,1,3,4]不相等 Set[1,2,3] Set[3,2,1]相等 [1,2,1,3]不能存在
 * TreeSet底层是二叉搜索树 HashSet底层是哈希表
 * Map 映射表 体现"键值对"key value这样的关系 key不能重复 TreeMap底层二叉搜索树 HashMap哈希表
 */
public class TestDemo33 {
    public static void main(String[] args) {
        //Collection是接口,add remove contains 这些方法都是抽象方法
        //这些方法在执行时,具体行为取决于collection对于真实对象的类型
        //1.实例化一个Collection对象 Collection是一个接口,必须要new一个实现Collection的类作为实例才可以
        //集合类具体内部保存的类型由调用者决定 调用者可以通过泛型参数来指定集合类中存储什么样的元素
        //泛型编程,写一份编码,能够同时适应不同的数据类型
        //<>泛型参数
        Collection<String> collection =new ArrayList<>();
        //等号右边可以写成new ArrayList<String>();/new ArrayList();
        //2.使用size/isEmpty
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        //3.使用add添加元素
        collection.add("我");
        collection.add("爱");
        collection.add("java");

        //4.再次使用isEmpty和size
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());

        //5.toArray 集合转换成数组
        // String 也是继承自Object
        Object[]array=collection.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(collection);

        //6.for each 遍历collection
        //比较简单的遍历方式 如果想用while或者普通for,需要搭配迭代器来使用
        for (String s:collection) {
            System.out.println(s);
        }

        //7.判断元素是否存在,contains 内部会拿参数的对象和集合中保存的对象按值比较(而不是按身份)
        boolean ret=collection.contains("我");
        System.out.println(ret);

        //8.删除指定元素
        collection.remove("爱");
        for (String s:collection) {
            System.out.println(s);
        }

        //9.使用clear来清空元素
        collection.clear();
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
    }
}
