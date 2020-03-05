import java.util.Scanner;
public class TestDemo3{
	public static void main1(String[] args){
		//三目运算符来求解更方便 找三个数字最大值
		Scanner scan=new Scanner(System.in);
		//手动输入
		//
		//int a=scan.nextInt();
		//int b=scan.nextInt();
		//int c=scan.nextInt();
		
		//int max=a>b?a:b;
		//System.out.println();
	}
	//逻辑控制
	//在任何语言 顺序 分支 循环
	public static void main2(String[] args){
		//顺序结构
		System.out.println('1');
		System.out.println('2');
		System.out.println('3');
	
	}
	//分支 
	//C语言里0是假 非0是真
	//java里真是true 假是false
	//if(表达式){//表达式一定是布尔类型的
	//注意事项:if语句后面的大括号,需要和if是在一行的
	//if如果没有大括号 默认
	public static void main3(String[] args){
	    Scanner scan=new Scanner(System.in);
	    int n=scan.nextInt();
	    if(n%2==0){
		    System.out.println("当前数字是偶数!");
	    }else{
		    System.out.println("当前数字是奇数!");
	    }
	}
	public static void main4(String[] args){
	    Scanner scan=new Scanner(System.in);
	    //循环读取 怎么停下来
	    //1.Ctrl+c 中断
	    //2.Ctrl+z 正常停止
	    while(scan.hasNext()){
		    int n = scan.nextInt();
	
	        if(n>0){
		        System.out.println("是正数");
	        }else if(n<0){
		        System.out.println("是负数");
	        }else{
		        System.out.println("是0");
	        }
	    } 
	}
	public static void main5(String[] args){
	    Scanner scan=new Scanner(System.in);
	    int year=scan.nextInt();
	    if(year%4==0&&year%100!=0||year%400==0){
	        System.out.println("当前"+year+"是闰年!");
	    }
	}
	
	//switch
	//不能做switch参数的类型
	//float double long boolean 不可以作为switch的参数
	public static void main6(String[] args){
	    Scanner scan=new Scanner(System.in);
	    int n=scan.nextInt();
	
	    switch(n){
	    case 1:
         	System.out.println("1");
			break;
			//直到遇到下一个break才会结束
        case 2:
         	System.out.println("2");
			break;
	    case 3:
         	System.out.println("3");
			break;
	    default :
         	System.out.println("输入有误!");
			break;
	    }
	
	}
    //循环结构 初始值 判断条件 循环的的步进
	//重复做一件事情
	//1.for
	//2.while
	//3.do while
    //4.foreach	
	public static void main7(String[] args){
		//while(表达式)  表达式->>布尔表达式
		//{循环体;}
		int num=10;
		int i=1;
		while(i<=num){
			System.out.print(i+" ");
			i++;		
		}
	}
	public static void main8(String[] args){
		int i=1;
		int j=0;
		int sum1=0;
		int sum2=0;
		while(i<=100){
			sum1+=i;
			i=i+2;		
		}
		while(j<=100){
			sum2+=j;
			j=j+2;		
		}
		System.out.println(sum1);
		System.out.println(sum2);
	}
	public static void main9(String[] args){
		//求n的阶乘之和
		 Scanner scan=new Scanner(System.in);
	    int n=scan.nextInt();
		int i=1;
		int ret=1;
		int sum=0;
		while(i<=n){
			ret=ret*i;
			i++;
            sum=sum+ret;			
		}
		System.out.println("阶乘"+ret);
		System.out.println("阶乘之和"+sum);
	}
	//break:结束所有循环
	//continue:结束本趟次循环
	//共同特性:一定要用在循环内
		public static void main10(String[] args){
		int i=100;
		//第一个被3整除的
		while(i<=200){
			if(i%3==0){
				System.out.println(i);
				break;
			}
			i++;
		}
	}
	public static void main11(String[] args){
		int i=100;
		//200以内所有被3整除的
		while(i<=200){
			if(i%3==0){
				i++;
				continue;
			}
			System.out.println(i);
			i++;
		}
	}
	//for(表达式1;表达式2;表达式3){
	//循环体;
	//}
	//执行顺序:1.表达式1最先执行的,只执行一次 2.执行表达式2,判断条件 布尔表达式 3.循环体 4.步进
	public static void main12(String[] args){
		for(int i=1;i<=100;i++){
			System.out.print(i+" ");
			
		}
		System.out.println("==============");
		int i=1;
		while(i<=100){
			System.out.print(i+" ");
			i++;
		}
	}
	//do{循环语句} while(循环条件) 不管怎样 至少会执行一次 
	public static void main(String[] args){
		int i=0;
		do{
			System.out.print("bbaa");
			i++;
		}while(i<=10);
		//死循环就是判断条件一直为真 一直执行 没有步进或者条件为真
		//for循环的第二个表达式为空也是死循环 或者为true也是死循环
	}
}