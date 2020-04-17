/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo45
 * @Author: LENOVO
 * Date: 2020/4/14 20:10
 * project name: 20200414
 * @Version:
 * @Description:
 */
/**
 * 如果通过搬运的方式来实现出队列,效率低O(N)
 * 循环队列
 */
public class TestDemo45 {
    private int[] array=new int[100];
    //[head,tail)初始情况下队列中应该是没有元素的
    private int head=0;
    private int tail=0;
    private int size=0;

    //如果插入成功返回true
    //如果插入失败返回false
    public boolean offer(int value){
        if(size==array.length){
            return false;
        }
        array[tail]=value;
        tail++;
        if(tail>=array.length){
            tail=0;
        }
        //tail=tail%array.length
        size++;
        return true;
    }
    public Integer poll(){
        if(size==0){
            //队列为空,出队列失败
            return null;
        }
        //队列非空,返回head位置的元素,同时head++ 删除该元素
        int ret=array[head];
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

    public static void main(String[] args) {
        TestDemo45 testDemo45=new TestDemo45();
        testDemo45.offer(1);
        testDemo45.offer(2);
        testDemo45.offer(3);
        testDemo45.offer(4);
        while(true){
            Integer cur=testDemo45.poll();
            if(cur==null){
                break;
            }
            System.out.println(cur);
        }
    }
}
/**
 *链表版本的队列:插入元素无上限,效率更低,需要额外的内存空间保存引用地址
 * 数组版本的队列:插入元素有上限,效率更高,不需要额外空间保存引用地址
 * 标准库中的队列Queue基于链表实现的,后面在工作中接触到的很有可能是用数组版本实现的
 */