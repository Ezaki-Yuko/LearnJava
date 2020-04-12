/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo35
 * @Author: LENOVO
 * Date: 2020/4/11 11:06
 * project name: 20200411
 * @Version:
 * @Description:
 */

/**
 * List接口继承自 Collection接口.Collection中支持的内容List也支持
 * 泛型编程就是一份代码针对不同的数据类型进行操作
 */
class Student{
    public String name;
    public String sex;
}
public class TestDemo35 {
    private Object[] array;//Object表示不同的类
    private int size;
    public TestDemo35(){
        this.array=new Object[4];
        this.size=0;
    }
    public void add(Object o) {
        this.array[size]=o;
        this.size+=1;
    }
    Object get(int index){
        return array[index];
    }

    public static void main(String[] args) {
        TestDemo35 testDemo35=new TestDemo35();
        testDemo35.add("我");
        testDemo35.add("爱");
        testDemo35.add("java");
        //如果不用泛型的话,使用Object也可以一定程度上让一个diamante同时作用于不同的类型上
        //这么做不太方便,需要进行很多的类型转换,万一手动类型转换出错,可能会出现异常
        String ret=(String)testDemo35.get(0);
        System.out.println(ret);

        TestDemo35 testDemo351=new TestDemo35();
        testDemo351.add(new Student());
        testDemo351.add(new Student());
        testDemo351.add(new Student());
        //类型转换失败
        //String ret2=(String)testDemo351.get(0);
    }
}
