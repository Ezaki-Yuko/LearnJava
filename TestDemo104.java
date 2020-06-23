/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo104
 * @Author: LENOVO
 * Date: 2020/6/3 19:11
 * project name: 20200603
 * @Version:
 * @Description:
 */

/**
 * 深度优先 广度优先都是查找顺序
 *
 * 二叉树里深度优先就是叶子节点方向(前中后)
 * 广度优先就是往兄弟节点方法找(层序)
 *
 * 排序
 * 七种
 * 插入排序:类似于顺序表插入 每次把待排序区间的元素往已排序区间的合适位置进行插入,需要搬运元素
 * O(N^2) O(1)稳定
 * 希尔排序:插入排序的改进版本 分组进行插入排序 依赖了插排的两个重要特性
 * 数据量少和序列基本有序的时候插排速度快 分组数目多的时候每组序列中元素较少,分组数目少的时候,每组元素已经接近有序
 * O(N^1.3) O(1) 不稳定
 * 选择排序: 每次排序从待排序区间中选出一个最小值,放到已排序区间末尾,通过比较打擂台的方式,找到最小值
 * O(N^2) O(1) 不稳定
 * 堆排序 每次从待排序区间中选出一个最大值,放到已排序区间开始位置,通过堆的方式找到最大值
 * O(NlogN) O(1) 不稳定
 * 冒泡排序:每次从待排序区间中选出一个最小值,放到已排序区间末尾,通过比较相邻元素并交换的方式,找到最小值
 * O(n^2) O(1) 稳定排序
 * 快速排序:基于递归的方式(分治) 取一个基准值,将当前区间整理成左侧元素小于等于基准值,右侧元素大于等于基准值,再递归处理左侧区间和右侧区间,过程和刚才的整理是一样的
 * 具体的整理过程有很多种实现方式,最简单的就是左右各搞一个下标,先取最后一个元素为基准值,从左往右找到一个比基准值大的元素,往左也找到一个比基准值小的元素,交换两个元素,重复刚才的过程直到两个下标重合
 * 如果是左侧元素为基准值,就从右往左找小于基准值的元素,再从左往右找大于基准值的元素
 * 最坏O(N^2)(数组是逆序的时候)平均 O(N logN)
 * 空间复杂度 最坏O(N)(逆序递归深度更深了) 平均O(logN) 不稳定排序
 * 快排的优化 ① 3数取中基准值 ②递归到一定程度,当前待排序区间元素不多 就可以直接使用插排 ③递归深度达到一定程度,可以针对当前比较大的待排序区间进行堆排序
 * 归并排序:基于递归的方式 把待排序的区间分成均等的两份 如果这个区间是有序区间 就可以按照把两个有序数组合并成一个的套路进行合并了(依赖临时空间) 如果当前分出的区间不是有序的,继续递归往下分割,如果当前区间中只有一个元素就一定是有序的
 * 时间复杂度 O(NlogN)
 * 空间复杂度 O(N)
 * 稳定排序
 * 归并排序适合进行针对链表进行排序也适合外部排序
 */

/**
 * 比较相等
 * 对象的比较
 * 比较身份 ==
 * 比较值 equals(通过用户手动重写才能按照值比较)
 * 比较类型 instanceof
 */

import java.util.Comparator;

/**
 * 比较大小
 * 耦合性更强 是不愿意看到的
 * 使用comparable的时候,你必须要比较的类实现Comparable接口(修改这个类的代码)
 * 使用comparator的时候,你必须重新创建一个新的类实现Comparator接口,不需要修改比较类的代码
 * TreeMap 要求key能比较大小
 * HashMap 要求key能比较相等即可
 */
//不写泛型参数也可以,只不过在重写CompareTo方法时参数是Object类型,需要我们进行instanceof的比较
//加上泛型参数就会方便很多 类型转换工作由编译器自己完成,不需要我们手动添加
//使用Comparable接口的时候最好指定泛型参数,编译器自动完成类型校验工作
//如果不写泛型参数默认的compareTo方法的参数类型就是Object类型,需要手动进行类型转换
class Card implements Comparable<Card>{
    public String rank;//点数
    public String suit;//花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        //如果认为this比o小,返回<0
        //如果认为this比o大,返回>0
        //如果相等返回0
        if(o==null){
            //认为null比较小
            return 1;
        }
        //点数的取值:2-10 J Q K A
        int rank1=this.getValue();
        int rank2=o.getValue();
        return rank1-rank2;
    }
    public int getValue(){
        //把String类型的rank变成数字点数
        int value=0;
        if ("J".equals(rank)){
            value=11;
        }else if("K".equals(rank)){
            value=13;
        }else if("A".equals(rank)){
            value=14;
        }else{
            //字符串转成整数
            value=Integer.parseInt(rank);
        }
        return value;
    }
    @Override
    public boolean equals(Object obj) {
        //按照值来比较this和object
        //1.自己和自己比较
        if(this==obj){
            return true;
        }
        //2.object为null结果是false
        //this肯定不是null 不然没办法调用equals
        if(obj==null){
            return false;
        }
        //3.当前的object这个类型是不是Card类型
        if(!(obj instanceof Card)){
            return false;
        }
        //4.真正的比较内容
        Card other=(Card)obj;
        return this.rank.equals(other.rank)&&this.suit.equals(other.suit);
    }
}
class CardComparator implements Comparator<Card>{
    @Override
    public int compare(Card o1, Card o2) {
        if(o1==o2){
            return 0;
        }
        if(o1==null){
            return -1;
        }
        if(o2==null){
            return 1;
        }
        int value1=o1.getValue();
        int value2=o2.getValue();
        return value1-value2;
    }
}
public class TestDemo104 {
    public static void main(String[] args) {
        Card p=new Card("3","♠");
        Card q=new Card("3","♠");
        Card o = p;//p和o指向同一个对象
        System.out.println(p==o);//true
        System.out.println(p==q);//两个对象身份不相等
        //当前equals没有手动重写 默认执行的就是Object版本中的equals,比较规则也是在比较身份
        System.out.println("==========");
        System.out.println(p.equals(o));//true
        System.out.println(p.equals(q));//false
        System.out.println("=============");
        System.out.println(p.compareTo(q));
        System.out.println(p.compareTo(o));
        System.out.println("===========");
        CardComparator comparator=new CardComparator();
        System.out.println(comparator.compare(p,q));
    }
    /**
     * 为什么有了Comparable还要有Comparator
     * 实际开发过程中不是所有 类都能修改源码
     * Comparable只能定义一种比较规则,Comparator可以定义多种比较规则
     * contains内部就在调用equals方法
     */
}
