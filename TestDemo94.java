/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo94
 * @Author: LENOVO
 * Date: 2020/5/30 21:22
 * project name: 20200529
 * @Version:
 * @Description:
 */
/**
 * 复习:堆本质是一个二叉树
 * 完全二叉树
 * 通过数组来表示
 * 对于大堆来说,任意一个值都比子节点的值要大,小堆相反
 *
 * 堆让我们高效找最大/小值 找前K个最大
 *
 * topK典型解法:
 * 1.在100亿个数据上直接建大堆,循环1000次取堆顶
 * 2.建立一个1000个数据小堆,循环遍历100亿个元素和根节点对比,决定是否更新
 *堆基本操作(优先队列)
 * 入队列 (新加入一个元素,向上调整堆)
 * 出队列 (用最后一个元素覆盖堆顶元素,向下调整)
 * 取队首元素 (取堆顶元素)
 *
 * 向上调整
 * 向下调整
 */
/**
 * 七种常见排序
 * 很重要 标准库中有现成的排序方式
 * 排序规则:升序和降序 如果待排序元素比较复杂,就会有更复杂的排序方式(实现Comparable接口可以自定义排序)
 * 稳定性 相对顺序不变
 */
/**
 * 链表 排序 http mysql 多线程 
 */

import java.util.Scanner;

/**
 * 插入排序:基于顺序表插入来实现的
 * [0,bound)已排序区间
 * [bound,size)待排序区间
 * 循环取bound位置的元素,往前面的已排序区间中插入,保证插入之后,已排序区间仍然是有序的
 *
 */
public class TestDemo94 {
    //插排
    //性能分析
    //时间复杂度:O(N^2)
    //空间复杂度:O(1)
    //稳定性: 稳定排序
    //插入排序的特点:
    //1.带排序区间元素比较少 排序效率高
    //2.当整个数组比较接近有序的时候排序效率也很高

    public static void insertSort(int[] array){
        //通过bound划分区间
        //bound从0/1开始都可以
        //[0,bound)已排序区间
        //[bound,size)待排序区间
        //升序排序
        for(int bound=1;bound<array.length;bound++){
            //保存一下待比较的数据
            int v=array[bound];
            int cur=bound-1;
            for(;cur>=0;cur--){
                //这里改成>=v 插入排序就不是稳定排序了
                if(array[cur]>v){
                    array[cur+1]=array[cur];
                }else{
                    //不需要搬运
                    break;
                }
            }
            array[cur+1]=v;
        }
    }
    //希尔排序 进阶版本的插入排序
    //先分组,针对每个组进行插入排序 逐渐缩小小组的个数,最终整个数组接近有序
    //gap把数组分成三组
    //先分组载针对每一组进行插排 比之前的数组有序性提高
    //gap把数组再分成两组 再针对每一组分别进行插入排序 此时比刚才的有序性又提高了
    //gap的一再分组,上面这个完整的数组,再针对这个数组进行插排
    //希尔排序时间复杂度理论上能达到O(N^1.3)
    //设定gap的方式是数学方式
    //常见gap取值是size/2,size/4....1
    public static void shellSort(int[] array){
        int gap=array.length/2;
        while(gap>1){
            //循环分组进行插排
            insertSortGap(array,gap);
            gap=gap/2;
        }
        insertSortGap(array,1);
    }
    //时间复杂度:理论极限是O(N^1.3)
    //如果按照size/2 size/4..1这样的方式设定gap O(N^2)
    //空间复杂度O(1)
    //稳定性:不稳定 分组可能把相同的值分到不同的组中,无法保证相对有序

    public static void insertSortGap(int[] array,int gap){
        //gap换成1,理论上和插排一样
        //先处理第一组的第一个元素和第二个元素,再处理第二组的第一个元素和第二个元素
        //把所有组都处理完毕
        for(int bound=gap;bound<array.length;bound++){
            //保存一下待比较的数据
            int v=array[bound];
            int cur=bound-gap;//找同组中的上一个元素
            //找同组中的相邻元素,同组元素下标差值是gap
            //和当前组的前一个比较
            for(;cur>=0;cur-=gap){
                //这里改成>=v 插入排序就不是稳定排序了
                if(array[cur]>v){
                    array[cur+gap]=array[cur];
                }else{
                    //不需要搬运
                    break;
                }
            }
            array[cur+gap]=v;
        }
    }
    //选择排序
    //打擂台的思想 每次从数组中找到最小值 然后把最小值放在合适的位置
    //[0,bound)已排序区间
    //[bound,size)待排序区间
    //按照打擂台的方式从待排序区间找到一个最小值放到bound位置上
    //时间复杂度O(N^2)
    //空间复杂度O(1)
    //不稳定排序
    public static void selectSort(int[] array){
        for(int bound=0;bound<array.length;bound++){
            //以bound位置元素作为擂主,循环从待排序区间取出元素和擂主进行比较
            //如果打擂成功那么就和擂主交换.
            for(int cur=bound+1;cur<array.length;cur++){
                if(array[cur]<array[bound]){
                    //打擂成功
                    int temp=array[cur];
                    array[cur]=array[bound];
                    array[bound]=temp;
                }
            }
        }
    }
    //堆排序
    //针对数组建堆
    //1.风格 升序排序
    //把数组建立一个小堆,取出最小值,放到另外一个数组中,循环去取堆顶元素,尾插到新数组中(需要额外O(N))
    //把数组建立一个大堆,把堆顶元素和堆的最后一个元素互换,最后一个元素删除,(仍然是数组中的最后一个位置,前面的元素才是一个堆,也是待排序区间)再从堆顶向下调整
    //排升序建大堆,排降序建小堆
    //性能分析:
    //logN和1近似相等
    //时间复杂度O(N*logN) 比希尔排序快
    //空间复杂度O(1)
    //不稳定排序
    private static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    public static void heapSort(int[] array){
        //先建堆
        //建议单独写一个建堆方法
        createHeap(array);
        //循环把堆顶元素交换到最后,并进行调整堆
        //循环次数length-1,堆中只剩一个元素就是有序的
        for(int i=0;i<array.length-1;i++){
            //当前堆的元素个数
            int heapSize=array.length-i;
            //交换堆顶和堆的最后一个元素
            //堆的元素个数在缩水 个数array.length-i
            //堆的最后一个元素下标length-i-1
            //取堆的最后一个元素
            swap(array,0,heapSize-1);
            //交换完成后,堆的长度要缩水,删掉最后一个元素
            heapSize--;
            //把最后一个元素从堆中踢出
            //array.length-i-1
            //[0,array.length-i-1)待排序
            //[array.length-i-1,array.length)已排序
            shiftDown(array,heapSize,0);
        }
    }
    private static void createHeap(int[] array){
        //从最后一个非叶子节点出发向前循环,依次向下调整
        for(int i=(array.length-1-1)/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }
    }
    private static void shiftDown(int[]array,int heapLength,int index){
        //升序排序建立的是大堆,要找左右子树最大的值,再和根节点比较
        int parent=index;
        int child=2*parent+1;
        while(child<heapLength){
            if(child+1<heapLength&&array[child+1]>array[child]){
                child=child+1;
            }
            //child就是左右子树比较大的
            if(array[child]>array[parent]){
                swap(array,child,parent);
            }else{
                break;
            }
            parent=child;
            child=2*parent+1;
        }
    }
    //冒泡排序 核心目标和堆排序/选择排序很像 每次找到一个最大值/最小值 并放到合适位置上
    //相对元素比较交换的方式来找
    //升序排序
    //从前往后遍历比较交换就是每次找最大元素
    //如果从前往后比较遍历交换的话,就是每次找最小
    //时间复杂度:O(N^2)
    //空间复杂度:O(1)
    //稳定性:稳定排序(插入 冒泡稳定)
    //冒泡和选择 一个是相邻元素比较 一个是当前元素和擂主元素比较
    public static void bubbleSort(int[] array){
        //每次找最小的方式来排序(从后往前比较交换)
        for(int bound=0;bound<array.length-1;bound++){
            //[0,bound )已排序
            //[bound,size)待排序
            for(int cur=array.length-1;cur>bound;cur--){
                //此处的cur-1是因为cur的初始值是array.length-1,如果是cur+1就越界
                //此处条件>=也无法保证稳定性
                //理论上可以实现成稳定 但是具体还是取决于代码的实现
                if(array[cur-1]>array[cur]){
                    swap(array,cur-1,cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{};
        int[] arr1={};
        int[] arr2=new int[10];
        arr2[0]=6;
        arr2[1]=9;
    }
}
