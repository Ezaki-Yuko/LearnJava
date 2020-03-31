package com.bit.sr2;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: com.bit.sr2.Animal
 * @Author: LENOVO
 * Date: 2020/3/30 18:41
 * project name: 20200330
 * @Version:
 * @Description:
 */
public class Animal {
    public String name;
    protected String sex;
    //提供一个带有参数的构造方法
    public Animal(String name){
        this.name=name;
    }
    public Animal(String name,int age){
        this.name=name;
    }
    public void eat(){
        System.out.println("Animal"+this.name+"正在吃!");

    }
}
