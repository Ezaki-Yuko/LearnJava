/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo109
 * @Author: LENOVO
 * Date: 2020/6/4 21:04
 * project name: 20200603
 * @Version:
 * @Description:
 */
public class TestDemo109 {
    //定义较大整数中适当插入下划线 不具备任何意义 提高代码可读性
    /**
     * 创建线程的几种代码写法
     * 1.可以去通过显式继承Thread类的方式来实现
     * 2.可以通过匿名内部类的方式继承Thread类
     * 3.显式创建一个类,实现Runnable接口,然后把这个Runnable接口关联到Thread实例上
     * 4.通过匿名内部类实现Runnable接口
     * 5.使用lamda表达式
     * 五种方法没有本质上的区别,核心都是使用Thread类
     * 只不过指定线程执行任务的方式有所差异
     * 通过Runnable和lambda的方式创建线程和继承Thread类相比,代码耦合性更小
     * 在写Runnable和lambda的时候run中没有涉及到Thread相关的内容
     * 很容易把逻辑从多线程剥离,搭配其他并发编程方式执行,也可以改成不并发的方式执行
     * 这是站在操作系统的角度没有区别 细节上站在代码耦合性的角度有点区别
     */
    /**
     * 代码模板 sout就是IDEA自带了一些代码模板 用户也可以自定义模板
     * 主流开发工具都有这个功能
     *
     */
    private static long count=100_0000_0000L;
    public static void main(String[] args) {
        serial();
        concurrency();//7.3s左右


    }

    private static void serial() {
        //串行执行针对两个整数累加一百亿次大概消耗十秒钟
        //获取当前时间戳
        //时间戳:1970/1/1/0/0/0为基准时刻计算当前时刻和基准时刻之间秒数/毫秒数/微秒数之差
        long beg=System.currentTimeMillis();
        int a=0;
        for(long i=0;i<count;i++){
            a++;
        }
        int b=0;
        for(long i=0;i<count;i++){
            b++;
        }
        long end=System.currentTimeMillis();
        System.out.println("time:"+(end-beg)+"ms");
    }
    //线程多了效率会提高,但不一定会成倍的提高,受到的影响的因素可能很多,线程的创建和销毁也是需要时间的
    //线程的调度也是需要时间的
    //单线程的代码编译器更好进行优化
    //执行的任务越复杂,多线程的效果越明显
    private static void concurrency() {
        long beg=System.currentTimeMillis();
        //匿名内部类 创建一个没有名字的类,只知道这个类继承自Thread类
        //{}是这个类的具体代码 同时也会new出这个类的实例
        Thread t1=new Thread() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a++;
                }
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                int b=0;
                for(long i=0;i<count;i++){
                    b++;
                }
            }
        };
        t1.start();
        t2.start();
        try {
            //线程等待,让主线程等待t1 t2执行结束再继续往下执行
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //t1 t2 main都是并发执行的
        //t1.start和t2.start之后,主线程也在执行,下面的end就被计算了
        //正确的做法是保证t1 t2计算完毕再去计算end的时间戳
        long end=System.currentTimeMillis();
        System.out.println("time:"+(end-beg)+"ms");
    }
}
