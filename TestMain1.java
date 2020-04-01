package com.bit.src3;

/**
 * @PackgeName: com.bit.src3
 * @ClassName: TestMain
 * @Author: LENOVO
 * Date: 2020/3/30 20:05
 * project name: 20200330
 * @Version:
 * @Description:
 */

/**
 * 重载 Overload
 *重写：子类的方法覆盖父类的方法，要求方法名和参数都相同；
 *重载：在同一个类中的两个或两个以上的方法，拥有相同的方法名，但是参数却不相同，方法体也不相同
 *
 * 重写 Override方法名相同 参数列表相同 返回值相同(返回值可以不同,但需要遵循协变类型->返回值之间构成继承关系)
 * 重写是在继承关系上
 */
class Animal{
    public String name;

    public Animal(String name){
        this.name=name;
        eat();
    }
    //重写的该方法的访问修饰限定符 不能是private
    //访问修饰限定符不一定需要相同的 只要满足 子类的访问修饰限定符要大于父类的访问修饰限定符
    public void eat(){
        System.out.println("Animal:"+this.name+"正在吃!");
    }
}
class Bird extends Animal{
    public Bird(String name){
        super(name);
    }
    public void fly(){
        System.out.println(this.name+"正在飞!");
    }
    @Override
    /**
     * 静态的方法不能被重写
     */
    public void eat(){
        System.out.println("Bird"+this.name+"正在吃!");
    }
}
class Cat extends Animal{
    public Cat(String name){
        super(name);
    }
}

/**
 *
 */
public class TestMain1 {
    /**
     * 构造函数当中是否可以发生重写 动态绑定---多态 可以发生重写
     * 父类引用引用子类对象 子类和父类有同名的覆盖方法,通过父类的引用,调用该重写方法,就会发生运行时绑定就是多态
     * @param args
     */
    public static void main(String[] args) {
        Animal animal=new Animal("将军");
        System.out.println();
        Animal bird=new Bird("将军2");


    }

    //向下转型不安全示例
    public static void main6(String[] args) {
        Animal animal=new Cat("咪咪");
        //此时animal并不是Bird的一个实例
        //报异常java.lang.ClassCastException 没有发生过向上转型
        //要发生向下转型那么必须发生过同种类型的向上转型
        //判断animal是不是Bird的实例
        if(animal instanceof Bird){
            Bird bird=(Bird)animal;
            bird.fly();
        }
    }
    //向下转型
    public static void main5(String[] args) {
        Animal animal=new Bird("将军");
        animal.eat();

        Bird bird=(Bird)animal;//向下转型
        //注意:1.不安全


        bird.fly();
    }

    public static void func3(){

    }
    //先编译再运行
    //运行时绑定:动态绑定
    //前提:1.发生向上转型 父类引用子类对象
    //2.子类和父类有同名的覆盖方法 重写方法  重写也叫覆盖
    //3.通过父类的引用调用该重写的方法,此时就会发生动态绑定
    //反编译命令 javap -c
    //new new对象
    //invokespecial 构造方法
    //invokevirtual 调用非静态方法(虚函数) 编译的时候确实调用的是父类的方法
    //incokestatic 调用非静态方法
    public static void main4(String[] args) {
        Animal animal = new Bird("将军");
        //调用父类的eat 但是结果是bird重写的eat方法
        animal.eat();
        func3();
    }
    //返回值
    public Animal func2(){
        Bird bird=new Bird("小鸟");
        return bird;
    }
    //传参
    public static void func1(Animal animal){
        animal.eat();
    }
    //传参
    public static void main3(String[] args){
        Bird bird=new Bird("鸟儿");
        func1(bird);
    }

    public static void main2(String[] args) {
        //父类引用 引用了子类对象=>向上转型
        //向上转型发生的情况
        //1.直接赋值
        //2.传参
        //3.返回值
        //直接赋值
        Animal animal=new Bird("多多");//子类赋值给了父类
        animal.eat();
        //animal.fly();//通过父类引用 只能引用父类自己的方法或者属性 Bird的方法不可以

    }
    public static void main1(String[] args) {
        Animal animal=new Animal("斯威");
        Bird bird =new Bird("初一");
        Cat cat=new Cat("咪咪");
    }
}
