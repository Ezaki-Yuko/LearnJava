import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo34
 * @Author: LENOVO
 * Date: 2020/4/11 10:33
 * project name: 20200411
 * @Version:
 * @Description:
 */
public class TestDemo34 {
    //Map带有两个泛型参数,类型可以不一样
    public static void main(String[] args) {
        //1.实例化一个Map,new一个实现Map的类
        Map<String,String>map=new HashMap<>();
        //2.isEmpty size
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        //3.put插入若干个键值对 key=>value 反向不行
        map.put("及时雨","宋江");
        map.put("玉麒麟","卢俊义");
        map.put("智多星","吴用");
        map.put("入云龙","公孙胜");
        map.put("行者","武松");
        //4.使用get根据key找value
        System.out.println(map.get("及时雨"));
        System.out.println(map.get("行者"));//key不存在返回null
        //找到key就返回value,没找到就返回默认值
        System.out.println(map.getOrDefault("行者","武松"));//武松
        //5.使用contains 判定元素是否存在
        //containsKey比较高效,containsValue 比较低效
        System.out.println(map.containsKey("及时雨"));
        System.out.println(map.containsValue("宋江"));

        //6.循环遍历Map,此处的Entry 表示"条目"一个一个的键值对
        //对于Map来说,保存的元素顺序和插入顺序无关
        //Map内部对于元素有自己的规则
        //HashMap:哈希表实现 根据key的hashCode来实现先后顺序
        //TreeMap内部是红黑树 根据key的大小来决定先后顺序
        for (Map.Entry<String,String>entry:map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        //7.clear清空所有元素
        map.clear();
        System.out.println(map.size());
    }
}
