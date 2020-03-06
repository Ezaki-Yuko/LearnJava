import java.util.Scanner;
public class TestDemo4{
	//编写程序数一下 1到 100 的所有整数中出现多少个数字9
	public static void main1(String[] args){
		int i=0;
		int count=0;
		for(i=0;i<101;i++){
			if(i%10==9){
				count++;
			}
			if(i/10==9){
				count++;
			}
		}
		System.out.println(count);
	}
	//输出 1000 - 2000 之间所有的闰年
	public static void main2(String[] args){
		int i=1000;
		for(i=1000;i<=2000;i++){
		    if(i%4==0&&i%100!=0||i%400==0){
			System.out.print(i+" ");
		    }	
		}
		
	}
	//打印 1 - 100 之间所有的素数
	//本身是大于1
	public static void main3(String[] args){
		int i=2;
		int n=2;
		for(i=2;i<=100;i++){
			for(n=2;n<=i;n++){
				if(i%n==0){
					break;
				}
			}
		    if(i==n){
				System.out.print(i+" ");
			
			}
			
		}
	}
	//给定一个数字，判定一个数字是否是素数
	public static void main4(String[] args){
	Scanner scan=new Scanner(System.in);
	int n=scan.nextInt();
	int m=2;
	    for(m=2;m<=n;m++){
		    if(n%m==0){
				break;
		    }
	    }
		if(m==n){
			System.out.println(n+"为素数");
		}else{
			System.out.print(n+"不是素数");
		}
		
	}
	//根据输入的年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
	public static void main5(String[] args){
	    Scanner scan=new Scanner(System.in);
	    int n=scan.nextInt();
	    if(n>=0&&n<=18){
		    System.out.println(n+"的年龄为少年");
	    }else if(n>=19&&n<=28){
		    System.out.println(n+"的年龄为青年");
	    }else if(n>=29&&n<=55){
		System.out.println(n+"的年龄为中年");
	    }else if(n>=56){
		    System.out.println(n+"的年龄为老年");
	    }else{
		    System.out.println(n+"为非法年龄");
	    }
    }
	//完成猜数字游戏 ，用户输入数字，判断该数字是大于，小于，还是等于随机生成的数字，等于的时候退出程序。
	public static void main6(String[] args){
		Scanner scan=new Scanner(System.in);
	    int n=scan.nextInt();
		int toGuess = (int)(Math.random()*100+1);
		while(n!=toGuess){
			if(n>toGuess){
				System.out.println("太大了!");
			}else if(n<toGuess){
				System.out.println("太小了!");
			}
			System.out.println("请继续输入你想猜的数字!");
			n=scan.nextInt();
		}
		if(n==toGuess){
				System.out.println("恭喜你猜对了!");
	    }
	}
	//求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本 身，如；153＝1＋5＋3?，则153是一个“水仙花数“。）
    public static void main7(String[] args){
		int i=0;
	    for(i=0;i<=9;i++){
			if(i==i*i*i){
				System.out.print(i+" ");
			}
		}
		for(i=10;i<=99;i++){
			int n=i/10;
			int m=i%10;
			if(i==n*n*n+m*m*m){
				System.out.print(i+" ");
			}
		}
		for(i=100;i<=999;i++){
			int a=i%10;
			int b=(i/10)%10;
			int c=i/100;
			if(i==a*a*a+b*b*b+c*c*c){
				System.out.print(i+" ");
			}
		}
	}
	//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值 。
	public static void main8(String[] args){
		int n=1;
		int sum=0;
		for(n=1;n<=100;n++){
			int temp=1;
			sum=sum+(temp*(1/n));
			temp*=-1;
		}
		System.out.print(sum);
	}
	//求两个正整数的最大公约数
	public static void main9(String[] args){
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int max=0;
	    int smaller = a < b ? a : b;
	    int i=1;
	    for (i = 1; i < smaller; i++) {
		    if (a%i == 0 && b%i == 0) {
			    max = i;
		    }
	    }
        System.out.print(max+"为最大公约数");
	}
	//求一个整数，在内存当中存储时，二进制1的个数。
}
