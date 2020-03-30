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
 * 重写 方法名相同 参数列表相同 返回值相同(返回值可以不同,但需要遵循协变类型->返回值之间构成继承关系)
 */
class Animal{
    public String name;

    public Animal(String name){
        this.name=name;
    }
    //该方法的访问修饰限定符 不能是private
    //访问修饰限定符不一定需要相同的 只要满足 子类的访问修饰限定符要大于父类的访问修饰限定符
    public void eat(){
        System.out.println("com.bit.sr2.Animal:"+this.name+"正在吃!");
    }
}
class Bird extends Animal{
    public Bird(String name){
        super(name);
    }
    public void fly(){
        System.out.println(this.name+"正在飞!");
    }
    public void eat(){
        System.out.println("com.bit.sr2.Bird"+this.name+"正在吃!");
    }
}
class Cat extends Animal{
    public Cat(String name){
        super(name);
    }
}
public class TestMain {
    //运行时绑定:动态绑定
    //反编译 javap -c
    public static void main(String[] args) {
        Animal animal=new Animal("将军");
        animal.eat();
    }


    public static void func1(Animal animal){
        animal.eat();
    }
    public Animal func2(){
        Bird bird=new Bird("小鸟");
        return bird;
    }
    public static void main3(String[] args){
        Bird bird=new Bird("鸟儿");
        func1(bird);
    }

    public static void main2(String[] args) {
        //父类引用 引用了子类对象=>向上转型
        //1.直接赋值
        //2.传参
        //3.返回值
        Animal animal=new Bird("多多");
        animal.eat();
        //animal.fly();//通过父类引用 只能引用父类自己的方法或者属性

    }
    public static void main1(String[] args) {
        Animal animal=new Animal("斯威");

    }
}
