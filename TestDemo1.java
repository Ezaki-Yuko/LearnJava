public class TestDemo1{
	public static boolean flg;//类的属性:定义在类内,但在方法外,是有默认值的,可不赋值
	public static void main(String[] args){
		//short char
		//两个字节大小都一样 本质上char是字符型,而byte和short都是数值型,他们之间 不建议转换
		//char类型来说.字符对应的十进制,是没有负数的
		short sh=10;
		char ch='高';
		//sh=ch;
		System.out.println(ch);
	}
	public static void main9(String[] args){
		//byte->char
		byte b=10;
		char ch='高';
		//找的是9所对应的字符
		//char ch2=9;;建议字符就是字符,不要给一个整型
		char ch2=9;
		//b=(byte)ch;
		ch=(char)b;
		//byte和char转换 不管是从大到小 还是从小到大 都需要进行强制类型转换
		System.out.println(b);
		System.out.println(ch);
		System.out.println(ch2);
	}
	public static void main8(String[] args){
		//String->int
		String s1="12";
		int a=Integer.parseInt(s1);
		System.out.println(a);
		System.out.println(flg);
		
	}
	public static void main7(String[] args){
		//int->String
		int a=10;
		String s1=a+" ";
		System.out.println(s1);
		
		String s2=String.valueOf(a);
		System.out.println(s2);
	}
	public static void main6(String[] args){
		int a=10;
	    long b=12L;
		//不同的类型参与运算,提升为较大的那个类型
		long c=a+b;
		System.out.println(c);
		int d=20;
		int e=a+d;
		System.out.println(e);
	}
	public static void main5(String[] args){
		
		//计算机运算的时候,想提升运算的速度.CPU 4个字节这样的方式取数据,存数据
		byte a=10;
	    byte b=12;
		//提升为4个字节 int a和b都提升为int 导致运算结果也是int
		//这里要注意byte和short
		byte c=(byte)(a+b);
		//int c=a+b;
		System.out.println(c);
	}
	public static void main4(String[] args){
		int a=10;
	    byte b=12;
		b=(byte)a;
		//b=a;
		System.out.println(a);
		
	}
	public static void main3(String[] args){
		int a=10;
	    //boolean b=true;
		//布尔类型不能和其他的类型进行转换
		//a=b;
		System.out.println(a);
		
	}
	
	public static void main2(String[] args){
		int a=10;
	    double b=12.3;
		a=(int)b;
		//b=a; 不管b后面有几个小数点,输出10.0
		System.out.println(b);
		
		
	}
	public static void main1(String[] args){
		//类型转化
	    int a=10;
	    long b=20L;
		//a=(int)b;
		//大类型赋值给小类型 直接赋值会报错 只需要进行强制类型转换 程序就不会报错了
	    b=a;//小类型赋值给大类型不会报错
		System.out.println(b);
	}
}
/**文档注释
*Author:
*
*
*/