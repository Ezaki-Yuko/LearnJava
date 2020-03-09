
import java.util.Scanner;
public class HomeWork{
	//获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
	public static void outPut(int n){
		//偶数位
		for(int i=31;i>=1;i-=2){
			System.out.print(((n>>>i)&1)+" ");
		}
		System.out.println();
		//奇数位
		for(int i=30;i>=0;i-=2){
			System.out.print(((n>>>i)&1)+" ");
		}
		
	}
	public static void main1(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
        outPut(n);		
	}
	//编写代码模拟三次密码输入的场景。最多能输入三次密码，密码正确，提示“登录成功”,密码错误,可以重新输入，最多输入三次。三次均错，则提示退出程序
	public static void valiDation(){
		Scanner scan=new Scanner(System.in);
		System.out.println("输入您的密码,您有三次机会!");
		int count=3;
		while(count!=0){
			System.out.println("请输入正确密码:");
			String password=scan.next();
			if(password.equals("123456")){
				System.out.println("登录成功!");
				break;
			}else{
				count--;
				System.out.println("您还有"+count+"次机会");
			}
		}
		
		
	}
	public static void main2(String[] args){
		valiDation();
	}
	//输出一个整数的每一位，如：123的每一位是1,2,3
	public static void bitWise1(int n){
		int i=1;
		while(n!=0){
			System.out.print(n%10+" ");
			n=n/10;
		}
		
	}
	public static void bitWise2(int n){
		if(n>9){
			bitWise2(n/10);
		}
		System.out.print(n%10+" ");
	}
	
	public static void main3(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		bitWise2(n);
	}
	//输出n*n的乘法口诀表，n由用户输入。
	public static void table(int n){
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				
				System.out.print(j+"*"+i+"="+i*j+" ");
		    }
		    System.out.println();
		}	
	}
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		table(num);
	}
}