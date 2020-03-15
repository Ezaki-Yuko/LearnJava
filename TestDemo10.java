/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo10
 * @Author: Fan yuxuan
 * Date: 2020/3/15 14:32
 * project name: 20200315
 * @Version:
 * @Description:
 */

import java.util.Arrays;

/**
 * 数组:一组连续的内存 相同类型的数据
 * 3中打印 for for each Arrays.toString 导入包 java.util.Arrays
 * 内存
 * int[] array=new int[3]
 * int[] array={1,2,3,4,5}
 * int[] array=new int[]{1,2,3,45,6}
 * 引用类型:堆上开辟内存
 * 使用工具类 Arrays.toString();
 * 数组访问:下标 0---array.length-1 越界报异常
 *数组的传值传的是引用  地址   数组的返回值:引用
 *拷贝数组:for System.arraycopy(); Arrays.copyOf(); clone 产生一个对象的副本
 *对于数组当中如果存放的是简单类型:深拷贝
 * 对于数组中如果存放的是引用类型:浅拷贝
 */
public class TestDemo10 {
    public static void main1(String[] args) {
        int[] array={1,2,3,4,5,6,7,8};
        //一般在java当中看到的拷贝[form,to),左闭右开
        int[] ret=Arrays.copyOfRange(array,1,4);
        System.out.println(Arrays.toString(ret));
    }
    public static int maxOfArray(int[] array){
        int max=array[0];
        for(int i=1;i<array.length;i++){
            if(max<array[i]){
                max=array[i];
            }
        }
        return max;
    }

    public static void main2(String[] args) {
        int[] array={1,2,2,4};
        double n=avg(array);
        System.out.println(n);
    }
    public static double avg(int[] array){
        double sum=0.0;
        for (int x:array) {
            sum+=x;
        }
        return sum/array.length;
    }
    public static void main3(String[] args){
        int[] array={1,2,2,4};
        int n=findNum(array,2);
        System.out.println(n);
    }
    public static int findNum(int[] array,int num){
        for (int i = 0; i <array.length ; i++) {
            if(array[i]==num){
                return i;
            }
        }
        return -1;
    }
    //二分查找 折半查找 针对一个有序的数组
    public static void main4(String[] args) {
        int[] array={1,2,3,4,5,6};

        Arrays.sort(array);//对数组进行排序
        //不是顺序的数组可以进行排序
        int ret=binarySearch(array,2);
        System.out.println(ret);

        System.out.println(Arrays.binarySearch(array,8));
    }
    public static int count=0;//成员变量

    public static int binarySearch(int[] array,int num){
        int left=0;
        int right=array.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(num>array[mid]){
                left=mid+1;
            }else if(num<array[mid]){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * Arrays.sort
     * Arrays.binarySearch()
     * Arrays.toString()
     * Arrays.copyOf()
     * @param args
     */
    public static void main5(String[] args) {
        int [] array1={1,2,3,4,5,6,7};
        int [] array2={1,2,3,4,5,6,7};

        //判断里面的内容 true 底层是取出数组里的遍历
        System.out.println(Arrays.equals(array1,array2));
        //判断地址 地址肯定不同 false
        System.out.println(array1==array2);
    }

    //顺序排序
    public static void main6(String[] args) {
        int[] array={1,2,3,41,5,6,7};
        System.out.println(isSort(array));
    }
    public static boolean isSort(int[] array){
        for (int i = 0; i <array.length-1 ; i++) {
            if(array[i]>array[i+1]){
                return false;
            }
        }
        return true;
    }
    //冒泡排序
    public static int[] Sort(int[] arr){
        boolean flg=false;
        for(int j=0;j<arr.length-1;j++){
            //最后一位已经排好 就该排倒数第二位了
            flg=false;
            //不一定一开始就是有序的
            //可能在某一次排序过程中忽然有序的
            for(int i=0;i<arr.length-1-j;i++){
                if(arr[i]>arr[i+1]){
                    int t=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=t;
                    flg=true;
                }
            }
            if(flg==false){
                return arr;
            }

        }
        return arr;
    }

    public static void main7(String[] args) {
        int[] arr1={1,2,4,3,8,9};
        System.out.println(Arrays.toString(Sort(arr1)));
    }

    /**
     * 逆置
     * @param array
     */
    public static void reverse(int[] array){
        int left=0;
        int right=array.length-1;
        while(left<right){
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
    }

    public static void main8(String[] args) {
        int[]arr={1,2,3,4,5,6};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 偶数放前面 奇数放后面
     * @param array
     */
    public static void func(int[] array){
        int left=0;
        int right=array.length-1;
        while(left<right){
            while(left<right&&array[left]%2==0){
                left++;
            }
            while(left<right&&array[right]%2!=0){
                right--;
            }
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;
        }
    }

    public static void main9(String[] args){
        int arr[]={1,9,7,3,8,2,6};
        func(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *二维数组
     */
    public static void main10(String[] args){
        //C语言中必须指定列  java中必须指定行
        //一维 数组的每个元素是个一维数组
        int[][] array1=new int[2][3];
        int[][] array2=new int[][]{{1,2,3},{4,5,6}};

        for(int i=0;i<array2.length;i++){
            for(int j=0;j<array2[i].length;j++){
                System.out.println(array2[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(array2));
    }

    public static void main(String[] args) {
        //不规则二维数组 可以手动指定列数
        int[][] array=new int[2][];
        array[0]=new int []{1,2,3};
        array[1]=new int []{4,5,6,7,8};
    }
}








