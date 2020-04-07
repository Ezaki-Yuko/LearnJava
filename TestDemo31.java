/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo31
 * @Author: LENOVO
 * Date: 2020/4/7 18:34
 * project name: 20200407
 * @Version:
 * @Description:
 */

import java.lang.reflect.Field;

/**
 *
 */
public class TestDemo31 {
    /**
     * Spring 家族 框架就是限制代码不要这么灵活 设计模式是软性限制
     * charset 字符集(字符的编码方式) GBK(Windows中文版默认) UTF-8(IDEA编码)
     * @param args
     */
    public static void main1(String[] args) {
        //创建出几个String 对象 标准库
        //java中不存在\0
        //引用类型
        //字符串常量,专门在一个"字符串常量池",字符串常量池在堆中
        //JVM的垃圾回收机制
        //==比较内置类型是不是值相等
        //引用类型的比较有两种风格:1.比较身份是否相同 2.比较值是否相同
        String str1="hehe";//存了一份 更推荐这个
        String str2=new String("hehe");//存了两份
        char[] buffer={'a','b','c'};
        String str3=new String(buffer);
        System.out.println(str3);
        //一个对象可能有很多引用指向 ==试比较对象的身份(对比两个引用中保存的地址是否一样)
        System.out.println(str1==str2);
        //比较内容使用equals方法
        System.out.println(str1.equals(str2));
        System.out.println("hehe".equals(str1));//这种写法更好.如果交换str1和hehe,如果str1是null就会发生空指针异常

    }
    /**
     *池:进程池 线程池 内存池 数据库连接池
     * 避免频繁申请内存
     */
    public static void main2(String[] args) {
        //字符串常量都在常量池存着
        String str1="hehe";
        String str2="hehe";
        String str3="hehe";
        String str4="hehe";
        //通过intern方法可以主动去池子中查找,看看String是否在池中存在
        //如果池中不存在,就把String加入到池中
        //如果已经存在,就可以舍弃当前对象,直接获取池中对象的引用,把new String引用的对象,被垃圾回收机制标记成垃圾,进一步回收掉
        //字符串常量是存在常量池中的
        String str5=new String("hehe").intern();
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str3==str4);
    }

    public static void main3(String[] args) {
        String str="hehe";
        str="haha";
        //字符串是不可变对象,对象的值不能修改
        //这个是修改了String引用中保存的地址,而不是修改字符串的值
        //String核心成员是value数组,字符串终究是由若干个字符构成的
        //String类中并没有提供一个public方法来修改value数组中的内容(不可变核心)
        //不可变的好处:1.比较方便实现"字符常量池"
        //2.不可变对象hash值固定
        //3.不可变对象是线程安全的
        //C++中的做法是允许string能修改,"写时拷贝"的机制
        //更严谨的说String不可变,只是在普通情况下这样的,还可以有一些特殊手段来修改String对象的值.
        //反射 来修改value数组中的内容("自省") 一个对象能在程序运行时认清自己的一些特性
        //反射是一种特殊手段 反射和封装背道而驰,不建议滥用
        System.out.println(str);
    }

    public static void main4(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str="hehe";

        //获取到String类对象 类对象中就包含这个类名字叫啥,类里都有那些成员,每个成员的类型和名字分别是啥,每个成员是private函数public的
        //java代码就是.java文件通过javac编译生成class二进制字节码文件(包含每个类具体实现内容).
        //运行java程序的时候,JVM读取.class文件内容,把其中的类,加载到内存中,并且使用一个对应的类对象
        //进行表示
        //需要先根据"value"这个名字找到str中内部存储的value数组
        //1.获取到String对象的图纸(进一步了解 String 里面的细节)
        Field field=String.class.getDeclaredField("value");
        field.setAccessible(true);
        //根据图纸找到str里面的value数组
        char[] value=(char[])field.get(str);
        //然后再修改数组内容即可
        value[0]='a';
        System.out.println(str);
    }
    /**
     * 字节和字符
     * 如果进行文本处理,就要按照字符来处理
     * 如果进行存储或者传输就按照字节来处理
     */
    public static void main5(String[] args) {
        char[] array={'h','e','h','e'};
        String str=new String(array);
        //charAt可以获取到某个下标对应的字符
        System.out.println(str.charAt(2));
        System.out.println(str);
        char[] array2=str.toCharArray();//这里是把字符串拷贝了一份,拷贝到一个新的字符数组中,如果字符串很大,拷贝开销就会很大
        for (int i = 0; i <array2.length ; i++) {
            System.out.println(array2[i]);
        }
        System.out.println("=========");
        for (int i = 0; i <str.length() ; i++) {//效率比上面高
            System.out.println(str.charAt(i));
        }
    }

    public static void main(String[] args) {
        String str="hehe";
        String str1="Hehe";
        System.out.println(str.equals(str1));
        System.out.println(str.equalsIgnoreCase(str1));//忽略大小写 true
        //compareTo 比较字符串大小写 "字典序"
        //如果str1<str2,返回<0的整数
        //>,返回大于0的整数
        //=,返回0
        //不能直接用<>来比较String
        System.out.println(str.compareTo(str1));//大于0,按照UNICODE码来比较
        //这里的比较只是对于英文比较才有意义,如果是中文习惯安装拼音顺序来排序,用compareTo是不行的,需要借助第三方库来完成
    }
}
