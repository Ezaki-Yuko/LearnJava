/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: Practice1
 * @Author: LENOVO
 * Date: 2020/3/19 21:04
 * project name: 20200319
 * @Version:
 * @Description:
 */
class A{
    public static int age1=1;
    public int age2=11;
    public void func1(){
        System.out.println("123");
    }
    public static void func2(){
        System.out.println("321");
    }
}
class B{
    public void func3(){
        A.age1=23;
        System.out.println("456");
    }
    public static void func4(){
        System.out.println("654");
    }
}

/**
 * 总结:同一个类中:
 * 非静态访问静态:类名.方法名
 * 非静态访问非静态 : 可以直接访问
 * 静态访问非静态 : 直接访问会报错 需要先实例化自己的类 然后通过变量名来访问
 * 静态访问静态 : 可以直接访问
 * 不同类中:
 * 非静态访问静态:类名.方法名
 * 非静态访问非静态:实例化一个对象去访问
 * 静态访问非静态:实例化一个对象去访问
 * 静态访问静态:类名.方法名
 */
public class Practice1 {
}
