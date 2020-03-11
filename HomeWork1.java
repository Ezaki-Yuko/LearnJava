/**
 * 有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
 */
import java.util.Scanner;
 public class HomeWork1 {
     public static void find(int arr[]){
         for(int i=0;i<arr.length;i++){
             int j=0;
             for(;j<arr.length;j++){
                 if(arr[i]==arr[j]&&i!=j) {
                     break;
                 }
             }
             if(j==arr.length){
                 System.out.println(arr[i]);
             }
         }
     }
     public static void main1(String[] args) {
         int s[]={1,2,3,4,3,2,1};
         find(s);
     }
    /**
     * 在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
     */
    public static void main2(String[] args){
        int a=10;
        int b=33;
        System.out.println("两个数的和;"+Add(a,b));
        double i=12.3;
        double j=45.3;
        System.out.println("两个数的和:"+Add(i,j));
    }
    public static int Add(int a,int b){
        return a+b;
    }
    public static double Add(double a,double b){
        return a+b;
    }

    /**
     * 在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，还可以求两个小数的最大值，以及两个小数和一个整数的大小关系
     * @param args
     */
    public static void main3(String[] args){
        double a=12.4;
        double b=23.4;
        int c=7;
        int d=9;
        max(a,b,c);
        System.out.println(max(c,d));
        System.out.println(max(a,b));
    }
    public static int max(int a,int b){
        int temp=a>b?a:b;
        return temp;
    }
    public static double max(double x, double y){
        double temp=x>y?x:y;
        return temp;
    }
    public static double max(int x, double y){
        double temp=x>y?x:y;
        return temp;
    }
    public static void max(double x,double y,int z){
        double temp=max( x,y);
        double first=max(z,temp);
        double min2=z<temp?z:temp;
        double min1=x<y?x:y;
        double third=min1<min2?min1:min2;
        double second=min1>min2?min1:min2;
        System.out.println(first+">"+second+">"+third);
    }

    /**
     * 创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
     * 要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
     * @param args
     */
    public static void main4(String[] args){
        Scanner scan=new Scanner(System.in);
        int n1=scan.nextInt();
        int n2=scan.nextInt();
        int n3=scan.nextInt();
        System.out.println(max3(n1,n2,n3));
    }
    public static int max2(int a,int b){
        int temp=a>b?a:b;
        return temp;
    }
    public static int max3(int x,int y,int z){
        int temp=max2(max2(x,y),z);
        return temp;
    }

     /**
      * 求 N 的阶乘
      * @param args
      */
    public static void main5(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        System.out.println(fac(n));
    }
    public static int fac(int n){
        int i=1;
        if(n==1){
            return 1;
        }else{
            return n*fac(n-1);
        }
    }
     /**
      * 求1！+2！+3！+4！+........+n!的和
      */
     public static void main6(String[] args){
         Scanner scan=new Scanner(System.in);
         int n= scan.nextInt();
         System.out.println(facSum(n));
     }
     public static int facSum(int n){
         int i=1;
         int ret=1;
         int sum=0;
         for(i=1;i<=n;i++){
             ret=ret*i;
             sum=sum+ret;
         }
         return sum;
     }
 }
