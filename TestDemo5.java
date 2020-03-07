import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;
import java.util.Random;
public class TestDemo5{
	public static void main1(String[] args){
	Scanner scan=new Scanner(System.in);  //System.in代表的是键盘 Scanner是工具
	int n=scan.nextInt();
	System.out.println("输出且换行");
	System.out.print("输出但是不换行");
	System.out.printf("%s\n","格式化输出");
	System.out.printf("%d\n",10);
	System.out.printf("%d\n",n);
	System.out.printf("%x\n",100);
	
	}
	public static void main2(String[] args){
	System.out.println("请输入一个字符:");
	    try{
		    //异常
		    //太麻烦 功能有局限性
	        char ch=(char)System.in.read();
	        System.out.println(ch);
	    }catch(IOException e){
		    //捕获异常
		    System.out.println("程序发生异常了!");
	    }
	
	
	}
	//Scanner的注意事项 
	//使用之前需要导入包java.util.Scanner;
	//
    public static void main3(String[] args){
	Scanner scan=new Scanner(System.in);  //System.in代表的是键盘 Scanner是工具
	int n=scan.nextInt();
	System.out.println("整型"+n);
	String name=scan.next();// 输入遇到空格就结束
	System.out.println("姓名"+name);
	double d=scan.nextDouble();
	System.out.println("小数"+d);
	String nn=scan.nextLine();//连着前面的会无法输入 自动读取前面的换行符了(println) 
	System.out.println("姓名"+nn);
	//String name=scan.nextLine();
	//System.out.println("姓名"+name);//只有这个代码的话 可以读取一整行 不论中间有无空格
	}
	public static void main4(String[] args){
		 //循环输入
	Scanner scan=new Scanner(System.in);  //System.in代表的是键盘 Scanner是工具
	
	while(scan.hasNext()){
		int n=scan.nextInt();
		System.out.println("整型"+n);
	}
	System.out.println("哈哈哈!");
	
	}
	public static void main5(String[] args){
    //猜数字
	Scanner scan=new Scanner(System.in);  //System.in代表的是键盘 Scanner是工具
	//1.生成一个随机数 Random
	Random random=new Random();//括号里面如果指定一个数每次产生随机数都一样 
	int rand=random.nextInt(100);//[]0->99]
	    while(true){
		    System.out.println("请输入你要猜的数字:");
		    int num=scan.nextInt();
			if(num>rand){
				System.out.println("你的数字猜大了!");
			}else if(num<rand){
				System.out.println("你的数字猜小了");
			}else if(num==rand){
				System.out.println("猜对了!");
				break;
			}
		
	    }
		System.out.println("游戏结束了!");
	
	}
	public static void main6(String[] args){
	Scanner scan=new Scanner(System.in); 
	int oldYear=scan.nextInt();
	
	    if(oldYear<=18){
			System.out.println("少年");
		
	    }else if(oldYear>=19&&oldYear<=28){
			System.out.println("青年");
		}else if(oldYear>=29&&oldYear<=55){
			System.out.println("中年");
		}else{
			System.out.println("老年");
		}
	}
	public static void main7(String[] args){
	Scanner scan=new Scanner(System.in); 
	int oldYear=scan.nextInt();
	
	    if(oldYear<=18){
			System.out.println("少年");
		
	    }else if(oldYear>=19&&oldYear<=28){
			System.out.println("青年");
		}else if(oldYear>=29&&oldYear<=55){
			System.out.println("中年");
		}else{
			System.out.println("老年");
		}
	}
	public static void main8(String[] args){
		//优化
		//1.8不是素数 a*b=8 1 8   2 4  肯定有一个数字小于等于n/2
		//2.肯定有一个数字小于等于根号n;
	Scanner scan=new Scanner(System.in); 
	int n=scan.nextInt();
	if(n==1){
		System.out.println("1既不是素数又不是和数");
	}
	int i;
	    for(i=2;i<=n/2;i++){
			if(n%i==0){
				break;
			}
	    }
		//程序走到这里有两种情况 
		//循环正常的退出 素数
		//因为break 不是素数
		if(i>=n/2){
			System.out.println(n+"是素数");
	    }else{
			System.out.println(n+"不是素数");
		
	    }
	}
	public static void main9(String[] args){
	Scanner scan=new Scanner(System.in); 
	int n=scan.nextInt();
	for(int num=1;num<=n;num++){
	int i;
	//所有和数学相关的函数,直接去找一个类:Math
	        for(i=2;i<=Math.sqrt(num);i++){
			    if(num%i==0){
				    break;
			    }
	        }
		    if(i>=Math.sqrt(num)){
			    System.out.println(num+"是素数");
	        }
		
	    }
	}
	public static void main10(String[] args){
	//一定要注意 不能写成int型 会有小数存在
	double sum=0;
	int flg=1;
	    for(int i=1;i<=100;i++){
			sum=sum+1.0/i*flg;
			flg=-flg;
	    }
		System.out.println(sum);
	}
	public static void main11(String[] args){
	//水仙花数 求得当前数字是几位数
	//求得每位数字是几?几^count次方
	//加起来等于原来的数字
	    for(int i=0;i<=999999;i++){
			int count=0;//1.数字的位数
			int temp=i;
			while(temp!=0){
				count++;
				temp=temp/10;
			}
			temp=i;
			int sum=0;
			while(temp!=0){
				sum=sum+(int)(Math.pow(temp%10,count));//3^count
				temp=temp/10;
			}
			//sum=>就是每个位上数字的次方和
			if(sum==i){
				System.out.println(sum+"是要找的数字");
			}
	    }
	}
	public static void main12(String[] args){
	Scanner scan=new Scanner(System.in);
    int n=scan.nextInt();
		
		for(int i=1;i<=n;i++){
		    for(int j=1;j<=i;j++){
			    System.out.print(i+"*"+j+"="+i*j+" ");
			}
			System.out.println();
		}
			
    }
	public static void main13(String[] args){
	//辗转相除法 当余数为0的时候除数就是最大公约数
	Scanner scan=new Scanner(System.in);
    int a=scan.nextInt();//18
    int b=scan.nextInt();//24
	int c=a%b;//余数  18%24=18
	    while(c!=0){
			a=b;//a=24
			b=c;//b=18
			c=a%b;//c=24%18=6
	    }
		System.out.println("最大公约数"+b);
    }
	public static void main14(String[] args){
		
	    //辗转相除法 当余数为0的时候除数就是最大公约数
	    Scanner scan=new Scanner(System.in);
		
		int count=3;
		System.out.println("请输入您的密码 您有三次机会!");
		while(count!=0){
			System.out.println("请输入正确的密码:");
			String password=scan.next();
			//判断字符串是否相同用方法equals
			if(password.equals("123456")){
				System.out.println("登录成功!");
				break;
			}else {
				count--;
				System.out.println("登陆失败,你还有"+count+"次机会!");
			}
		}
	}
	public static void main15(String[] args){
	    //写一个函数 返回参数二进制中1的个数 15 00001111 4个1
	    //位运算符
	    //&(两边对应位都是1才是1) 和0000 0001按位与 右移
	    //| ^
	    Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
	    int count=0;
	    while(n!=0){
			if((n&1)!=0){
				count++;
			}
			n=n>>>1;
			//无符号右移 避免负数右移补1
	    }
		System.out.println(count);
	}
	public static void main16(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
	    int count=0;
	    while(n!=0){
			count++;
			n=n&(n-1);
	    }
		System.out.println(count);
	}
	public static void main(String[] args){
		//获取一个数二进制序列中所有的偶数位和奇数位,分别输出二进制序列
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=31;i>=1;i-=2){
			System.out.print(((n>>>i)&1)+" ");
		}
		System.out.println();
		for(int i=30;i>=0;i-=2){
			System.out.print(((n>>>i)&1)+" ");
		}
	}
}