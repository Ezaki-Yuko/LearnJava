
import java.util.Scanner;
//方法 函数 功能 代码可以重复使用 java中有很多内嵌的方法
//访问修饰限定符 返回值 方法名(形式参数列表){  形式参数列表不止一个参数
//	函数体;不止一条语句 方法的具体实现
//}
//现阶段写方法加static是因为目前为止都是在main函数里进行调用的

public class TestDemo6{
	/**
	*void:代表当前方法没有返回值
	*addSum:方法名-->采用小驼峰-->addSum
	*(int n):形式参数列表
	*注意事项:
	*1.实参给形参传递是按照值传递的
	*2.传递过程中实参与形参的类型需要匹配
	*3.参数的个数需要匹配
	*4.一般情况下,不建议在方法内进行直接的打印
	*5.返回值->方法给你的一个响应.接收这个响应
	*6.返回什么样的类型 需要用什么样的类型来接收
	*
	*场景:8*(1到100的和)
	*@param n [description]
	*/
	public static int addSum(int n){//形参
		int sum=0;
		for(int i=0;i<=n;i++){
			sum=sum+i;
		}
		return sum;//计算机已经记录了你当前的和 响应
		//System.out.println(sum);//只是输出 计算机没有保存这个值
	}
	public static int facSum(int n){
		int sum=0;
		for(int i=1;i<=n;i++){
			sum=sum+fac(i);
		}
		return sum;
	}
	//求数字n的阶乘
    public static int fac(int n){
		int ret=1;
		for(int i=1;i<=n;i++){
			ret=ret*i;
		}
		return ret;
	}
	//可以没有参数 可以没有返回值
	public static void function(){
		System.out.println("im cool");
		return  ;
		//System.out.print("im very cool");
		//return 后面不建议写其他代码
	}
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n1=scan.nextInt();
		int ret=facSum(n1);
		System.out.println(ret);
		function();
		//int i=scan.nextInt();
		//int j=scan.nextInt();
		//int m=maxNum2(i,j);
		//main方法结束之后,整个程序就全部结束了
		//System.out.println(8*addSum(n));
		//int a=scan.nextInt();
		//int b=scan.nextInt();
		//int c=scan.nextInt();
		//int n=maxNum3(a,b,c);
		//System.out.print(m+" ");
		//System.out.print(" "+n);
		//实参
		//方法的调用 与C不同不需要进行方法的声明 C是自上而下编译
		//栈:先进后出 变量:定义在方法内部的变量称之为局部变量 局部变量存在栈上
	}
	
	//写一个方法 求两个数的最大值
	//再写一个方法求三个数的最大值
	public static int maxNum2(int a,int b){
		if(a>b){
			return a;
		}else{
			return b;
		}
	}
	public static int maxNum3(int a,int b,int c){
		int max=a>b?a:b;
		if(max>c){
			return max;
		}else{
			return c;
		}
		//int max=maxNum2(maxNum2(a,b),c);
		//return max;
	}
	
}