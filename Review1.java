/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: Review1
 * @Author: LENOVO
 * Date: 2020/4/20 17:34
 * project name: 20200420
 * @Version:
 * @Description:
 */

/**
 * 构造方法没有返回值 是用来实例化对象 toString的返回值是string
 */

class Calculator{
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
    public int add(){
        return this.num1+this.num2;
    }
    public int sub(){
        return this.num1-this.num2;
    }
    public int mul(){
        return this.num1*this.num2;
    }
    public double dev(int a,int b){
        double ret=(double)this.num1/this.num2;
        return ret;
    }

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}
class MyValue{
    public int val;

    public MyValue(int val) {
        this.val = val;
    }
}
public class Review1 {
    public static void swap(MyValue myValue,MyValue myValue1){
        int temp=myValue.val;
        myValue.val=myValue1.val;
        myValue1.val=temp;
    }

    public static void main(String[] args) {
        MyValue myValue1=new MyValue(10);
        MyValue myValue2=new MyValue(20);
        swap(myValue1,myValue2);
        System.out.println(myValue1.val+" "+myValue2.val);
    }
}
