/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork16
 * @Author: LENOVO
 * Date: 2020/4/1 18:19
 * project name: 20200401
 * @Version:
 * @Description:
 */
public class HomeWork16 {
    static{
        System.out.println("静态代码块前");
    }
    {
        System.out.println("普通代码块前");
    }
    public static void main(String[] args) {
        System.out.println("主函数new前");
        HomeWork16 test=new HomeWork16();
        System.out.println("主函数new后");
        //test.aMethod();
        //int j=test.aMethod();
        System.out.println();
    }
    static{
        System.out.println("静态代码块后");
    }
    {
        System.out.println("普通代码块后");
    }
}
