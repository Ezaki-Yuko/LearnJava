//运算符
public class TestDemo2{
	public static void main(String[] args){
		//位运算符& | ~ ^
		//按位与 按位或 按位取反 按位异或
		//无符号右移>>> 右移>> 左移<< 
		int b=-2;
		byte c=13;
		System.out.println(b>>1);
	}
	public static void main9(String[] args){
		//System.out.println(10 > 20 && 10 / 0 == 0);
		//短路问题 如果第一个为假就会去继续运算第二个表达式 报异常
		//如果为真就不会报异常 因为不去运算第二个表达式
		System.out.println(10 > 20 || 10 / 0 == 0);
		//不建议使用& | 不支持短路运算 就算表达式1满足 也会继续运算2
		//System.out.println(10 > 20 & 10 / 0 == 0);
		//System.out.println(10 > 20 | 10 / 0 == 0);
	}
	public static void main8(String[] args){
		int a=10;
		int b=20;
		//逻辑非只能作用于布尔类型
		//System.out.println(!a<b);
		boolean flg=true;
		System.out.println(!flg);
	}
	//&&逻辑与  并且
	//表达式1 && 表达式2  表达式1和表达式2必须是boolean布尔表达式 两真为真 一假为假
	//短路的 如果表达式1为假 就不考虑2了
	//逻辑或 表达式1 || 表达式2 一真为真
	//短路或 如果表达式1真 就不执行表达式2
	public static void main7(String[] args){
		int a=1;
		int b=2;
		boolean flg1=true;
		boolean flg2=false;
		System.out.println(flg1&&flg2);
	}
	public static void main6(String[] args){
		int a = 10;
        int b = 20;
		//关系运算符返回类型是boolean
        System.out.println(a == b);//false
        System.out.println(a != b);//true
        System.out.println(a < b);//true
        System.out.println(a > b);//false
        System.out.println(a <= b);//true
        System.out.println(a >= b);//false
	}
	public static void main5(String[] args){
		int i=10;
		i=i++;//C:11 Java:10
		System.out.println(i);
	}
	public static void main4(String[] args){
		int i=10;
		int a=i++;
		//int a=++i;先自加 再赋值
		System.out.println(a);
		System.out.println(i);
	}
	public static void main3(String[] args){
		System.out.println(11.5%2.0);//1.5
	
		//System.out.println(5/0);
		//0不能作为除数
		//编译的时候没有报错,运行时错误
		//受查异常:编译时异常
		//非受查异常:运行时异常
	}
	public static void main2(String[] args){
		System.out.println(5/2);//2
		System.out.println(5.0/2);
		System.out.println(5/2.0);
		System.out.println(5.0/2.0);
	}
	public static void main1(String[] args){
		System.out.println(10%3);//1
		System.out.println(10%-3);//1
		System.out.println(-10%3);//-1
		System.out.println(-10%-3);//-1
	}
}