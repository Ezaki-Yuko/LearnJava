/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo15
 * @Author: LENOVO
 * Date: 2020/3/22 15:18
 * project name: 20200322
 * @Version:
 * @Description: 顺序表和链表
 */

import java.util.Arrays;

/**
 * 线性表(顺序表和链表)物理上不一定连续,逻辑上一定连续
 * 顺序表底层是一个数组,但是顺序表本身是一种数据结构 新的类型
 * 顺序表特性:1.知道我放了几个
 * 2.不能跳着放
 *
 * 类型:字段+方法
 */
public class TestDemo15 {
    private int[] elem;//null
    private int usedSize;//0
    //设置默认容量
    private static final int DEFAULT_SIZE=4;

    public TestDemo15(){
        this.elem=new int[DEFAULT_SIZE];
        this.usedSize=0;
    }
    // 打印顺序表
    public void display() {
        for(int i=0;i<this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
    }
    // 在 pos 位置新增元素
    //1.判断当前顺序表是不是满的 2.挪数据从顺序表的最后一个元素开始往后挪.一直挪到POS位置
    //在usedSize-1的位置开始挪位置,一直到POS位置
    public void add(int pos, int data) {
        if(isFull()){
            //System.out.println("顺序表是满的!");
            //return;
            grow();
        }
        if(pos<0||pos>this.usedSize){
            //System.out.println("pos位置不合法");
            //return;
            //抛出异常也可以
            throw new ArrayIndexOutOfBoundsException("pos位置不合法");
        }
        int i=this.usedSize-1;
        while(i>=pos){
            this.elem[i+1]=this.elem[i];
            i--;
        }
        this.elem[pos]=data;
        this.usedSize+=1;
    }
    //判断是不是满的
    public boolean isFull(){
        if(this.usedSize==this.elem.length){
            return true;
        }
        return false;
    }
    //判断顺序表是否为空
    public boolean isEmpty(){
        if(this.usedSize==0){
            return true;
        }
        return false;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        if (isEmpty()) {
            //System.out.println("顺序表为空!");
            //return false;
            throw new RuntimeException("顺序表为空!");
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        if (isEmpty()) {
            //System.out.println("顺序表为空!");
            //return false;
            throw new RuntimeException("顺序表为空!");
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(isEmpty()){
            throw new RuntimeException("顺序表为空!");
        }
        if(pos<0||pos>this.usedSize){
            throw new ArrayIndexOutOfBoundsException("pos位置不合法");
        }
        return this.elem[pos];
         }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) { }
    //删除第一次出现的关键字key
    public void remove(int key) {
        if(key<0||key>=this.usedSize){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(search(key)==-1){
            return;
        }
        int i=search(key);
        while(i<this.usedSize-1){
            this.elem[i]=this.elem[i+1];
            i++;
        }
        this.usedSize-=1;

    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize; }
    // 清空顺序表
    //置为0
    public void clear() {
        this.usedSize=0;
    }
    //扩容 不可能在原来基础上扩容
    private void grow(){
        this.elem=Arrays.copyOf(this.elem,this.elem.length*2);
    }

}
