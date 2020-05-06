import java.util.HashMap;
import java.util.Map;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo59
 * @Author: LENOVO
 * Date: 2020/5/3 20:35
 * project name: 20200428
 * @Version:
 * @Description:
 */
public class TestDemo59 {
    public static void main(String[] args) {
        //1.创建Map实例 泛型参数有两个 第一个参数是key的类型 第二个value的类型
        //key value这种结构的目的就是根据K找到V
        Map<String,String> map=new HashMap<>();
        //HashMap<String,String>也可以
        //2.使用size 获取到元素个数(键值对个数)
        System.out.println(map.size());
        //3.使用isEmpty查看当前是否为空
        System.out.println(map.isEmpty());
        //4.存放键值对
        map.put("及时雨","宋江");
        map.put("玉麒麟","卢俊义");
        map.put("智多星","吴用");
        map.put("入云龙","公孙胜");
        //5.使用get方法根据key来查找对应的value
        System.out.println(map.get("及时雨"));
        //如果key不存在就返回null
        System.out.println(map.get("大刀"));
        //getOrDefault 如果key不存在就返回默认值
        System.out.println(map.getOrDefault("行者","武松"));
        //6.通过containsKey和containsValue来判定某个值是否存在
        //containsKey执行效率较高 推荐使用前者
        System.out.println(map.containsKey("智多星"));
        System.out.println(map.containsValue("公孙胜"));
        //7.再次使用isEmpty 和size
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        //8.foreach 遍历Map中的所有键值对
        //Entry :表示一个条目 也就是一个键值对
        //map.entrySet 获取到所有键值对
        //Map中的元素顺序和插入顺序无关 取决于具体的实现方式
        //Map是java中的接口，Map.Entry是Map的一个内部接口。
        //Map提供了一些常用方法，如keySet()、entrySet()等方法，keySet()方法返回值是Map中key值的集合；
        // entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
        //Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。
        // 接口中有getKey(),getValue方法。
        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        map.remove("入云龙");
        map.clear();
    }
}
