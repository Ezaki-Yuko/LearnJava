/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork17
 * @Author: LENOVO
 * Date: 2020/4/1 18:28
 * project name: 20200401
 * @Version:
 * @Description:
 */
class Book{
    public String name="红楼梦";
    public String author="曹雪芹";
    public int price=66;
    //执行顺序:静态代码块->实例代码块/构造代码块->构造方法
    //静态:1.静态方法,2.静态属性 两者执行顺序在于定义前后顺序
    //实例:1.实例的数据成员2.实例的代码块 看定义的顺序
    //静态的先执行,但只会执行一次
    public Book(){
        System.out.println("不带参数的构造方法");
    }
    public Book(String name,String author,int price){
        this.name=name;
        this.author=author;
        this.price=price;
        System.out.println("带两个参数的构造方法");
    }
    {   this.name="三国";
        this.author="XXX";
        System.out.println("实例代码块/构造代码块");
        //一般不用实例代码块初始化对象,一般用get set和构造方法
        //初始化实例成员变量 非静态的成员变量 静态的也可以
    }
    static{
        //this是对象的引用 不能出现
        //在静态代码块当中,是不可以初始化普通成员变量的 原因static是不依赖于对象的
        //this.name="三国演义";
        System.out.println("静态代码块!");
        //初始化静态的成员变量
    }
}
public class HomeWork17 {
    //可变参数编程
    {
        System.out.println("主类里在前的普通代码块");
    }
    public static int sum(int... array){
        System.out.println("在前静态方法");
        return 1;
    }
    static{
        System.out.println("在前的静态代码块");
    }
    public static void main(String[] args) {
        System.out.println("主类:在new前");
        Book book=new Book("三国演义","罗贯中",33);
        System.out.println("主类在new后");
    }
    static{
        System.out.println("在后的静态代码块");
    }
    public static int sum2(int... array){
        System.out.println("在后的静态方法");
        return 1;
    }
    {
        System.out.println("在后的普通代码块");
    }
}
