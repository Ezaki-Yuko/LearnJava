import java.util.Scanner;
public class TestDemo7{
	/**
    *实参和形参的关系
	*
	*在java中实际上 只有按值传递
	*但是这个值 可以是普通的值 也可以是引用类型(指针->>保存地址)
	*形参是实参的一份拷贝
	*需要只是传简单类型是不能够满足交换的,真正的传法应该是传入引用(地址)
	*类与对象
	*目的是交换实参
	*/
	public static void main1(String[] args){
		int a=10;
		int b=20;
		System.out.println(a);
		System.out.println(b);
		swap(a,b);
		System.out.println(a);
		System.out.println(b);
	}
	public static void swap(int a,int b){
		int temp=a;
		a=b;
		b=temp;
	}
	/**
	*重载和重写有什么区别
	*重载(overload)
	*重写(override)
	*
	*重载:1.方法名相同 2.参数列表不相同(参数的个数/参数的类型) 3.返回值不做要求
	*针对一个类发生重载
	*/
	public static void main2(String[] args){
		int a=10;
		int b=20;
		int ret=add(a,b);
		System.out.println("两个数的和:"+ret);
		double c=12.5;
		double d=13.4;
		double ret2=add(c,d);
		System.out.println("两个数的和:"+ret2);
	}
	
	public static int add(int a,int b){
		return a+b;
	}
	public static int add(int a,int b,int c){
		return a+b+c;
	}
	public static double add(double a,double b){
		return a+b;
	}
	//错误重载
	//public static long add(int a,int b){
	//	return a+b;
	//}
	
	
	/**
	*递归:采用分治的算法
	*二叉树
	*要求:
	*1.一个程序要调用自己本身
	*2.有一个趋近于终止的条件
	*原理:函数的运行需要开辟栈帧,只要运行一个函数,就需要在栈上开辟内存
	*/
	//求1~10的和 用递归
	public static void main(String[] args){
		int b=sum(5);
		System.out.println(b);
	}
	public static int sum(int n){
		//n==1就是终止条件
		//不给终止条件 就会栈溢出 1M或者2M
		//因为方法的调用需要在栈上开辟内存 栈是有大小的 
		if(n==1){
			return 1;
		}
		return n+sum(n-1);
	}
}
