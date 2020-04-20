/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: Review2
 * @Author: LENOVO
 * Date: 2020/4/20 18:23
 * project name: 20200420
 * @Version:
 * @Description:
 */

import java.util.Arrays;

/**
 * 顺序表 能知道我放了几个元素 不能跳着放元素
 * 顺序表的底层是一个数组 但顺序表本身是一种数据结构 也是一种新的类型
 */
public class Review2 {
    public int[] elem;//null
    public int usedSize;//0

    //设置默认容量 不可改变的常量
    public static final int DEFAULT_SIZE=3;
    public Review2() {
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize=0;
    }
    public void add(int pos,int data){
        //判满
        if(isFull()){
            grow();
        }
        //开始挪数据
        if(pos<0||pos>this.usedSize){
            throw new ArrayIndexOutOfBoundsException("插入位置不合法");
        }
        int i=this.usedSize;
        while(pos<i){
            this.elem[i+1]=this.elem[i];
            i--;
        }
        elem[pos]=data;
        this.usedSize++;
    }
    private void grow(){
        //扩容不可能在原来基础上扩容 只能重新申请内存
        this.elem=Arrays.copyOf(this.elem,this.elem.length*2);

    }
    public boolean isFull(){
        if(this.usedSize==this.elem.length){
            return true;
        }
        return false;
    }
    public void display(){
        for(int i=0;i<this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
    }
    //判定是否包含某个元素
    public boolean contains(int toFind){
        if(isEmpty()){
            throw new RuntimeException("顺序表为空");
        }
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    //判空
    public boolean isEmpty(){
        if(this.usedSize==0){
            return true;
        }
        return false;
    }
    //查找某个元素对应的位置
    public int search(int toFind){
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    //如果一个方法只是提供在当前内部使用的话 就可以设置成private
    //获取pos位置的元素
    public int getPos(int pos){
        if(pos<0||pos>this.usedSize-1){
            return -1;
        }
        return this.elem[pos];
    }
    public int size(){
        return this.usedSize;
    }
    public void clear(){
        this.usedSize=0;
    }
    //删除第一次出现的关键字key
    public void remove(int key){
        //找到对应下标
        //调用search方法 看返回值 -1 就不需要删除
        int i=search(key);
        if(i==-1){
            return;
        }
        while(i<this.usedSize-1){
            this.elem[i]=this.elem[i+1];
            i++;
        }
        this.usedSize--;
    }

    /**
     * 在中间/头部插入删除时间复杂度是O(N)
     * @param args
     */
    public static void main(String[] args) {
        Review2 test1=new Review2();
        test1.add(0,10);
        test1.add(1,20);
        test1.add(2,30);
        test1.add(3,40);
        test1.display();
    }


}
