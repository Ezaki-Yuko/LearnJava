/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo58
 * @Author: LENOVO
 * Date: 2020/5/3 20:05
 * project name: 20200428
 * @Version:
 * @Description:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 关于collection接口
 */
public class TestDemo58 {
    public static void main(String[] args) {
        //创建Collection
        Collection<String> collection=new ArrayList<>();
        //new ArrayList<>中的String可有可无
        //这行代码进行了向上转型 实际new的对象是ArrayList,使用Collection类型的引用来保存了这个对象
        //应用到了"泛型"语法 写一个类/方法 让这个类和方法可以支持不同类型的数据
        //泛型参数必须是引用类型
        //使用size方法 返回集合中的元素个数
        System.out.println(collection.size());
        /**
         * 关于length和size 数组元素个数:length不带括号 字符串获取字符个数 length()带括号 集合获取元素格式 size()
         */
        //3.isEmpty 判空
        System.out.println(collection.isEmpty());
        //4.使用add方法插入元素
        collection.add("我");
        collection.add("爱");
        collection.add("java");
        //再次使用isEmpty size
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        //6.使用toArray把collection转换成数组
        //得到的结果是Object[] 任何一个引用类型都继承了Object
        Object[] array=collection.toArray();
        System.out.println(Arrays.toString(array));
        //7.直接使用for循环遍历
        //这个foreach是比较简单的写法 想使用普通的for循环要借助迭代器
        //迭代器是一种专门用来遍历集合类的对象 迭代器(Iterator)可以应用到实现Iterable接口的类中
        for (String s:collection) {
            //s分别指向collection中的每一个元素
            System.out.print(s+" ");
        }
        //使用contains方法判定元素是否存在
        //比较的是对象的值(按照equals方法去比较)
        System.out.println();
        System.out.println(collection.contains("我"));
        //9.删除 remove 删除
        collection.remove("我");
        for (String s:collection) {
            System.out.print(s+" ");
        }
        //10.使用clear来清空元素
        collection.clear();
        System.out.println();
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
    }
}
