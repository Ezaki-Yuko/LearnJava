package com.bit.demo2;

/**
 * @PackgeName: com.bit.demo2
 * @ClassName: TestDemo22
 * @Author: LENOVO
 * Date: 2020/4/2 18:56
 * project name: 20200402
 * @Version:
 * @Description:
 */
class Shape{
    private int age;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void draw(){

    }
}
class Cycle extends Shape{
    @Override
    public void draw() {
        System.out.println("这是一个圆!");
    }
}
class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("这是一个矩形!");
    }
}
class Flower extends Shape{
    @Override
    public void draw() {
        System.out.println("这是一朵花");
    }
}

/**
 * 多态的优点(父类引用 引用子类对象)
 * 使用的成本降低了
 * 简化代码
 * 容易进行扩展
 */
public class TestDemo22 {
    //类的调用者
    public static void drawMap(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {
        Shape[] shapes={new Cycle(),new Rect(),new Flower()};
        for(Shape shape:shapes){
            shape.draw();
        }
    }
    public static void main1(String[] args) {
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
