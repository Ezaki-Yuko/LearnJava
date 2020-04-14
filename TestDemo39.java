/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo39
 * @Author: LENOVO
 * Date: 2020/4/12 16:18
 * project name: 20200412
 * @Version:
 * @Description:
 */
class Test extends Object{
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
public class TestDemo39 {
    public static void main(String[] args) {
        //这个语法是创建了一个匿名内部类
        //内部类指的是类的定义在某个类或者方法内部
        //匿名指的是没有创建类的名字,只知道这个类是Object的子类
        //{}里就是这个匿名内部类的实现代码
        Object o=new Object(){
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        };
        o.equals("aaa");
    }
}
