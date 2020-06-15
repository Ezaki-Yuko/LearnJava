/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo99
 * @Author: LENOVO
 * Date: 2020/6/2 12:08
 * project name: 20200529
 * @Version:
 * @Description:
 */

/**
 * 1.插入排序:每次取待排序的第一个元素,往前面的有序区间中插入,和顺序表插入元素类似 O(N^2) O(1) 稳定排序
 * 2.希尔排序:分成多组 分别进行插排,进一步减少分的组数,再次插排,插入排序元素个数少的时候或者元素基本有序的时候效率比较高 O(N^1.3) O(1) 不稳定排序
 * 3.选择排序:每次从待排序区间中找到一个最小值,放在已排序区间末尾,找最小值的方式基于打擂台的方式 O(N^2) O(1) 不稳定排序
 * 4.堆排序:每次从待排序区间找一个最小值,放到已排序区间末尾 或者每次从待排序区间中找到一个最大值,放到已排序区间最前面
 * 找最大值的方式基于堆O(N*logN) O(1) 不稳定排序
 * 5.冒泡排序:每次从待排序区间找一个最小值,放在已排序区间末尾;或者每次从待排序区间找到一个最大值,放在已排序区间最前面
 * 通过比较交换相邻元素的方式 O(N^2) O(1) 稳定排序
 * 6.快速排序  递归
 *   1.在待排序区间中,找到一个基准值(取区间的第一个元素/最后一个元素)
 *   2.以基准值为中心,把整个区间整理成三个部分:左侧部分的元素都小于等于基准值 右侧部分都大于等于基准值
 *   3.再次针对左侧整理好的区间和右侧整理好的区间,进一步递归,重复刚才的整理过程
 *   如果取最左侧为基准值 先从右往左找,再从左往右找
 *   快速排序的效率和基准值取的好坏密切相关,基准值是一个接近中位数的元素,划分出的左右区间比较均衡
 *   此时效率就比较高,如果当前取到的基准值是最大或者最小值,此时划分不均衡,效率就比较低
 *
 *   如果数组正好反序,快排就变慢排
 *   效率最低的时间复杂度O(N^2)
 *   快速排序平均时间复杂度O(N*logN)
 *   一般很少出现最坏情况
 *   空间复杂度主要在递归这里
 *   和递归深度有关
 *   平均的递归深度logN
 *   最坏的递归深度是N 基准值恰好是最大/最小值
 *   稳定性 不稳定排序
 *
 *   假设取左侧元素为基准值,并且先从左找最终交换基准值和重合位置元素的时候破坏快排要求
 *   如果先从左往右再从右往右,left和right重合位置的元素一定大于基准值
 *   如果先从右往左找,再从左往右找,left和right重合位置的元素一定小于等于基准值
 *
 */
public class TestDemo99  {
    public static void quickSort(int[] array){
        //辅助完成递归过程
        //此处为了代码简单 区间设定成前闭后闭
        quickSortHelper(array,0,array.length-1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left>=right){
            //区间有一个或者0个元素,此时不需要排序
            return;
        }
        //针对[left,right]进行整理
        //index 返回值就是整理完毕后left和right的重合位置,知道这个位置才能继续进行递归
        int index=partition(array,left,right);
        quickSortHelper(array,left,index-1);
        quickSortHelper(array,index+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int i=left;
        int j=right;
        //取最右侧元素为基准值
        int base=array[right];
        while(i<j){
            //从左往右找到比基准值大的元素
            while(i<j&&array[i]<=base){
                i++;
            }
            //上面循环结束是i要么和j重合,要么指向一个大于base的值
            //从右往左找比基准值小的元素,初始情况下 end=right,array[end]和base相等
            //此时要把这个基准值直接跳过,始终保持基准值就在原位
            while(i<j&&array[j]>=base){
                j--;
            }
            //上面的循环结束之后i要么和j重合,要么j就指向一个小于base的值

            //交换ij
            swap(array,i,j);
        }
        //ij重合 重合位置和基准值交换
        //right 是序列中最后一个位置,要求ig重合位置元素大于等于基准值元素,才可以放在最后
        //i++导致重合
        //取决于上次循环中j指向的值,上次循环中j找到一个小于基准值的元素,和一个大于基准值的元素交换了,最终的j大于基准值的元素
        //j--导致重合
        //此时上面的i++的循环退出是因为i位置找到一个比基准值大的元素,此时ji重合最重元素大于等于基准值

        swap(array,i,right);
        return i;
    }
    private static void swap(int[] array,int i,int j ){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    //Debugger调用栈
    //通过调试器打断点分析程序运行的中间结果
    /**
     * 快速排序核心执行过程
     * 1.先针对整个区间进行整理 整理成左侧小于等于基准值,右侧大于等于基准值
     * 2.递归针对左侧区间和右侧区间进行递归整理
     */
}
