package com.bit.src1;

import com.bit.sr2.Animal;

/**
 * @PackgeName: com.bit.src1
 * @ClassName: Test
 * @Author: LENOVO
 * Date: 2020/3/31 14:38
 * project name: 20200330
 * @Version:
 * @Description:
 */
public class Test extends Animal  {
    public Test(String name){
        super(name);
    }
    public void func(){
        //animal.sex是不可的 要是父类的super引用 不同包的子类
        System.out.println(super.sex);
    }
    public static void main(String[] args) {
        //同一个包下的不同的类 protected可以被访问
        Animal animal=new Animal("大黄");
        //不通包的非子类不能被访问 protected
        //System.out.println(super.sex);//static不依赖对象 super是对象的引用 不可以用super
    }
}
