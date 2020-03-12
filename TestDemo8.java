/**
 * 方法的定义 public static 返回值 方法名(形式参数){
 *     方法体;
 * }
 * 方法的调用只需要在调用的地方用 方法名(1,2,3,4);
 * 方法的重载:方法名相同 形参列表不同(个数,参数类型) 返回值不做要求 在一个类当中
 * 方法的递归 采用分治思想->>分而治之->>大的事情->>小的事情
 * 1.调用自己本身
 * 2.需要有一个趋近于终止的条件  否则会有异常抛出 栈溢出
 * 函数的调用需要在栈上开辟内存:1M/2M
 */
import java.util.Scanner;

/**
 * 调试打断点
 * variables
 * 代码逐步执行
 * 快捷键psvm回车 sout回车
 * 栈上的变量看不到地址
 * 引用类型在堆上存放 拿不到堆上的地址 只能拿到堆上的哈希码
 */
public class TestDemo8 {
    /**
     *每调用一次方法要在栈上开辟一块内存 后进先出
     * @param n
     * @return
     */
    public static int sumAdd(int n){
       if(n==1){
           return 1;
       }
       return n+sumAdd(n-1);
    }
    //5!
    public static int fac(int n){
        //日志来更清楚看清递归
        System.out.println("函数开始,n+"+n);
        if(n==1){
            System.out.println("函数结束,n+"+n);
            return 1;
        }
        int ret=n*fac(n-1);
        System.out.println("函数结束,n="+n+" ret="+ret);
        return ret;
    }
    public static void main1(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int ret=fib2(n);
        System.out.println(ret);
    }
    public static void print(int n){
        if(n>9){
            print(n/10);
        }
        System.out.print(n%10+" ");
    }
    public static void print1(int n){
        while(n!=0){
            System.out.print(n%10+" ");
            n=n/10;
        }
    }

    /**
     * 写一个递归方法，输入一个非负整数，返回组成它的数字之和. 例如，输入 1729, 则应该返回1+7+2+9，
     * 它的和是19
     * @param num
     * @return
     * 1.求每一位的数字 递
     * 2.把每一位的数字加起来 归
     * num是在一直变化的
     */
    public static int sum(int num){
        if(num<10){
            return num;
        }
        return num%10+sum(num/10);
        /**
         * 9+sum(172)
         * 9+2+sum(17)
         * 9+2+7+sum(1)
         * 9+2+7+1
         * 思考:递归公式
         */
    }

    /**
     *菲波那切数列 1 1 2 3 5 8 13 21......
     * 递归公式n (n-1)+(n-2)
     * @param n
     * @reurn
     * 不建议用递归来实现 时间非常慢
     * 缺点:会经常进行重复的运算
     * 递归是一个非常耗费内存的
     * 栈上开辟内存 栈溢出的可能性会很高
     * 不易于思考
     * 优点:代码简洁
     * 经常被用作处理复杂的问题(二叉树)
     */
    public static int fib(int n){
        if(n==1||n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
        //多路递归 二叉树
    }

    /**
     * 循环实现菲波那切数列
     * @param num
     */
    public static int fib2(int num) {
        int f1 = 1;
        int f2 = 1;

        int f3 = 1;
        for (int i = 3; i <= num; i++) {
            f3 = f1 + f2;//2
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    /**
     * 汉诺塔问题
     * 3个底座 A B C(pos1 pos2 pos3)
     * 64个盘子  大小不一样
     * 都在A这个底座上 把它们从A上挪到C上
     * 挪动过程中一定要保持 大的在下 小的在上
     * 2.A->B A->C B->C
     * 3.A->C A->B C->B A->C B->A B->C
     * 递归来写
     * n-1个通过C放在B 再把最后一个1个从A放在C 剩下的从B通过A放在C
     */
    public static void move(char pos1,char pos3){
        System.out.print(pos1+"->"+pos3+"' ");
    }
    public static void hanoi(int n,char pos1,char pos2,char pos3){
        if(n==1){
            move(pos1,pos3);
            return;
        }
        hanoi(n-1,pos1,pos3,pos2);//开始位置 中途转接位置 目的位置
        move(pos1,pos3);
        hanoi(n-1,pos2,pos1,pos3);
    }
    public static void main(String[] args){
        hanoi(1,'A','B','C');
        System.out.println();
        hanoi(2,'A','B','C');
        System.out.println();
        hanoi(3,'A','B','C');
    }
}
