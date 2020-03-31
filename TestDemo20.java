package com.bit.sr2; /**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: com.bit.sr2.TestDemo20
 * @Author: Fan yuxuan
 * Date: 2020/3/30 18:30
 * project name: 20200330
 * @Version:
 * @Description: 继承
 */
/**
 * import java.util.Arrays 导入 util这个包 Arrays是类
 * import java.util.* 导入util这个包的所有类 用到谁找谁  不同的包可能有相同的类名 此时要给出明确的路径
 */
/**
 * public private 包访问 protected
 * java.lang系统常用基础类不用手动导入
 */
import com.bit.sr2.Animal;
import com.bit.sr2.Dog;

/**
 * 面向对象语言:java C++
 * OOP语言的三大特征 多态 封装 继承
 *
 * private关键字进行修饰属性或方法 不能在类外访问封装 代码的维护成本降低了 提供公有的接口就好了
 *
 * 继承 (组合用的不多) 代码的可重用性 为了代码的可重用性,继承extends protected
 * 把一些公共的属性 或者方法就可以放在父类/基类/超类
 * 注意事项:1.java当中只能继承一个类,不能继承多个类,只支持单继承
 * 2,父类的私有属性和方法不能在子类当中进行访问
 * 3.子类继承了父类除构造方法外的所有东西,私有方法是被继承的,只是无法访问
 *  子类继承了父类,子类当中会包含父类的属性
 * 4.子类如果要实例化,那么首先要实例化父类,如果子类要构造,那么首先要构造父类.
 *   在子类当中如何构造父类,构造对象要调用构造方法
 */
//TestDemo是非子类的不能用super 同一个包可以访问到 protected
public class TestDemo20 {
    public static void main(String[] args) {
        //同一个包下的不同的类 protected可以被访问
        Animal animal=new Animal("大黄");
        System.out.println(animal.sex);
    }

    public static void main2(String[] args) {
        Bird bird=new Bird("初一",10);
        bird.eat();
        bird.fly();
        bird.test();
    }
    public static void main1(String[] args) {
        Dog dog=new Dog("将军");

    }
}
