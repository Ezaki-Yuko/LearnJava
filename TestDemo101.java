import java.util.Stack;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo101
 * @Author: LENOVO
 * Date: 2020/6/3 15:52
 * project name: 20200529
 * @Version:
 * @Description: 非递归方式实现快速排序
 */
//借助栈模拟递归过程
public class TestDemo101 {
    public static void quickSortByLoop(int[] array){
        //借助栈模拟实现递归过程
        //stack用来存放数组下标 通过下标来表示接下来要处理的区间是啥
        Stack<Integer> stack=new Stack<>();
        //初始情况下先把右侧边界下标入栈,再把左侧边界下标入栈,左右边界仍然构成前闭后闭区间
        stack.push(array.length-1);
        stack.push(0);

        while(!stack.isEmpty()){
            //这个代码元素顺序与push顺序相反
            int left=stack.pop();
            int right=stack.pop();
            if(left>=right){
                //区间只有1个或者0个元素,不需要整理
                continue;
            }
            //通过partition把区间整理成以基准值为中心,左侧小于等于基准值,右侧大于等于基准值的形式
            int index=partition(array,left,right);

            //准备处理下个区间
            //[index+1,right]基准值右侧区间
            stack.push(right);
            stack.push(index+1);
            //基准值左侧区间[left,index-1]
            stack.push(index-1);
            stack.push(left);

        }

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

    /**
     * 快速排序的优化
     * 1.优化基准值的取法 三个元素取中,最左侧元素,中间元素,最右侧元素,取中间值作为基准值,把基准值swap到末尾或开始,为后面的整理动作做铺垫
     * 2.当区间已经比较小,再去递归效率不高,不再继续递归,而是进行插排
     * 3.如果区间特别大,递归深度就会非常深,当递归深度达到一定深度,就把当前区间的排序使用堆排序进行优化
     *
     * 标准库中Collection.sort方法就是优化的
     */
}
