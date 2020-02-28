public class Change{
//写代码实现: 给定三个 int 变量, 求其中的最大值和最小值	
	public static void main(String[] args){
		int num1=4;
		int num2=3;
		int num3=5;
		if(num1>num2){
			if(num3<num2){
				System.out.println("最大值为:"+num1+",最小的值为:"+num3);
			}else if(num3>num1){
				System.out.println("最大值为:"+num3+",最小的值为:"+num2);
			}else{
				System.out.println("最大值为:"+num1+",最小的值为:"+num2);
			}
			
		}
		if(num1<num2){
			if(num3<num1){
				System.out.println("最大值为:"+num2+",最小的值为:"+num3);
			}else if(num3>num2){
				System.out.println("最大值为:"+num3+",最小的值为:"+num1);
			}else{
				System.out.println("最大值为:"+num2+",最小的值为:"+num1);
			}
		}
	}
//写代码实现: 给定两个 int 变量, 交换变量的值	
	public static void main1(String[] args){
		int a=10;
		int b=20;
		int temp=0;
		temp=a;
		a=b;
		b=temp;
		System.out.println(a+" "+b);//还不太习惯这里的写法
	}	
}
