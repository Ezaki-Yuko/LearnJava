import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo63
 * @Author: LENOVO
 * Date: 2020/5/8 19:15
 * project name: 20200428
 * @Version:
 * @Description:
 */
public class TestDemo63 {
    //数组中两个元素相同 此时排序后和排序前两个元素的前后相对位置不变
    //插入排序 基于线性表插入元素的方式而演化出来
    //bound=0;[0,bound) [bound,size) 已排序区间和待排序区间
    //bound=0/1都可以
    //把bound位置元素尝试往前已排序区间的合适位置进行插入 保证插入完毕后整体数组仍有序
    public static void insertSort(int[] array) {
        //升序排序为例
        //有序区间 [0,bound)
        //无序区间 [bound,size)
        for(int bound=1;bound<array.length;bound++){
            //处理bound 位置的元素如何往前插
            int temp=array[bound];
            //需要从后往前 bound和bound-1比
            int cur=bound-1;
            for(;cur>=0;cur--){
                //如果这里的条件写成array[cur]>=temp就是不稳定排序
                if(array[cur]>temp){
                    //temp元素还需要往前去找 同时把cur位置的元素往后搬运
                    array[cur+1]=array[cur];
                }else{
                    break;
                }
            }
            array[cur+1]=temp;
        }
    }
    //插入排序性能分析
    //时间复杂度O(N^2) 嵌套if
    //空间复杂度 创建额外的临时变量 O(1) 稳定性 稳定排序
    //如果一个数组本身已经比较小了,此时使用插入排序效率非常高
    //如果一个数组本身已经很接近有序 此时使用插排效率也很高
    public static void main(String[] args) {
        int[] array={9,5,2,7,3,6,8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
    //希尔排序/谢尔排序 Shell排序
    //分组插排 先把整个数组分成若干组 分成的组数称为gap
    //同组中相邻元素下标之差就是gap
    //针对每组数据分别进行插排
    //再针对gap=2重复进行分组插排
    //此时仍然没有彻底完成排序 逐渐提升有序性
    //最后gap=1;进行插排 这里就可以完成最终排序
    //当gap比较大 分的组多 元素个数少 插排效率高
    //当gap小 分组数少 每个组元素多了 此时这个数组已经接近有序了 此时插排效率也很高
    //从数学上证明 希尔排序比插入排序更高 gap序列不能随便乱选
    //理论上通过合理选择合理选择希尔排序中的gap序列 希尔排序的时间复杂度可以达到O(N^1.3)
    //实现希尔排序时候 使用 size/2,size/4,size/8...1希尔序列(O^N)
    //希尔排序是基于插入排序来的 极端情况下 当gap为1时 希尔排序代码和插入排序一样
    public static void shellSort(int [] array){
        //size/2,size/4.....
        int gap=array.length/2;
        while(gap>1){
            insertSortGap(array,gap);
            gap=gap/2;
        }
        //当gap为1的时候 再来一次最终插排
        insertSortGap(array,1);
    }
    //分组情况下 同组相邻元素下标差gap
    public static void insertSortGap(int[] array,int gap){
        //从每组下标[1]开始
        for(int bound=gap;bound<array.length;bound++){
            int temp=array[bound];
            int cur=bound-gap;//bound位置中相邻的前一个元素下标
            for(;cur>=0;cur-=gap){
                if(array[cur]>temp){
                    //进行搬运,把cur位置的元素搬到cur+gap位置
                    array[cur+gap]=array[cur];
                }else{
                    break;
                }
            }
            array[cur+gap]=temp;
        }
    }
}