import java.util.Arrays;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo57
 * @Author: LENOVO
 * Date: 2020/4/28 18:32
 * project name: 20200428
 * @Version:
 * @Description:
 */

public class TestDemo57 {
    //整型变量
    public static void main(String[] args) {
        long num=10L;
        System.out.println(num);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        int a=10;
        //int num;
        System.out.println(a);
        //System.out.println(num);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
    public static  void main1(String[] args){
        String str1="g";
        String[] arg={str1,"a","o","b","o", "i"};
        args=arg;
        System.out.println("HelloWorld");
        System.out.println(args[0]);
        System.out.println(str1.toString());
    }
}
