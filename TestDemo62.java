/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo62
 * @Author: LENOVO
 * Date: 2020/5/4 18:54
 * project name: 20200428
 * @Version:
 * @Description:
 */
public class TestDemo62 {
    public static void main(String[] args) {
        int a=10;
        System.out.println(a);
        a=99;
        System.out.println(a);
        final int B;
        B=100;
        System.out.println(B);
        //B=2;报错

    }
    public static void main10(String[] args) {
        //变量作用域
        int a=10;
        {
            System.out.println("{}"+a);
        }
        System.out.println(a);
    }
    public static void main9(String[] args) {
        //在屏幕上打印出双引号的"hello"
        //转义 \"->"
        String s="\"hello\"";
        System.out.println(s);
    }
    public static void main8(String[] args) {
        //C语言没有字符串类型
        String s="abcd";
        System.out.println(s);
        int a=10;
        System.out.println("a = "+a);
        int c=20;
        System.out.println(a+c);//30
        System.out.println("a+c="+a+c);//a+c=1020
        System.out.println("a+c="+a+" "+c);//a+c=10 20
        System.out.println("a+c="+(a+c));//a+c=30
    }
    public static void main7(String[] args) {
        //boolean JVM没有规定大小
        //C弱类型语言 java 强类型语言
        boolean b=true;
        System.out.println(b);
    }
    public static void main6(String[] args) {
        //短整型
        short s=18;
        System.out.println(s);
    }
    public static void main5(String[] args) {
        //字节类型 byte -128->127
        byte b=Byte.MAX_VALUE;
        int c=2147483647;
        System.out.println(Byte.MAX_VALUE+1);//128
        System.out.println(c+1);//-2147483648
    }
    public static void main4(String[] args) {
        //字符型 2 C:ASCII字符集 Java Unicode
        char c='a';
        System.out.println(c);
    }
    public static void main3(String[] args) {
        //单精度 4
        float f=12.5f;
        System.out.println(f);

    }
    public static void main2(String[] args) {
        //双精度
        int a=1;
        int b=2;
        System.out.println(a/b);//0
        double a1=1;
        double b1=2;
        System.out.println(a1/b1);//0.5
        double c=1.1;
        double d=1.1;
        System.out.println(c*d);//1.2100000000000002
    }
    public static void main1(String[] args) {
        int a=10;
        System.out.println("a = "+a);
        long b=20L;//8个字节
        System.out.println("b = "+b);
        double d=12.5;//8个字节
        System.out.println("d = "+d);
    }
}

