package com.bit.demo2;

/**
 * @PackgeName: com.bit.demo2
 * @ClassName: TestDemo28
 * @Author: LENOVO
 * Date: 2020/4/4 9:15
 * project name: 20200404
 * @Version:
 * @Description:
 */

/**
 * 浅拷贝:两个引用都指向了这个对象
 * 深拷贝:数组内存放简单类型,通过遍历第一个数组拷贝到第二个数组是不会影响的 array1[0],不影响array[0]
 */

import java.util.Arrays;

/**
 * 解决的问题:自定义类型需要能拷贝 实现接口
 * Cloneable接口实现克隆对象->
 * Cloneable接口是一个空接口->标志接口->如果一个类实现了cloneable接口代表这个类可以被clone
 * 重写object的克隆方法
 */
class Money implements Cloneable{
    public int money=19;
    //对象也要克隆一份 并且调用克隆方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
class Person implements Cloneable{
    public int age;

    public Money m;
    public Person(int age) {
        this.age = age;
        m=new Money();
    }

    //@Override
    //protected Object clone() throws CloneNotSupportedException {
    //    return super.clone();
    //}
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person1=(Person)super.clone();//克隆一份person
        person1.m=(Money)this.m.clone();//拷贝money 再赋值给新的
        return person1;
    }
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +" money"+m+
                '}';
    }
}
public class TestDemo28 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(10);
        Person person1 = (Person) person.clone();
        System.out.println(person.m.money);
        System.out.println(person1.m.money);
        System.out.println("=========通过person1修改money========");
        person1.m.money=9999;
        System.out.println(person.m.money);
        System.out.println(person1.m.money);
    }

    //两种方法捕获异常
    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person(10);
        //克隆方法的返回值是object 需要强转
        Person person1 = (Person) person.clone();

        System.out.println(person.age);
        System.out.println(person1.age);
        System.out.println("=========通过person1修改age========");
        person1.age=999;
        System.out.println(person.age);
        System.out.println(person1.age);
    }
}
