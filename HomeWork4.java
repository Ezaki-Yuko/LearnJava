/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork4
 * @Author: Fan yuxuan
 * Date: 2020/3/17 10:36
 * project name: 20200317
 * @Version:
 * @Description:
 */
public class HomeWork4 {
    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * @param target
     * @return
     */
    public static int Rectcover(int target){
        if(target==1||target==2){
            return target;
        }
        return Rectcover(target-1)+Rectcover(target-2);
    }
    public static int Rectcover2(int target){
        if(target==1||target==2){
            return target;
        }
        int first=1;
        int second=2;
        int result=0;
        int i=3;
        for(i=3;i<=target;i++){
            result=first+second;
            first=second;
            second=result;
        }
        return result;
    }
    public static void main1(String[] args) {
        int n=3;
        int ret=Rectcover2(n);
        System.out.println(ret);
    }
    /**
     * 青蛙跳台阶的循环
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     */
    public static int jumpFloor(int target){
        int sum=1;
        while(target>1){
            sum*=2;
            target--;
        }
        return sum;
    }
    public static void main2(String[] args) {
        int ret=jumpFloor(4);
        System.out.println(ret);
    }

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count=0;
        for(int i=1;i<=32;i++){
            if((n&1)==1){
                count++;
            }
            n=n>>>1;
        }
        return count;
    }
    public int NumberOf(int n) {
        int count=0;
        while(n!=0){
            if((n&1)!=0){
                count++;
            }
            n=n>>>1;
        }
        return count;
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int [] array) {
        int left=0;
        int right=array.length-1;
        if(array==null||array.length==0){
            return 0;
        }
        if(array.length==1){
            return array[0 ];
        }
        int mid=0;
        while(left<right){
            if(right-left==1){
                mid=right;
                break;
            }
            mid=(left+right)/2;
            if(array[mid]>=array[0]){
                left=mid;
            }else {
                right=mid;
            }
        }
        return array[mid];
    }
    public static void main(String[] args) {
        int arr[]={5,5,5,5,5,0};
        int ret=minNumberInRotateArray(arr);
        System.out.println(ret);
    }
}










