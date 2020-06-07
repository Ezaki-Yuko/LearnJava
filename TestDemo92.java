/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo92
 * @Author: LENOVO
 * Date: 2020/5/30 18:18
 * project name: 20200529
 * @Version:
 * @Description: 优先队列
 */

import java.util.Arrays;

/**
 * priority 优先级队列
 *
 */
public class TestDemo92 {
    //array看起来是个数组,其实是个堆结构
    private int[] array=new int[100];
    private int size=0;

    public void offer(int x){
        array[size]=x;
        size++;
        //把新加入的元素进行向上调整
        //针对child和parent进行比较,看看是否满足当前堆的条件
        //当前是一个大堆,要求parent的值要比child大,如果parent没有child大,就交换元素
        //进行向上调整直接比较父子,不需要比较左右子树
        shiftUp(array,size-1);
    }
    //size这个参数没用上,确实不需要
    //判定调整完了,只需要和0比较,不需要知道堆多大
    public static void shiftUp(int[] array,int index){
        int child=index;
        int parent=(child-1)/2;
        while(child>0){
            if(array[parent]<array[child]){
                //当前不符合大堆要求
                int temp=array[parent];
                array[parent]=array[child];
                array[child]=temp;
            }else{
                //发现当前父节点比子节点大,说明已经符合堆结构
                break;
            }
            child=parent;
            parent=(child-1)/2;
        }
    }
    public int poll(){
        //下标为0的元素就是队首元素
        //删掉的同时,剩下的结构仍然是个堆
        //直接把数组中的最后一个元素赋值到堆顶元素,同时size--
        //接下来从根节点出发 进行向下调整
        int oldValue=array[0];
        array[0]=array[size-1];
        size--;
        shiftDown(array,size,0);
        return oldValue;
    }
    public int peek(){
        return array[0];
    }
    public static  void  shiftDown(int[] array,int size,int index){
        int parent=index;
        //如果使用数组来表示二叉树,父子节点的下表关系是
        //父节点i 左:2i+1 右: 2i+2;
        //子节点->父节点(i-1)/2
        int child =2*parent+1;
        //parent有没有子节点
        while(child<size){
            //把左右子树中较大的节点找到
            if(child+1<size && array[child+1]>array[child]){
                child=child+1;
            }
            //上述条件之后 child就是左右子树较大的
            //child和parent元素比较
            if(array[child]>array[parent]){
                //交换父子节点
                int temp=array[child];
                array[child]=array[parent];
                array[parent]=temp;
            }else{
                //符合堆要求不调整
                break;
            }
            parent=child;
            child=parent*2+1;
        }
    }
    public  boolean isEmpty(){
        return size==0;
    }
    public static void main(String[] args) {
        TestDemo92 queue=new TestDemo92();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while (!queue.isEmpty()){
            //poll就是有序顺序
            //优先队列 每次poll的元素就是优先级最高/最低的元素取出来
            //poll N次就是堆排序
            int cur=queue.poll();
            System.out.println(cur);
        }
    }
}
