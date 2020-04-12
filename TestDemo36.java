/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo36
 * @Author: LENOVO
 * Date: 2020/4/11 15:53
 * project name: 20200411
 * @Version:
 * @Description:
 */
class Student1{
    public String name;
    public String sex;
}
//实际工作中很少写泛型类
//E是泛型参数,代表一种类型
//泛型是java给我们提供的更方便使用的语法,主要功能是在编译过程中自动帮我们进行相关的类型转换
//这是编译过程中涉及到的问题,编译生成的字节码中已经不存在泛型
public class TestDemo36<E> {
    private E[] array;//Object表示不同的类
    private int size;
    public TestDemo36(){
        //E是形参 new E编译器就不知道怎么处理 需要手动处理
        //this.array=new E[4];
        this.array=(E[])new Object[4];
        //强转成E[]就可以了
        this.size=0;
    }
    public void add(E o) {
        this.array[size]=o;
        this.size+=1;
    }
    E get(int index){
        return array[index];
    }

    public static void main(String[] args) {
        //把参数手动设置进去
       TestDemo36<String> testDemo36=new TestDemo36<>();
       testDemo36.add("hehe");
       //不需要转换直接就是String
       String s=testDemo36.get(0);

       TestDemo36<Student> testDemo361=new TestDemo36<>();
       testDemo361.add(new Student());
       Student student=testDemo361.get(0);
    }
}