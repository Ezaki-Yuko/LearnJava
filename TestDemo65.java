/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo65
 * @Author: LENOVO
 * Date: 2020/5/10 9:45
 * project name: 20200428
 * @Version:
 * @Description:
 */

import java.util.Map;
import java.util.TreeMap;

/**
 * Set 和Map
 * 1.Map和Sst实现原理
 * 2.掌握Map和Set实现原理
 *   a)二叉搜索树
 *   b)哈希表(重中之重)
 * 纯Key:集合中只包含Key,没有别的信息(相对少见)
 * key-Value 集合中不光包含Key,同时有一些相关信息
 */
class Student{
    public String name;
    public String grade;
    public int age;
    public String school;
    public Student(String name,int age,String grade,String school){
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.school=school;
    }
}

/**
 * 一个Map只能维护一组映射关系
 * 如果有多组映射关系就需要多个Map
 */
public class TestDemo65 {
    public static void main(String[] args) {
        Student s1=new Student("蔡徐坤",20,"大四","陕科大");
        Student s2=new Student("罗志祥",21,"大四","陕科大");
        Student s3=new Student("Lisa",22,"大四","陕科大");
        Map<String,Student>studentMap=new TreeMap<>();
        studentMap.put(s1.name,s1);
        studentMap.put(s2.name,s2);
        studentMap.put(s3.name,s3);
        //只能通过key找value 如果想通过value找key 要么遍历map 或者搞一个其他的map 把我们的k-v反过来
    }

}
