package com.bit.Demo4;

/**
 * @PackgeName: com.bit
 * @ClassName: TestDemo24
 * @Author: LENOVO
 * Date: 2020/4/2 20:01
 * project name: 20200402
 * @Version:
 * @Description:
 */

/**
 * 接口注意事项
 * 1.interface关键字修饰
 * 2.里面的数据成员必须是一个常量
 *   默认是public static final
 * 3.里面的成员方法是默认为 public abstract
 * 4.在接口当中不能定义一个已经实现的方法
 * 5.接口当中可以有实现的方法 被default修饰
 * 6.接口也是不可以被实例化的
 * 7.接口也可以有多个抽象方法
 *
 * 一个类和接口的关系是实现 一个类可以实现多个接口 解决了单继承的问题
 * 一定不能省略类里面的public 接口是默认的 类里面不加就是包访问权限了
 * 实现了该接口 一定要实现接口的方法
 */
interface Shape{
    int a=10;
    void draw();//不能有实现方法
    default void func(){

    }
}
class Cycle implements Shape {
    @Override
    public void draw() {
        System.out.println("这是一个圆!");
    }
}
interface A{

}
class Rect implements Shape,A {
    @Override
    public void draw() {
        System.out.println("这是一个矩形!");
    }
}
class Flower implements Shape {
    @Override
    public void draw() {
        System.out.println("这是一朵花");
    }
}
public class TestDemo24 {
    public static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        //接口也可以发生向上转型
        Shape shape1=new Cycle();
        //shape1.draw();
        Shape shape2=new Rect();
        //shape2.draw();
        Shape shape3=new Flower();
        drawMap(shape1);
        drawMap(shape2);
        drawMap(shape3);
    }
}
