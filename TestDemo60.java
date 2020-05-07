/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo60
 * @Author: LENOVO
 * Date: 2020/5/4 15:23
 * project name: 20200428
 * @Version:
 * @Description:
 */
public class TestDemo60<E> {
    //当前这个data的类型是什么可以当成是一个Object[].Object具体代表什么在实例化是确定
    private E[] data =(E[])new Object[10];
    private int size;
    public E get(int index){
        return data[index];
    }
    public void add(E elem){
        data[size]=elem;
        size++;
    }

    public static void main(String[] args) {
        TestDemo60<String> SeqList=new TestDemo60<>();
        //向上转型 String->Object
        SeqList.add("aaa");
        SeqList.add("bbb");
        //这里需要向下转型 需要判断
      /*  String str=" ";
      //=null没有实例化 没有分配空间 第二步没有完成
        if(str instanceof Object){
            str=(String)SeqList.get(0);
            System.out.println(str);
        }*/
        String str= SeqList.get(0);
        TestDemo60<Integer> integerSeqList=new TestDemo60<>();
        //装箱 int=>Integer
        Integer num=new Integer(10);
        //valueOf是静态方法使用类名调用
        Integer num2=Integer.valueOf(10);
        //自动装箱 直接赋值
        Integer num3=10;
        integerSeqList.add(new Integer(10));

        //拆箱
        num=integerSeqList.get(0);
        int value=num.intValue();
        int value2=num;//自动拆箱
    }

}
