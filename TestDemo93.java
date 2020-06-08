import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo93
 * @Author: LENOVO
 * Date: 2020/5/30 20:20
 * project name: 20200529
 * @Version:
 * @Description: 标准库中的优先队列
 */
public class TestDemo93 {
    public static void main(String[] args) {
        //标准库中的优先队列是小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        while(!queue.isEmpty()){
            int cur=queue.poll();
            System.out.println(cur);
        }
    }
}
/**
 * 1.建堆O(N)+O(M*logN)
 * 2.O(M)+O(N*logM)
 * topK问题N>>M
 * 给定N个数字 找出前M大的数字
 * 1.用一个数组保存这个数字,直接在数组上建大堆,循环1000次进行取堆顶和调整
 * 方法1的内存可能放不下 2运行效率也更高
 * 2.先取集合中前1000个元素放在一个数组中,建立一个小堆(堆顶元素就是这个堆最小的),再遍历集合中数字和守门员比较,比守门员大就删掉守门员去入堆调整堆 所有元素遍历完,就是前1000大的
 * 100亿数字=>400亿字节=>8G=>80亿是40G
 * 定时器:工作中经常会用到的一个组件=>本质上就是topK问题.底层原理就是基于堆数据结构
 */
/**
 * 面试题
 * 给定两个以升序排序的整型数组nums1和nums2,以及一个整数K 定义一对值(u,v),其中第一个元素来自nums1,第二个元素来自nums2
 * 找到和最小的K对数字(u1,v1)(uk,vk)
 */
class Pair implements  Comparable<Pair>{
    public int n1;
    public int n2;
    public int sum;

    public Pair(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.sum = n1+n2;
    }

    @Override
    public int compareTo(Pair o) {
        //this比other小返回<0
        //this比other大 返回大于0
        //this和other相等 返回0
        //直接用sum值衡量Pair大小
        return this.sum-o.sum;
    }
}
class Solution{
    //1.获取所有数对
    //2.数对都放在优先队列中
    //3.再从优先队列中取到前K对数对即可
    //需要把数对放在类中 优先队列保存这个类的对象就好
    //[
    //   [1,1],
    //   [1,2]
    //]
    // 返回值的二维数组中,每一行是一个数对(每一行只有两个元素)
    //一共有K行
    public List<List<Integer>> kSmallestPairs(int[] nums1,int[] nums2,int k){
        List<List<Integer>> result = new ArrayList<>();
        if(nums1.length==0||nums2.length==0||k<=0){
            return result;
        }
        //当前是需要前K小的元素 建立小堆 TOPK的第一种解决方式
        //Pair可以放在优先队列中要实现Comparable接口,可以去比较大小
        PriorityQueue<Pair> queue=new PriorityQueue<>();
        //把可能数对获取到加入队列
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                queue.offer(new Pair(nums1[i],nums2[j]));
                /*if(queue.size()>k){
				//利用k限制queue的大小
                //循环结束之后queue中就只剩下三个最大的元素
				//但是题目要求取最小,就直接建一个存放所有元素的小堆,循环去取堆顶 topk的第一种解法 
                    queue.poll();
                }*/
            }
        }
        //循环结束之后,此时所有的数对都在队列中,循环取出k个较小元素即可
        for(int i=0;i<k&&!queue.isEmpty();i++){
            Pair cur=queue.poll();
            List<Integer> temp=new ArrayList<>();
            temp.add(cur.n1);
            temp.add(cur.n2);
            result.add(temp);
        }
        return result;
    }
}