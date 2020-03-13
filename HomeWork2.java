/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork2
 * @Author: Fan yuxuan
 * Date: 2020/3/13 11:48
 * project name: 20200313test
 * @Version:
 * @Description:
 */
import java.util.Scanner;
public class HomeWork2 {
    public static int Fibonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    public static void main1(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入0-39的数字:");
        int n=scan.nextInt();
        while(n>39||n<0){
            System.out.println("输入数字表达范围不正确,请重新输入:");
            n=scan.nextInt();
        }
        int ret=Fibonacci(n);
        System.out.println(ret);
    }
        //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）

    /**
     *
     * @param target
     * @return
     */

    public static int jumpFloor(int target){
        if(target==1||target==2){
            return target;
        }
        //这里的target-1的意思是跳这么多数量的台阶需要几次
        //target-1是最后一下跳1阶  target-2是最后一下跳2阶
        return jumpFloor(target-1)+jumpFloor(target-2);
    }
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public static int jumpFloorII(int target){
        if(target==1) {
            return 1;
        }
        //2）n = 1时，只有1种跳法，f(1) = 1
        //3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2) 
        //4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，
        //    那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)
        //    因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)
        //5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论:
        //固定最后一跳是多少 看剩下的台阶可以有多少方法 如果n为3,f(0)就是最后一跳为3,f(1)最后一跳为2,剩下的台阶跳多少=f(1)
        //    f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
        //    f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
        //    f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
        //
        //    f(n) = 2*f(n-1)
        return 2*jumpFloorII(target-1);
    }
    public static void main(String[] args){
        int ret=jumpFloorII(3);
        System.out.println(ret);
    }
}
