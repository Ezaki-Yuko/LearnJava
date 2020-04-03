package com.bit.demo5;

/**
 * @PackgeName: demo5
 * @ClassName: TestDemo25
 * @Author: LENOVO
 * Date: 2020/4/2 20:21
 * project name: 20200402
 * @Version:
 * @Description:
 */

/**
 * 接口的好处 将功能独立
 * 顺序不要反 继承一个类 实现一个接口
 * 继承is a 接口是具有XX特性
 */

/**
 * 接口将功能独立
 * 接口不能够被接口实现
 * 接口和接口之间可以通过extends进行联系
 * 一个接口可以extends多个接口
 * 抽象类和接口的区别
 */
interface A{
    void func1();
}
//接口B在A的功能上扩展
interface B extends A{
    void func2();
}
interface C extends B{
    void func3();
}
//要重写三个方法
class AA implements C{
    @Override
    public void func1() {

    }

    @Override
    public void func2() {

    }

    @Override
    public void func3() {

    }
}
class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;
    }
}
interface IFlying {
    void fly();
}
interface IRunning {
    void run();
}
interface ISwimming {
    void swim();
}
//一个类可以继承一个类 实现多个接口
class Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name + "正在用四条腿跑");
    }
}
class Frog extends Animal implements IRunning, ISwimming {
    public Frog(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name + "正在往前跳");
    }
    @Override
    public void swim() {
        System.out.println(this.name + "正在蹬腿游泳");
    }
}
public class TestDemo25 {
    public static void walk(IRunning iRunning){
        iRunning.run();
    }
    public static void main(String[] args){
        Cat cat=new Cat("小花");
        walk(cat);
        Frog frog=new Frog("小蛙");
        walk(frog);
    }
}
