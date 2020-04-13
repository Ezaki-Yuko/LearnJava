/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo37
 * @Author: LENOVO
 * Date: 2020/4/11 16:13
 * project name: 20200411
 * @Version:
 * @Description:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 包装类
 * 用一类把内置类型包裹进去 就变成引用类型了
 * 包装类提供了一些相关的操作方法
 * 更常用的是把包装类和内置类型进行相互转换
 * 装箱:基本类型=>包装类
 * 拆箱:包装类=>基本类型
 */
public class TestDemo37 {
    public static void main(String[] args) {
        //int是内置类型 不是继承Object
        //泛型是编译器自动帮我们转成Object
        //List<Integer> list=new ArrayList<>();
        //1.内置类型转成包装类 装箱 两种做法
        //Integer i=Integer.valueOf(10);//静态方法 返回一个Integer类型的对象
        //Integer i2=new Integer(10);
        //2.拆箱 包装类=>内置类
        //int j=i.intValue();
        //直接相互赋值
        Integer i=10;//自动装箱
        int j=i;//自动拆箱

    }
}
