/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo12
 * @Author: Fan yuxuan
 * Date: 2020/3/20 20:32
 * project name: 20200320
 * @Version:
 * @Description: 封装
 */
//方法不占内存 占用内存的是方法里面的变量 在栈上
//OOP语言的三大特征 继承 封装 多态 (OOP就是面向对象)
//类的调用者 类的实现者 封装的意义降低代码管理复杂程度
class Student{
    //private 私有的 如果一个成员变量被private所修饰,那么这个成员变量,只能在类内进行访问,不能被类的调用者使用
    //当成员变量被设置为私有的 那么需要提供一系列的get set方法来初始化成员变量
    private String name;
    private int age;
//setName和getName是接口,这些接口一般不容被修改
    //public void setName(String userName){

      //  name=userName;
    //}
    //public String getName(){

      //  return name;
    //}
    //public void setAge(int age){

        //age=age 相当于是自己给自己赋值 形参是局部变量 两个age冲突了
      //  this.age=age;
        //this.age是指private int age;
    //}
    //public int getAge() {

      //  return age;
    //}
    //alt+insert  Getter and Setter 快捷键 生成get和set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //this不代表当前对象
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


public class TestDemo12 {

    public static void main1(String[] args) {
        Student student=new Student();
        //不管Student类是age1还是age2,我们只关注setAge方法
        student.setAge(99);
        System.out.println(student.getAge());//99
        System.out.println("================");
        student.setName("caocao");
        System.out.println(student.getName());
    }
    public static void main(String[] args) {

        //构造方法被调用,只有在被new的时候调用
        //Student1 student=new Student1("fan yxuan",18);
        //一旦给定一个构造方法,那么原来编译器自动生成的构造方法就不存在了
        //如果有对不含参数的构造方法有需求就需要自己手动输入
        Student1 student2=new Student1();
        //System.out.println(student.getName());
        System.out.println(student2.getName());
    }
}

/**
 * Person p=new Person();
 * new是怎么执行的,分为几步
 * 1.为对象分配内存
 * 2.调用合适的构造方法,构造方法不止一个
 * 构造方法没有返回值
 *只有构造方法调用完成之后,对象才产生了
 * 但是你在构造方法里面使用了this 而你又说this代表当前对象,所以这句话冲突了
 *正确的应该是 this代表当前对象的引用
 *
 * 有关this的注意事项:
 * 1.代表当前对象的引用
 * 2在静态方法内部不能够使用this 静态是不依赖对象的
 * 3.a.this 通过点号可以访问普通的成员变量,
 *   b.this也可以在构造方法内调用另外一个构造方法 this必须放在第一行,只能在构造方法中使用
 *   c.this可以通过点号来访问普通成员方法
 *   不建议用this去访问静态的属性或者方法
 * 
 */
class Student1{
    private int age;
    private String name;
    //构造方法 对成员变量初始化的另一种方式
    //如果当前类没有提供构造方法,那么他会自动产生一个构造方法如下所示默认的不带参数的构造方法
    public Student1(){
        //输出函数验证是否被调用
        this("bit",18);//调用带有两个参数的构造方法
        System.out.println("Student1()");
    }
    //构造方法的作用是构造对象
    public Student1(String name,int age){
        this.name=name;
        this.age=age;
        //
        System.out.println("Student(String,int)");
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}
