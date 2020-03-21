/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo13
 * @Author: LENOVO
 * Date: 2020/3/21 9:02
 * project name: 20200321
 * @Version:
 * @Description:
 */

import java.security.spec.RSAOtherPrimeInfo;

/**
 * 回顾: 类->>自定义 模板->>图纸
 * 类的组成:属性:定义在类内 但在方法外.姓名 姓名
 *          普通成员变量/实例成员变量
 *          静态成员变量
 *          常量 final 不可被更改
 * 方法 行为
 * 对象:实体 java实例化一个对象 new
 * 1.为对象分配内存
 * 2.调用合适的构造方法
 * 属性如果没有被初始化,那么他对应的值就是自己类型对应的0值
 * private 私有的 属于 访问修饰限定符 public private protected 默认
 * 特性 不能在类外进行访问
 * 封装:将一些属性,用private来修饰 目的:为了简化代码的管理程度
 *
 * 需要提供一系列get和set方法
 *
 * 属性:属于对象的 不是被static修饰的就属于对象,只要有一个对象 就有一份
 *      属于类的 被static修饰 可以通过类名来调用 不依赖于对象.存放在方法区,且只有一份
 *调用合适的构造方法: 作用:构造对象->实例化对象
 * 1.如果当前类没有提供任何构造方法 编译器会自动生成一个不带参数的构造方法
 * 2.一旦提供了构造方法,编译器默认生成的构造方法将不复存在
 *
 * 构造方法可以被重载2
 *关键字:this和static
 *  this 代表当前对象的引用
 * this.date
 * this();
 * this.func();
 * 构造方法和get set都可以通过快捷键 alt+insert来快速写出
 */
class Test {
    public int aMethod(){
        //static int i = 0;
        //不管是静态的方法 还是非静态的方法,内部都不可以定义static类型的变量 static类型的变量只能定义在类外 方法外 属性 属于类 只有一份
        //局部变量是方法栈上的
        int i=0;
        i++;
        return i;
    }
}
class Book{
    private String name="红楼梦";
    private String author="曹雪芹";
    private int price=66;
    //执行顺序:静态代码块->实例代码块/构造代码块->构造方法
    //就比如上面给私有赋初值,但是构造方法里修改 由于执行顺序 打印结果肯定是构造方法中的
    //静态:1.静态方法,2.静态属性 两者执行顺序在于定义前后顺序
    //实例:1.实例的数据成员2.实例的代码块 看定义的顺序
    //静态的先执行,但只会执行一次

    public Book(){
        System.out.println("Book()");
    }
    public Book(String name,String author,int price){
        this.name=name;
        this.author=author;
        this.price=price;
        System.out.println("Book(String,String,int)");
    }

    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

    {   this.name="三国";
        this.author="XXX";
        System.out.println("实例代码块/构造代码块");
        //一般不用实例代码块初始化对象,一般用get set和构造方法
        //初始化实例成员变量 非静态的成员变量 静态的也可以
    }
    static{
        //在静态代码块当中,是不可以初始化普通成员变量的 原因static是不依赖于对象的
        //this.name="三国演义";
        System.out.println("静态代码块!");
        //初始化静态的成员变量
    }
    //如果要打印类型的属性 可以直接重写toString alt+insert toString
    @Override//注解 @Override 重载 打印所有的属性
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
    //重载:函数名相同 参数列表不同(个数,类型) 返回值不做要求
    //重写:函数名相同 参数列表相同 返回值也相同
}
public class TestDemo13 {
    //可变参数编程
    public  static  int sum(int... array){
        int ret=0;
        for (int x:array) {
            ret+=x;
        }
        return ret;
    }

    public static void main4(String[] args) {
        int[] array={1,2,3,4,5};
        sum(array);
        //匿名数组
        //func(new int[]{1,2,3,4,5})
        System.out.println(sum(1,2,3,4,5));
    }

    public static void main(String[] args) {
        Book book=new Book("三国演义","罗贯中",33);
        //打印book是当前对象的地址 哈希值 Book@16d3585 类型 地址的哈希值
        //Object是所有类的父类
        //System.out.println(book.getName());
        //打印所有的属性
        System.out.println(book.toString());
        //匿名对象 一个对象只能用用一次
        new Book().getAuthor();

    }

    public static void main2(String[] args) {
        Book book=new Book();
    }
    private static int x = 100;// 2
    //静态的不依赖于对象
    public static void main1(String args[]) {// 3
        TestDemo13 hsl = new TestDemo13();// 4
        hsl.x++;// 5
        //可以编译通过 只是会报警告 x是属于类的
        TestDemo13 hs2 = new TestDemo13();// 6
        hs2.x++;// 7
        hsl = new TestDemo13();// 8
        hsl.x++;// 9
        TestDemo13.x--;// 10
        System.out.println(" x=" + x);// 11
    }
}

/**
 * 复杂度:衡量一个算法的项目
 * 时间复杂度:执行这个算法浪费的时间 的表示需要用大O渐进法表示.大概的
 * N^2+2N+10->>只保留最高阶项,且系数不保留 常数项去掉 (常数项会变成1)
 * 二分查找的时间复杂度n/2^k=1 k是次数 k=log以2为底的n
 * 斐波那契数列 2^n-1 O(2^n)满二叉树
 * N^2
 * 空间复杂度:执行这个算法依赖的空间
 * 空间复杂度是对一个算法在运行过程中临时占用存储空间大小的量度 。
 * 空间复杂度算的是变量的个数。空间复杂度也使用大O渐进表示法
 * 递归开辟节点保存数据 递归多少次 就是多余的空间
 */
