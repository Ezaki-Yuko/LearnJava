/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo30
 * @Author: LENOVO
 * Date: 2020/4/5 16:15
 * project name: 20200405
 * @Version:
 * @Description: 自定义异常
 */
//class MyException extends RuntimeException{   MyException 非受查异常 可以不抛出不解决 交给jvm
//class MyException extends Exception{   MyException 编译时期异常 受查异常 必须抛出或解决
class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}
public class TestDemo30 {
    public static void func(int a) {
        try {
            if (a == 10) {
                throw new MyException("这里会有异常!");
            }
        }catch(MyException e){
            e.printStackTrace();
            System.out.println("捕获到异常");
        }
    }
    public static void main(String[] args){
            func(10);
    }
}
