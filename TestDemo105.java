/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo105
 * @Author: LENOVO
 * Date: 2020/6/3 19:59
 * project name: 20200603
 * @Version:
 * @Description:
 */
/**
 * 上界下界通配符就是为了编译器做更多的校验
 * 泛型
 * 类型参数列表可以多有个
 * 泛型参数可以让内部类去使用
 * extends 类型边界 传进来的必须是边界的相同类型/子类 如果没有就默认是object的子类
 * ? extends上界 和上届相同或上界的子类
 * ? super 下界 和下届相同或下界的父类
 * 无法实例化泛型类型的对象
 * 泛型类型不是形参的一部分无法重载
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Map/Set
 * 1.Map和Set标准库中TreeSet TreeMap,HashSet,HashMap
 * 2.二叉搜索树 对应到TreeSet TreeMap底层实现
 * 3.哈希表 HashMap HashSet的底层实现
 *
 * 搜索 纯K K-V contains方法就是按照Key来查找,此处的key就是元素本身
 * Map 的get方法就是K-V
 * Map.Entry就是键值对 一个条目对象
 * get(key)失败返回null
 *
 */
public class TestDemo105 {
    public static void main(String[] args) {
        //1.实例化一个Set Set是接口
        Set<String> set=new HashSet<>();
        //2.往set中插入元素
        set.add("hello");
        set.add("world");
        set.add("java");
        //3.判断某个值是否存在
        System.out.println(set.contains("world"));
        //执行效率与背后的结构相关
        //4.删除
        set.remove("world");
        System.out.println(set.contains("world"));
        //5.遍历打印set
        //自己实现了toString
        System.out.println(set);
        //循环遍历set中的元素 使用迭代器
        //迭代器的泛型参数要和集合类中保存的元素参数保持一致
        //集合类内部自己实现自己版本的迭代器类
        //不同的集合类内部的迭代器类型不同,迭代器的实现细节也不同 迭代方式也不同
        //Map的迭代器放Entry就好
        Iterator<String> iterator = set.iterator();
        //Scanner写过类似的代码
        //Map和Set的元素组织顺序与插入顺序没有关系
        //对任意的集合类都可以
        //foreach的底层也是依靠迭代器来实现的
        //iterable接口 就提供一个方法,这个方法返回一个迭代器对象
        while(iterator.hasNext()){
            String next=iterator.next();
            System.out.println(next);
        }
    }
}
