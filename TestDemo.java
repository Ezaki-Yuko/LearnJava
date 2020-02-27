/*
1.java的起源
2.java的main方法
  static修饰 public static 是固定的
  void是返回值 表示无返回值
  main是方法的名称 main方法是程序的入口 有且只有一个
  String[] args 参数列表 运行时的命令行参数
3.标识符的定义:数字字母下划线$
不建议_或者$开头 数字不能开头.
4.不管多少位的机器 int的大小就是四个字节,跨平台
没有所谓的32位机器上4个字节 64 8
5.在运行时期可以改变的量叫做变量
  在运行期间不能修改的叫做常量 字面常量
*/
public class TestDemo{
	
	public static void main(String[] args){
		int a=10;//10 就是整型的字面值常量 a是变量
		System.out.println(a);
		a=99;
		System.out.println(a);
		System.out.println("============");
		final int SIZE = 200;
		//SIZE=100;error
		//定义常量需要使用关键字final
		//常量的名字需要大写
		//常量一旦赋值 后续不可以修改
		System.out.println(SIZE);
		
		final int SIZE2;
		//不论变量还是常量都需要初始化
		//只能初始化一次
        SIZE2 = 200;
		System.out.println(SIZE2);
	}
	public static void main10(String[] args){
		int a=10;
		{
			System.out.println("{}"+a);
		   
		}
		System.out.println(a);
	}
	public static void main9(String[] args){
		//在屏幕上方打印"HelloWorld" \  ->转义  \"==>"
		String s="\\HelloWorld\\";
		System.out.println(s);
		
	}
	public static void main8(String[] args){
		//字符串类型 C:没有字符串类型的 
		//String
		String s="abcdef";
		System.out.println(s);
		int a=10;
		System.out.println("a="+a);
		//+ =>拼接 如果是字符串+任意数据类型->整体字符串
		double d=12.5;
		System.out.println("gaobo="+d);
		
		int c=20;
		System.out.println(a+c);//30
		System.out.println("a+c="+a+c);//a+c=1020
		System.out.println("a+c="+(a+c));//a+c=30
		System.out.println("a+c="+a+" "+c);//a+c=10 20
		System.out.println("a="+a+",c="+c);
	}
	public static void main7(String[] args){
		//布尔类型 boolean JVM并没有规定其大小 只有两个取值
		//true false  在Java中 没有所谓的0就是假 非0就是真这个概念
		//Java里真只有一个那就是true 假只有一个那就是false
		//C:弱类型语言 java:强类型语言
		//Java大小写敏感
		boolean b=true;
		System.out.println(b);
	}
	public static void main6(String[] args){
		//短整型 short 2个字节  -32768->32767
		short s=32767;
	    System.out.println(s);
		System.out.println(Short.MAX_VALUE);
	}
	public static void main5(String[] args){
		//字节类型 byte 1个字节
		//-128->127
		byte b=12;
		System.out.println(b);
		
		//如果进行直接赋值,就是把一个越界的数字给对应的类型 
		//这种情况下会报错.
		//给变量赋值的时候不能超过其能表达的范围
		
	}
	public static void main4(String[] args){
	    //字符型 2个字节  C:ascii码 Java:Unicode字符集(包含ASCII码的)
	    char c='a';
	    System.out.println(c);
	    int d=c;
	    System.out.println(d);
	}
	public static void main3(String[] args){
	    //单精度浮点类型 4个字节
        float f=12.5f;//字面值 不加f默认double 不能编译
	    System.out.println(f);
	}
	public static void main2(String[] args){
		//双精度浮点类型 8
		double a=1;
		double b=2;
		//两个整型如果相除并不会保存小数
		//如果要保留小数 要把int改为double
		System.out.println(a/b);
		//double 小数其是在程序中,存储方式是不一样的 需要精度
		double c=1.1;
		double d=1.1;
		System.out.println(c*d);
		//写项目出现小数 最好用double
		//双精度浮点类型
	}
	public static void main1(String[] args){
		int a=10;//局部变量->>一定要初始化 否则不能通过 赋值 安全化
		//不可以把double赋值给int
		System.out.println("a="+a);//a==10
		
		long b=20L;//8
		System.out.println("b="+b);
		double d=12.5;
		System.out.println("d="+d);
	
	}
}