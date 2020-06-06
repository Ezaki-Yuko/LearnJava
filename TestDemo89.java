/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo89
 * @Author: LENOVO
 * Date: 2020/5/29 21:04
 * project name: 20200529
 * @Version:
 * @Description:
 */

import java.util.Arrays;

/**
 * 堆/优先级队列
 * 名字叫队列 本质上是特殊二叉树(堆)
 * 队列的几种变化:
 * 1.先进先出
 * 2.带优先级的:按照顺序进 出优先级最高的 如果优先级相同就先进先出
 * 3.带类型的: 不是int string 而是业务上的类型 和具体场景密切相关
 *   (消息队列)入队列按原来顺序入 出队列按类型取队列
 * 4.阻塞队列:线程安全版本的队列 具有一定的特性
 *   队列为空取元素会发生阻塞
 *   队列为满插入元素也会阻塞(多线程)
 * 5.无锁队列:线程安全队列 不用锁就能保证线程安全(CAS)
 *  左右孩子表示法.除此之外也可以使用数组来表示树
 *  使用数组存储这个树的层序遍历结果(需要存储空节点)
 *  背下来:
 *  根据数组下标确定节点之间父子关系
 *  父节点和左子树的关系 左子树的下标=根节点下标*2+1
 *  根节点的下标=(左子树下标-1)/2
 *  父节点和右子树的关系
 *  右子树下标=根节点下标*2+2
 *  根节点下标=(右子树下标-2)/2
 *  一个根节点左右子树下标相邻 根据下标求根节点下标 -1/2不需要区分左右子树
 *  通过数组表示树可能会浪费很多空间 所以之前用链表
 *  对于一种特殊的树,使用数组就不会浪费 完全二叉树
 *  堆(数据结构中的通用概念) (heap) jvm内存区域划分(JVM内存模型 jmm)=>方法区 栈(也是后进先出,但是是一个专有名词) 堆(JVM内存模型中的堆) 程序计数器
 *  操作系统进程地址空间中也有栈和堆的概念 没什么关系
 *  同步和异步 访问IO两种策略
 *  同步和互斥 线程安全处理方式
 *
 *  堆本质上是一个二叉树
 *  1.完全二叉树
 *  2.对于树中的任意节点,满足根节点小于左右子树的值(小堆),满足根节点大于左右子树的值(大堆)
 *  堆就是通过数组的形式来存储
 *
 *  堆最大的用处 快速找到一个数中的最大值 最小值(根节点)
 *  topK问题 K=3 取出前三名分数最高的选手
 *  要找到一个序列前K个最大值,就需要知道这个K个元素构成的集合中最小值是谁)需要用一个最小堆来找到这个最小值
 *  一旦堆中的元素发生改变(插入/删除)都需要调整堆的结构,让堆的规则不被破坏掉
 *  向下调整
 *  先设定根节点为当前节点
 *  找到当前节点的左右子树的值(通过下标来获取到)
 *  比较左右子树的值,找出谁更小,用child标记更小的值
 *  比较child和parent谁大谁小
 *  如果child比parent小,就不符合小堆的规则,进行交换
 *  如果child比parent大,符合小堆的规则,不需要交换,整个调整也就结束了
 *  处理完一个节点之后从当前child出发,循环刚才的过程
 *
 *
 */
public class TestDemo89 {
    //向下调整 左右子树都是堆,才能进行调整
    //借助向下调整,就能把一个数组构建成堆
    //从倒数第一个非叶子节点开始从后往前遍历数组
    // 针对每个位置,依次向下调整
    //上面就是在建堆
    //调整一个堆
    //通过size指定array中那些元素是有效的堆元素
    //index表示从哪个位置的下标开始调整
    public static void shiftDown(int[] array,int size,int index){
        int parent =index;
        int child=2*parent+1;//根据parent下标找到左子树下标
        //时间复杂度O(logN) size固定 child每次*2
        //size是8循环3次 size 16 循环4次 size 32 循环5次
        while(child<size){
            //比较左右子树 找到较小值
            if(child+1<size && array[child+1]<array[child]){
                child=child+1;
            }
            //经过上面的比较 已经不知道child是左还是右
            //只是最小

            //再比较child和parent
            if(array[child]<array[parent]){
                //不符合小堆原则,交换父子节点
                int temp=array[child];
                array[child]=array[parent];
                array[parent]=temp;
            }else{
                //调整完毕,不需要继续
                break;
            }
            //更新parent和child 处理下一层数据
            parent=child;
            child=parent*2+1;
        }

    }
    //建堆
    public static void createHeap(int[] array,int size){
        //size-1是最后一个叶子节点 -1/2是找父节点
        //size-1也可以 只不过更冗余,最后一个节点开始
        //看起来是O(N*logN) 实际上是O(N) 循环到一定程度就不用调整了(break)

        for(int i=(size-1-1)/2;i>=0;i--){
            shiftDown(array,size,i);
        }
    }

    public static void main(String[] args) {
        int [] array={9,5,2,7,3,6,8};
        createHeap(array,7);
        System.out.println(Arrays.toString(array));

    }
}
