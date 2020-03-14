/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo9
 * @Author: Fan yuxuan
 * Date: 2020/3/14 9:07
 * project name: 20200314
 * @Version:
 * @Description:
 */

/**
 * 数组:是一组连续的内存,存放的是相同数据类型的数据集合 数据结构
 * 数组名.length===>数组的长度
 * 数组越界 异常信息
 * java.lang.ArrayIndexOutOfBoundsException:
 */
import jdk.nashorn.internal.objects.NativeString;

import java.util.Arrays;
import java.util.Scanner;

public class TestDemo9 {

    public static void main1(String[] args) {
       int[] array1=new int[3];//定义没有初始化,默认值为0

       int[] array2={1,2,3,4,5,6,7,8,9,10};//定一切初始化了一个数组,数组大小为10

       int[] array3=new int[]{1,2,3,4,5,6,7};//定义且初始化了一个数组,数组大小为7
        //打印数组的三种方式:for循环 for each Arrays
        for(int i=0;i<array2.length;i++){
            System.out.print(array2[i]+" ");
        }
        System.out.println();
        System.out.println("==============for each======================");
        //for each
        //i代表的是 每一个元素的值
        //for(数组里面的元素,数组){
        // }
        for(int i:array2){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("==============Arrays======================");
        //将数组内容以字符串的形式输出 在java当中提供了一个工具类帮助我们操作数组Arrays
        System.out.println(Arrays.toString(array2));
    }
    /**
     * 数据类型:
     * 基本数据类型:byte char short int float double long boolean
     * 引用数据类型 String 类 数组 枚举 接口
     *
     * 局部变量在栈上array1存在栈上 里面存的地址 对象的地址 对象在堆上
     * new int[]{1,2,3}在堆上开辟内存 堆上的地址拿不到 只能拿到一个真实的地址经过hash的
     * JDK JRE JVM 支持跨平台的原因是 所有的程序都会跑在JVM上
     * JVM内存的划分 五块内存
     * JAVA虚拟机栈(平时说的栈基本都是在虚拟机栈)本地方法栈(有一些方法native修饰)堆(存放对象 new)方法区(类的信息)程序计数器(指令)
     */
    public static void main2(String[] args) {
        int[] array2={1,2,3,4,5,6,7,8,9};
        System.out.println(array2[0]);
        array2[0]=888;
        System.out.println(array2[0]);
        print(array2);
        System.out.println(Arrays.toString(array2));
        //array和array2都是引用 引用同一个对象 存的地址 指向堆上的对象
        //浅拷贝的基础 在拷贝完成后 两个引用指向一个对象 这种现象叫做浅拷贝
        //深拷贝:有点类似与基本数据类型的引用
    }
    public static void print(int[] array){
        array[1]=999;
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    /**
     *
     * @param c
     * @param d
     */
    public static void swap1(int c,int d){
       int temp=c;
       c=d;
       d=temp;
    }
    public static void main3(String[] args) {
        //交换两个数字
        int a=10;
        int b=20;
        System.out.println(a+" "+b);
        swap1(a,b);
        System.out.println(a+" "+b);
    }
    public static void swap(int[] array2){
        int temp=array2[0];
        array2[0]=array2[1];
        array2[1]=temp;
    }

    /**
     * 正确的交换
     * 原理就是传地址->引用
     * @param args
     */
    public static void main4(String[] args) {
        int[] array={10,20};
        System.out.println(array[0]+" "+array[1]);
        swap(array);
        System.out.println(array[0]+" "+array[1]);
    }

    /**
     * 数组是引用类型
     * 简单类型如果是局部变量不许初始化 没有默认值
     * 引用类型 所对应的0值是null 布尔类型 false '\u0000' 0.0 0.0f
     * 空指针异常 java.lang.NullPointerException
     *JVM中的运行时常量池->常量池 作用:专门用来存放字符串常量的 String
     * JDK1.7以后 常量池被挪在了堆当中 之前是在方法区
     * 线程:每个线程都会拥有独立的三块内存,程序计数器 虚拟机栈 本地方法栈     堆和方法区是被线程共享的
     * 如果一个方法被native修饰 那么这个方法底层是由C/C++代码实现的,这种方法一般在源码当中 速度快
     * @param args
     */
    public static void main5(String[] args) {
        Scanner scan=new Scanner(System.in);
        //根据空格分割字符 拿到每一个字符12->数字12
        int[] array=new int[4];
        for(int i=0;i<array.length;i++){
            array[i]=scan.nextInt();
        }

       //array=null;
        System.out.println(Arrays.toString(array));
        System.out.println(array.length);
    }
    public static int[] transform(int[] arr){
        int[] ret=new int [arr.length];
        for(int i=0;i<arr.length;i++){
            ret[i]=arr[i]*2;
        }
        return ret;
    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main6(String[] args) {
        int[] arr={1,2,3,4};
        int[] output=transform(arr);
        printArray(output);
        printArray(arr);
    }

    /**
     * 自己实现toString
     * @param array
     * @return
     */
    public static String myToString(int[] array){
        String ret="[";
        for(int i=0;i<array.length;i++){
            ret=ret+array[i];
            if(i!=array.length-1){
                ret=ret+",";
            }
        }
        ret=ret+"]";
        return ret;
    }
    public static void main7(String[] args){
        int[] arr=new int[]{1,2,3,4};
        System.out.println(myToString(arr));
    }

    /**
     * 数组的拷贝:
     * 1.for循环进行拷贝 main8
     * 2.System.arraycopy (Object src,int srcPos,Object dest,int destPos,int length) main9
     * 从源数组的指定位置复制到目标数组的指定位置
     * src:源数组
     * srcPos:源数组开始拷贝的下标
     * dest:目的数组
     * destPos:拷贝到目的数组的这个下标
     * length:拷贝多大
     * Object是所有类的父类 什么类型都可拷贝
     *3.Arrays.copyOf(int[] original,int newLength); main10
     *这个方法底层调用的方法是System.arraycopy
     * 4.了解 clone()-->Object main11
     *创建并返回此对象的一个副本
     * 总结 以上四种拷贝方式全部都是浅拷贝
     * 如果数组当中的元素是简单类型,那么他是深拷贝,如果数组当中存放的是引用类型,那么他是浅拷贝
     * @param args
     */
    public static void main8(String[] args){
        int[] arr={1,2,3,4,5};
        int[] ret=copyArray(arr);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] copyArray(int[] arr1){
        int[] arr2 = new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            arr2[i]=arr1[i];
        }
        return arr2;
    }
    public static void main9(String[] args) {
        int[] array={1,2,3,4,5};
        int[] dest=new int[array.length];
        //鼠标按住加Ctrl
        //arraycopy底层就是C/C++写的 底层是native方法 拷贝更快
        System.arraycopy(array,0,dest,0,array.length );
        System.out.println("dest"+Arrays.toString(dest));
    }

    public static void main10(String[] args) {
        int[] array={1,2,3,4,5};
        int[] ret=Arrays.copyOf(array,array.length);
        System.out.println("ret"+Arrays.toString(ret));
    }

    public static void main11(String[] args) {
        int[] array={1,2,3,4,5};
        int[] ret=array.clone();
        System.out.println("ret"+Arrays.toString(ret));
    }

    /**
     * 深拷贝 数组内是存放简单类型
     * 浅拷贝 数组内是存放引用类型(地址) 拷贝了另一个数组存放地址 指向同一个对象 修改一个就会两个一起变
     * 如果浅拷贝要达到深拷贝要拷贝到对象本身 这样就不会影响原来的 这两个就是独立的
     * 实现深拷贝要用到接口的知识 cloneable
     * @param args
     */
    public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        System.out.println("拷贝前array:"+Arrays.toString(array));
        int[] ret=Arrays.copyOf(array,array.length);
        System.out.println("拷贝后ret"+Arrays.toString(ret));
        ret[0]=999;
        System.out.println("拷贝后ret修改"+Arrays.toString(ret));
        System.out.println("拷贝后array:"+Arrays.toString(array));
    }
}






