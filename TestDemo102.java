/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo102
 * @Author: LENOVO
 * Date: 2020/6/3 16:47
 * project name: 20200529
 * @Version:
 * @Description: 归并排序
 */

import java.util.Arrays;

/**
 * 重要特点 可以适用于外部排序 也可以适用于链表排序 前面的排序依赖随机访问能力(下标) 不适合给链表排序
 * 数据存在磁盘上就是外部 前面的都是内存上
 *
 * 基本思路
 * 两个有序链表/数组合并成一个
 *
 * 某个区间只有一个元素,这个区间一定是有序区间
 * 归并也需要递归
 *
 * 归并的前提是两个待归并区间都是有序的
 *
 * 性能分析
 * 时间复杂度 O(LogN) 每次都在/2
 * 空间复杂度:O(N)(output占用空间)+O(logN)(递归占用空间)
 * 针对链表归并的空间复杂度是O(1)
 * 稳定排序
 */
public class TestDemo102 {
    //[low,mid)有序区间
    //[mid,high)有序区间
    //把两个有序区间合并成一个有序区间
    public static void merge(int[] array,int low,int mid,int high){
        int[] output=new int[high-low];
        int outputIndex=0;//记录当前output数组中放入多少个元素
        int cur1=low;
        int cur2=mid;

        while(cur1<mid&&cur2<high){
            //以下的要是小于等于才能保证稳定
            if(array[cur1]<=array[cur2]){
                output[outputIndex]=array[cur1];
                outputIndex++;
                cur1++;
            }else{
                output[outputIndex]=array[cur2];
                outputIndex++;
                cur2++;
            }
        }
        //上述循环结束,cur1/cur2有一个先到达末尾,另一个还剩一些内容,剩下的全部拷贝output中
        while(cur1<mid){
            output[outputIndex]=array[cur1];
            outputIndex++;
            cur1++;
        }
        while(cur2<high){
            output[outputIndex]=array[cur2];
            outputIndex++;
            cur2++;
        }
        //output中的元素再搬运回原来的数组
        for(int i=0;i<high-low;i++){
            array[low+i]=output[i];
        }
    }
    public  static void mergeSort(int[] array){
        mergeSortHelper(array,0,array.length);
    }
    //[low,high)前闭后开区间,两者差值小于等于1,区间中就只有0个元素或者1个元素
    private static void mergeSortHelper(int[] array, int low, int high) {
        if(high-low<=1){
            return;
        }
        int mid=(low+high)/2;
        mergeSortHelper(array,low,mid);
        mergeSortHelper(array,mid,high);
        //左右区间归并排序完就有序,就可以进行合并了
        merge(array,low,mid,high);
    }

    public static void main(String[] args) {
        int[] array={10,5,2,7,3,6,8,9};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
