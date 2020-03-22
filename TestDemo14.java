/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo14
 * @Author: LENOVO
 * Date: 2020/3/22 14:20
 * project name: 20200322
 * @Version:
 * @Description:
 */
class Calculator{
    private int num1;
    private int num2;
//构造方法初始化,不要写一些功能性的

    public Calculator() {

    }

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Calculator(int num1) {
        this.num1 = num1;
    }

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
    public int sum(){
        return this.num1+this.num2;
    }
    public int sub(){
        return this.num1-this.num2;
    }
    public int mul(){
        return this.num1*this.num2;
    }
    public double rid(){
        return (double)this.num1/this.num2;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
    //toString 返回值是String 不重写就打印出类型+@+地址(哈希)
}
class MyValue{
    public int val;
}

public class TestDemo14 {

    public static void swap1(int[] array2){
        int temp=array2[0];
        array2[0]=array2[1];
        array2[1]=temp;
    }
    public static void swap(MyValue myValue,MyValue myValue2){
        int temp=myValue.val;
        myValue.val=myValue2.val;
        myValue2.val=temp;
    }

    public static void main(String[] args) {
        TestDemo15 testDemo15=new TestDemo15();
        testDemo15.add(0,10);
        testDemo15.add(1,20);
        testDemo15.add(2,30);
        testDemo15.add(3,40);
        testDemo15.display();
        System.out.println();
        System.out.println("========grow======");
        testDemo15.add(3,90);
        testDemo15.display();

    }
    public static void main4(String[] args) {
        MyValue myValue=new MyValue();
        myValue.val=10;
        MyValue myValue2=new MyValue();
        myValue2.val=10;
    }

    public static void main3(String[] args) {
        int[] array={10,20};
        System.out.println(array[0]+" "+array[1]);
        swap1(array);
        System.out.println(array[0]+" "+array[1]);
    }
    public static void main2(String[] args) {
        Calculator calculator=new Calculator(10,20);
        System.out.println(calculator.sum());
        System.out.println(calculator.sub());
        System.out.println(calculator.mul());
        System.out.println(calculator.rid());
    }
    public static void main1(String[] args) {
        Calculator calculator=new Calculator();
        calculator.setNum1(10);
        calculator.setNum2(20);
        System.out.println(calculator.sum());
        System.out.println(calculator.sub());
        System.out.println(calculator.mul());
        System.out.println(calculator.rid());
        //在没有重载toString方法打印:Calculator@1b6d3586
        //System.out.println(calculator.toString());
        //重载后:Calculator{num1=10, num2=20}
        System.out.println(calculator.toString());
    }
}
