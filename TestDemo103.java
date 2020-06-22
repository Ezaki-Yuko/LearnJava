/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo103
 * @Author: LENOVO
 * Date: 2020/6/3 18:06
 * project name: 20200529
 * @Version:
 * @Description: 非递归实现归并
 */

/**
 * 通过合理的分组方式实现非递归 不需要使用栈
 *
 */
public class TestDemo103 {
    public static void mergeSortByLoop(int[] array){
        //引入一个gap变量进行分组
        //当gap为1,[0] [1]进行合并,[2] [3]进行合并,[4] [5]进行合并..
        //gap为2的时候[0,1]和[2,3]进行合并 [4,5]和[6,7]进行合并
        //当gap为4的时候 [0,1,2,3]和[4,5,6,7]进行合并
        for(int gap=1;gap<array.length;gap*=2){
            //接下来进行具体的分组合并
            //gap:相邻组之间的下标差 每一组的长度
            //下面的循环执行一次,就完成了一次相邻两个组的合并
            for(int i=0;i<array.length;i+=2*gap){
                //当前相邻组
                //[beg,mid)
                //[mid,end)
                //beg=>1
                //mid=>i+gap
                //end=>i+2*gap
                int beg=i;
                int mid=i+gap;
                int end=i+2*gap;
                //防止下标越界
                if(mid>array.length){
                    mid=array.length;
                }
                if(end>array.length){
                    end=array.length;
                }
                merge(array,beg,mid,end);

            }
        }
    }
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
    /**
     * 海量数据排序用归并排序 外部排序最常用的就是归并
     *
     * 计数排序0(N) 空间换时间
     * 睡眠排序 时间复杂度为O(0) 完全不吃CPU
     * 9 创建线程 sleep(9s) 再打印 9
     * 5 创建线程sleep(5s) 再打印 5
     * sleep就是让代码放弃CPU
     *
     * 时间复杂度无穷大的排序算法
     * 无限猴子定理 猴子的数量足够多就可以排对
     */
}
