/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo91
 * @Author: LENOVO
 * Date: 2020/5/30 17:27
 * project name: 20200529
 * @Version:
 * @Description: 堆2
 */

import java.util.Arrays;

/**
 * 向上调整 向下调整就是把一个不满足堆的结构调整成满足堆的结构
 */
public class TestDemo91 {
    //大堆来实现
    //size array中那部分是堆
    //index: 从哪个位置开始进行向下调整
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
    public static void createHeap(int[] array,int size){
        //基于向下调整来建堆
        //建堆可以基于向下调整,也可以基于向上调整
        //如果是向下调整,就从后往前遍历数组
        for(int i=(size-1-1)/2;i>=0;i--){
            shiftDown(array,size,i);
        }
    }
    //借助向上调整构建优先级队列
    public static void main(String[] args) {
        int[] array={9,5,2,7,3,6,8};
        createHeap(array,7);
        System.out.println(Arrays.toString(array));
    }
}
