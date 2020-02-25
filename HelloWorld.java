/*
块注释 Ctrl+shift+/;取消一样的方式
1.在java当中,每个java文件当中只能有一个public类,且
这个类名,一定要和文件名相同.
2.编码->>文本当中utf-8
  javac -> 默认是以GBK编码(中文不可映射)
  javac -encoding utf-8 HelloWorld.java
3.java的main函数.
有一个参数:String[] args->>数组->>字符串数组
作用是什么
 回答:命令行参数 当在运行java程序的时候,java HelloWorld gaobo is cool
运行时命令行参数 
4.System.out.println();输出语句,输出且换行
System.out.print();输出不换行
System.out.printf("%d",10);格式化输出

5.为什么main函数是用static关键字修饰的
6.编码格式->> 
7.类名单词首字母大写
8.System.out.println("HelloWorld");双引号引起来的就是字符串
通过main函数->>
1.了解程序的执行
2.了解程序的编码规范

1.数据类型和运算符
变量:肯定会占用内存 
2.变量名:->标识符
标识符构成->数字,字母,下划线,$
a.数字不能开头 1num是错误的 num1可以
b.变量名采用小驼峰命名规则->maxNum
c.虽然_和$可以开头,但是规约手册指出,不建议开头
合法但是不合理
3.定义的局部变量没有给初始值,java编译不能通过
4.int->整型占四个字节 32bit位
       -2^31->2^31
5.
*/
/**
*文档注释
*
*/


public class HelloWorld {
	public static void main ( String[] args) {
		//行注释
		int num = 10;//变量->局部变量
		System.out.println(num);
		//Integer.MAX_VALUE 能够拿到int类型的最大值
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
