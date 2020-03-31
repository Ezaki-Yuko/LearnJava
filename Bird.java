package com.bit.sr2;

import com.bit.sr2.Animal;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: com.bit.sr2.Bird
 * @Author: LENOVO
 * Date: 2020/3/30 19:01
 * project name: 20200330
 * @Version:
 * @Description:
 */
public class Bird extends Animal {

    public Bird() {//构造子类要先构造父类
        //构造父类
        //子类并没有继承父 类的构造方法,只是在子类当中 进行了显示的调用 通过super
        super("多多");//代表调用父类的带有一个参数的构造方法 只能调用一次 只能放在第一行 先父类 再子类
        //super关键字 代表父类对象的引用
        //1.super()代表调用父类的构造方法
        //2.super.data; 代表调用父类的属性
        //3.super.func();代表调用父类的成员方法

        //this代表什么:当前对象的引用
        //1.this();调用其他的构造方法,只能放在第一行
        //2.this.data;
        //3.this.func();
    }
    public Bird(String name,int age){
         super(name);
    }
    public int age;
    public void fly(){
        //当前Bird类的对象
        System.out.println(this.name+"正在飞!");
    }
    public void eat(){
        System.out.println("Bird"+this.name+"正在吃!");
    }
    public void test() {
        System.out.println(this.sex);
    }
}
