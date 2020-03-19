/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo11
 * @Author: Fan yuxuan
 * Date: 2020/3/19 18:29
 * project name: 20200319
 * @Version:
 * @Description: 类和对象
 */

/**
 * class 定义一种类型->>自定义类型
 * class 类名{
 *     类名:大驼峰
 * }
 * 属性+行为构成类
 * 类去实例化对象
 *
 * 类的成员:1.字段 属性 成员变量
 * 2.方法
 * 3.类()
 * 4.
 */
//声明一个类 Person 类->>对象(实体) 实例化一个对象
class Person{//类是一种引用类型
    //name和age是属性 在类里面定义的 成员变量 public是访问修饰限定符(private protected 默认访问权限 public)
    //public String name="123";不建议写死 一个类是可以创建多个对象的
    public String name;//属性 字段 成员变量
    public int age;
    public static int count;//静态成员属性 静态变量 不属于对象 属于对象的才可以用变量名访问
    //count只有一份 只能用类名访问 存在内存的方法区中 有且只有一份

    public final int SIZE=10;//常量->>不能被修改的
    public static final int SIZE2=100;//常量
    //一个属性它存放在哪个区域,和是否被final所修饰无关 是属于对象的 对象在堆上
    //被static修饰就只有一份 放在方法区

    //属性会放在对象的内存上
    //行为->成员方法不会占用内存的
    public void eat(){
        System.out.println("吃饭!");
    }
    public void sleep(){
        System.out.println("睡觉!");
    }
    public void show(){

        System.out.println("姓名:"+name+" 年龄:"+age);
    }
    public static void aa(){

        System.out.println("aa");
    }
    public static void func(){
        //静态的成员方法内是不可以访问非静态数据成员的
        //原因:静态的方法不依赖对象
        Person person=new Person();
        person.eat();
        person.show();
        count++;
        aa();
        System.out.println("static::func()"+SIZE2);//无论静态的属性还是方法都是不依赖与对象的 都需要通过类名来调用
    }
}
public class TestDemo11 {
    /**
     * java是面向对象的语言 C++也是
     * 抽象
     * 类:模板  模子 图纸
     * 对象:实体  月饼 房子 一个图纸->>无数个房子 一个类->>无数个类(表现形式在代码中)
     */

    public static void main1(String[] args) {
        //int a=10;//在方法里面定义是局部变量
        Person person1=new Person();//通过new关键字 实例化一个对象
        //类名 变量名=new 类名();  只要new的都要在堆上开辟内存 person在栈上 存放new Person()开辟内存的地址
        //通过当前对象的引用来访问,一个点号 引用方法/属性
        //注意:成员变量如果没有赋予初始值 ,那么他的值就是一个默认值 对应类型的0值 引用类型:null int型:0 0.0 0.0f false '\u0000'
        //System.out.println(person1.age);
        person1.name="张三";
        person1.age=99;
        System.out.println(person1.name);
        //空指针的长度会报错
        System.out.println(person1.age);
        person1.eat();
        person1.sleep();


        //person1和person2都在栈上开辟内存 存储对应new开辟在堆上的地址  每个对象都有name和age属性占用内存
        Person person2=new Person();
        person2.name="李四";
        person2.age=9;
        //System.out.println(person2.name);
        //System.out.println(person2.age);
        //person1.eat();
        //person1.sleep();
        person2.show();
        //警告不是错误 不影响程序的执行
        //静态成员属性要用类名来调用

        System.out.println(Person.count);

    }
    //public static void func(){
    //    System.out.println(" ");
    //}
    //public static void main(String[] args) {
    //    func();
    //}
    public  void func1(){
        System.out.println("1");
    }
    public static void  main(String[] args) {
        TestDemo11 test=new TestDemo11();
        test.func1();
    }
    public static void  func3() {
        TestDemo11 test=new TestDemo11();
        test.func1();
    }
}
