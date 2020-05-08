import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo61
 * @Author: LENOVO
 * Date: 2020/5/4 16:45
 * project name: 20200428
 * @Version:
 * @Description:
 */
public class TestDemo61 {
    public static void main(String[] args) {
        //1.创建List实例
        List<String> list=new ArrayList<>();
        //2.新增元素
        list.add("C");
        list.add("java");
        list.add("C++");
        list.add("Python");
        /*List<String> list4=new ArrayList<>();
        list4.add("aa");
        System.out.println(list.addAll(list4));*/
        //3.打印整个list
        System.out.println(list);
        //4.按照下标访问元素
        System.out.println(list.get(0));
        //数组越界会报异常 IndexOutOfBoundsException
        //5.根据下标修改元素
        list.set(0,"PHP");
        System.out.println(list);
        //6.使用for循环来访问每个元素
        for(String s:list){
            System.out.println(s);
        }
        //collection中的操作 list同样可以使用
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //7.使用subList来获取子序列
        //包含1 不包含3
        System.out.println(list.subList(1,3));
        //可以使用构造方法来构造新的List对象
        List<String> list2=new ArrayList<>(list);
        //复制了一份list
        System.out.println(list2);
        list.set(0,"C#");
        System.out.println(list2);
        System.out.println(list);
        //这里的String是一个不可变对象
        //验证是不是深拷贝 要给List泛型参数填一个可变对象的类型才可以
    }
}
