/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo29
 * @Author: LENOVO
 * Date: 2020/4/5 14:46
 * project name: 20200405
 * @Version:
 * @Description:
 */


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 异常从上往下追踪
 * 异常也是一个类
 * Throwable->Error和Exception 错误必须手动解决
 * 编译时期异常 受查异常
 * 运行时期异常 非受查异常
 */
class Person implements Cloneable{
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    //有可能不支持克隆 要有异常
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TestDemo29 {


    public static void func3(int x,int y) throws ArithmeticException{
        if(y==0){
            //程序员 想自己手动抛出异常
            //一般手动抛出的异常是自定义异常
            //Java语言规范将派生于 Error 类或 RuntimeException 类的所有异常称为 非受查异常, 所有的其他异常称为 受查
            //异常.
            //如果一段代码可能抛出 受查异常, 那么必须显式进行处理
            //要么处理要么抛出
            throw new ArithmeticException("你给的y=0 不能作为除数!");
        }
        System.out.println(x/y);
    }
    public static void main(String[] args) {
        try{
            func3(10,5);
        }catch(ArithmeticException e){
            System.out.println("除数为0");
        }
    }
    //throws 声明一个异常 告诉程序员调用此方法需要处理异常
    public static void func2()throws ArrayIndexOutOfBoundsException{
        int[] array={1,2,3,4,5,6};
        System.out.println(array[100]);
    }
    public static void main5(String[] args) {
        try{
            func2();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界异常!");
        }
    }
    public static int func(){
        try{
            int a=10/0;
            return a;
        }catch(ArithmeticException e){
            System.out.println("数组越界异常");
            return 80;
        }finally{
            System.out.println("finally被执行了");
            return 19;
        }
    }
    public static void main4(String[] args) {
        Scanner scanner=new Scanner(System.in);
        try{
            int n=scanner.nextInt();
            System.out.println(n);
        }catch(InputMismatchException e){
            System.out.println("输入参数不匹配!");
        }finally{
            scanner.close();
        }
    }
    /**
     * finally的注意事项:
     * 1.finally中的代码肯定会被执行 不论是否发生异常
     * 2.finally中千万不要写return语句
     * 3.用于资源的释放
     *   例如:I/O流 文件 关闭
     * @param args
     */
    public static void main3(String[] args) {
        try{
            int[] array={1,2,3,4,5,6};
            System.out.println(array[100]);
            System.out.println("after");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界异常");
        }finally{
            System.out.println("finally被执行了");
        }
        System.out.println("异常处理完了");
    }
    public static void main2(String[] args) {
        /**
         * 处理异常
         * 如果不处理异常就会交给jvm 立即停下来不会被执行
         */
        try {
            int[] array = null;
            System.out.println(array.length);
            System.out.println("这行代码如果发生异常也不会被执行");
            //捕获多个异常的两种表达
            //不要尝试如下的捕获全部异常
        }catch(Exception e){
            e.printStackTrace();
        }
        //catch(NullPointerException |ArrayIndexOutOfBoundsException e){ //一定要捕获相应的异常 如果不是也会交给jvm处理
           // e.printStackTrace();//打印当前异常 追踪栈中的信息
            //System.out.println("捕获了异常!");
        //}// catch(ArrayIndexOutOfBoundsException e){
           //  System.out.println("捕获数组越界异常");
         //}
        //try catch不会影响接下来的代码
        System.out.println("==================");
    }
    public static void main1(String[] args)  {
        Person person=new Person();
        try {
            Person person2 = (Person) person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
/**
 * try {
 *     将来可能出现异常的代码
 * }catch{
 *     如果出现异常,这里进行补货
 * }
 */