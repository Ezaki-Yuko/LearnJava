import java.util.Arrays;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork5
 * @Author: Fan yuxuan
 * Date: 2020/3/18 15:18
 * project name: 20200318
 * @Version:
 * @Description: 牛客和比特作业
 */
public class HomeWork5 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public static void reOrderArray(int [] array) {
        int i=0;
        int j=array.length-1;
        while(i<j){
            while(i<j&&array[i]%2!=0){
                i++;
            }
            while(i<j&&array[j]%2==0){
                j--;
            }
            int temp=array[i];
            array[i]=array[j];
            array[j]=temp;
        }
    }
    public static void reOrderArray1(int [] array) {
        int [] arr1=new int[array.length];
        int count=0;
        int i=0;
        while(i<array.length){
            if(array[i]%2!=0){
                arr1[count]=array[i];
                count++;
            }
            i++;
        }
        i=0;
        while(i<array.length){
            if(array[i]%2==0){
                arr1[count]=array[i];
                count++;
            }
            i++;
        }
        for(i=0;i<array.length;i++){
            array[i]=arr1[i];
        }
    }
    public static void main1(String[] args) {
        int arr[]={8,7,2,5,3,9,7,6,10};
        reOrderArray1(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 求斐波那契数列的第n项。(迭代实现)
     */
    public static int Fib(int n){
        if(n==0||n==1){
            return n;
        }
        return Fib(n-1)+Fib(n-2);
    }
    /**
     * 调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
     */
    public static void reOder(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            while(left<right&&arr[left]%2!=0){
                left++;
            }
            while(left<right&&arr[right]%2==0){
                right--;
            }
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
    }
    /**
     * 青蛙跳台阶问题 一次一阶或两阶
     */
    public static int jumpFloor(int n){
        if(n==1||n==2){
            return n;
        }
        return jumpFloor(n-1)+jumpFloor(n-2);
    }
    /**
     * 青蛙跳台阶问题 一次几阶都可能
     */
    public static int jumpFloorII(int n){
        if(n==1){
            return 1;
        }
        return 2*jumpFloorII(n-1);
    }
    /**
     * 递归求解汉诺塔问题
     */
    public static void move(char pos1,char pos3){
        System.out.print(pos1+"-->"+pos3+" ");
    }
    public static void hanoi(int n,char pos1,char pos2,char pos3){
        if(n==1){
            move(pos1,pos3);
            return;
        }
        hanoi(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanoi(n-1,pos2,pos1,pos3);
    }
    /**
     *写一个递归方法，输入一个非负整数，返回组成它的数字之和
     */
    public static int sum(int n){
        if(n<10){
            return n;
        }
        return n%10+sum(n/10);
    }
    /**
     * 按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
     */
    public static void Print(int n){
        if(n>9){
            Print(n/10);
        }
        System.out.println(n%10);
    }
    /**
     * 递归求 1 + 2 + 3 + ... + 10
     */
    public static int sum2(int n){
        if(n==1){
            return 1;
        }
        return n+sum2(n-1);
    }
    /**
     * 递归求 N 的阶乘
     */
    public static int func(int n){
        if(n==1){
            return 1;
        }
        return n*func(n-1);
    }
}
