/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo70
 * @Author: LENOVO
 * Date: 2020/5/11 22:02
 * project name: 20200428
 * @Version:
 * @Description:
 */

/**
 * 数组实现队列 循环队列
 * 入队列把新元素放在tail位置上 同时tail++
 * 出队列的时候取出head位置元素 同时head++ head位置始终是队首元素 tail位置始终是队尾的下一个元素
 * head和tail重合就是空队列 也可能是满队列
 * 队列中的有效元素有两种情况
 * 可以引用size来判断空满
 */
public class TestDemo70 {
    private int[] array=new int[100];
    //[head,tail)有效元素的范围 tail有可能在head之前
    private int head=0;
    private int tail=0;
    private int size=0;//元素个数

    public void offer(int val){
        if(size==array.length){
            //如果队列满了 无法插入
            return;
        }
        //得保证这个操作下标不能越界
        array[tail]=val;
        tail++;
        //tail++之后超出数组有效范围就从头开始
        if(tail >=array.length){
            tail=0;
        }
        size++;
    }
    public Integer poll(){
        if(size==0){
            return null;
        }
        Integer ret=array[head];
        head++;
        if(head>=array.length){
            head=0;
        }
        size--;
        return ret;
    }
    public Integer peek(){
        if(size==0){
            return null;
        }
        return array[head];
    }
}
