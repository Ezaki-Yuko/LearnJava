package com.bit.sr2;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: com.bit.sr2.Dog
 * @Author: LENOVO
 * Date: 2020/3/30 18:46
 * project name: 20200330
 * @Version:
 * @Description:
 */
//如果一个类 不想被继承 那么需要 在这个类的前面加一个关键字 final
//final修饰的类叫做密封类 表示当前类不能被继承
//final修饰变量->常量 当前类不能被继承
//final修饰方法是密封方法
//子类(派生类)extends父类(基类\派生类)
//继承 is a 的关系
//组合 has a的关系
class Money{

}
class Person{
    public Money money;//组合
}
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    /**public String name;
     *  public void eat(){
     *  System.out.println(this.name+"正在吃!");
     *   }
     */
}
