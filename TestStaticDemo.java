/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestStaticDemo
 * @Author: LENOVO
 * Date: 2020/3/19 19:51
 * project name: 20200319
 * @Version:
 * @Description:
 */
class Test{
    public int a;//普通成员变量
    public static int count;//静态成员变量
}
public class TestStaticDemo {
    public static void main(String[] args) {
        Test t1 = new Test();
        t1.a++;
        Test.count++;
        System.out.println(t1.a);//1
        System.out.println(Test.count);//1
        System.out.println("============");
        Test t2 = new Test();
        t2.a++;
        Test.count++;
        System.out.println(t2.a);//1
        System.out.println(Test.count);//2
    }
}
