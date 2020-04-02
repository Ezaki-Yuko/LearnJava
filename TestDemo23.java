package com.bit.demo3;

/**
 * @PackgeName: com.bit.demo3
 * @ClassName: TestDemo23
 * @Author: LENOVO
 * Date: 2020/4/2 19:27
 * project name: 20200402
 * @Version:
 * @Description:
 */

/**
 * 包含抽象方法的类叫做抽象类
 * 1.用关键字abstract进行修饰
 * 2.在抽象类中 可以有普通类的所有属性
 * 3.和普通类不同的是包含抽象方法
 * 4.方法是抽象的类一定是要被abstract修饰
 * 5.不能被实例化 new
 * 6.抽象类的主要作用就是用来被继承的
 * 7.抽象类就是用来被继承的 所以不能被final所修饰
 *   final abstract class shape
 * 8.抽象方法也不能是私有的或者是static的 (是会被重写的)
 *9.只要有一个类继承了抽象类 那么 必须要重写抽象类的方法
 * 10.如果这个类不想重写父类的抽象方法 可以在前面加abstract
 *
 * 抽象类和普通类的区别
 */
abstract class Shape{
    //可以用于普通类的数据成员 或者方法
    public void func1(){

    }
    public abstract void draw();//抽象方法:没有具体实现的方法 如果加{}会报错
}
abstract class B extends Shape{

}
class A extends Shape{
    @Override
    public void draw() {
    }
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一个圆!");
    }
}
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一个矩形!");
    }
}
class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一朵花");
    }
}

public class TestDemo23 {
    public static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        //抽象类也可以发生向上转型
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
