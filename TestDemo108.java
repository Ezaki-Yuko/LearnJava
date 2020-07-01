/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo108
 * @Author: LENOVO
 * Date: 2020/6/4 18:46
 * project name: 20200603
 * @Version:
 * @Description:
 */

/**
 * java web 冯诺依曼体系:描述一台计算机的硬件构成
 * 操作系统 搞管理的软件 管理硬件和软件资源 先描述再组织
 *
 * 进程:一个可执行程序运行起来,就可以看作是一个进程
 * 进程也是操作系统分配资源的最小单位
 * 一个进程在内核中都会对应着一个PCB对象
 * 描述了一个进程都有哪些属性 1.进程ID 进程的身份标识 2.一组内存指针指向进程运行时依赖的指令和数据在内存的哪个位置
 * 3.进程的状态:正在运行/休眠
 * 4.进程的优先级:进程优先上CPU执行还是放后面
 * 5.进程的上下文:保存上次进程在CPU执行的进度,以便下次进程上CPU的时候可以继续执行
 * 6.进程的记账信息:记录了进程在CPU上一共执行了多长时间,通过这个时间来限制不要让某个进程霸占CPU太久,导致其他进程无法执行
 * 并行要借助多核CPU
 * 并发是微观串行执行 宏观齐头并进
 * 组织进程的方式是把PCB对象放到双向链表中
 *
 * 抢占式调度方式
 * 操作系统的调度器会非常频繁的进行进程切换
 * 哪怕某个进程某个工作只做了一半,也是随时可能被打断
 *
 * 用户能感知到的动作就是代码在用户态执行
 * 用户感知不到的就相当于代码在内核态执行
 * 内核态的权限是比用户态高很多的 用户态的权限比较小,只能进行一些风险低的操作
 *
 * 进程(process)
 * 线程(thread) tcp Spring
 * 进程是一个工厂 线程就是工厂中的流水线
 * 线程包含在进程中 一个进程中可能会有多个线程 每个线程都有一段自己要执行的逻辑(指令) 每个线程都是一个独立的执行流 同一个进程中的很多线程之间共享了一些资源
 * 所谓的线程可以理解成一种轻量级的进程 是一种实现并发编程的方式(多进程/多线程都可以)
 * 创建一个线程比创建一个进程成本低
 * 销毁一个进程比销毁一个进程成本低
 * 成本低的原因 新创建一个线程不需要给线程分配很多资源
 * 新创建一个进程就需要给这个进程分配较多的资源 大部分资源都是和原来的线程共享的
 * 实际进行并发编程的时候,多线程方式比多进程方式更常见,效率也更高
 * 同一个进程的多个线程之间共享资源共享的主要是两方面:内存资源 但是两个不同进程之间的内存不能共享 打开的文件
 * 也有一些不是共享的资源 上下文/状态/记账信息/优先级 每个线程要独立的参与CPU的调度
 * 内存中有一块特殊的区域 栈 空间是每个线程要独立一份
 *
 * 引入线程:
 * 1.线程比进程轻量,并发编程效率更高
 * 2.线程之间共享的资源多,完成一些操作时更方便
 *
 * 创建一个进程的时候就会随之创建一个线程(主线程)
 * 一个进程被创建出来的同时,至少会随之创建一个线程
 *
 * 进程是操作系统分配资源的最小单位
 * 线程是操作系统进行调度和执行的最小单位=>所谓的操作系统进行进程调度 本质山就是操作系统针对这个进程的若干个线程进行调度
 *
 * 操作系统管理线程:
 * 本质山和管理进程一样 先描述 用PCB描述 再组织 用一个双向链表来组织
 * 内核只认PCB 一个线程和一个PCB对应,一个进程可能和多个PCB对应
 * 内核中把若干个从属同一个进程的线程称为线程组,如果发现某几个PCB的线程组ID是一样的,就可以认为这几个线程从属同一个进程 tgroupid是相同的通过这个识别
 * 这些逻辑是Linux中的
 * 线程比进程轻量 还有一个抢占式问题引入了协程的概念(轻量线程)
 *
 * 一个线程是一个PCB 一个进程是多个PCB
 *
 * 一个进程中进程不是越多越好
 *
 * 并发能力达到上限,继续增加线程不会提高效率,甚至可能反而拖慢效率(线程调度也是有开销的)
 * 一个进程中最多能有多少个线程
 * 1.CPU的个数相关
 * 2.和线程执行的任务的类型也相关
 *   A)CPU密集型 程序一直在执行计算任务
 *   B)IO密集型 程序没咋进行计算,主要进行输入输出操作
 * 假设这个主机有8核CPU
 * 任务又都纯是CPU计算的,此时的线程数目大概8个左右
 * 如果任务是纯IO密集型的,理论上,线程搞多少个都可以
 * 实践中一般需要通过测试的方式找到合适的线程数
 * 对于一个业务比较复杂的服务器程序来说,上面有几十个线程都是常见的现象
 *
 * 多线程程序还是有问题的
 *
 * 线程不安全
 *
 * 一个线程如果抛出异常,并且没有很好的处理这个异常,整个进程就会终止
 *
 * 多线程编程/多进程编程也有,实践中用的不多
 *
 * 多线程的主要目的是并发编程
 * 并发编程实现方式有很多种
 * 多进程 多线程 多协程 actor模型(erlang) CSP模型(go) 时间循环(很多库都支持例如C libevent)
 * java使用多线程 Thread
 */
public class TestDemo108 {
    /**
     * 涉及两个线程 MyThread创建出的线程 main对应的主线程
     * 为了进一步观察确实是两个线程可以借助第三方工具查看进程中的线程情况
     * jdk中内置的jconsole这样的程序
     * Process finished 代表当前进程已经结束了
     * 必须想办法让进程结束的不那么快,看线程信息
     * jvm会自动创建一些线程在进程中
     * 进程的状态 RUNNABLE 就绪状态  线程的调用栈是每个线程单独有的不共享
     *
     * 多线程并发执行和单线程之间
     */
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是一个线程");
            while(true){

            }
        }
    }
    public static void main(String[] args) {
        //创建线程需要使用Thread类 创建一个Thread的实例
        //另一方面还需要给这个线程指定,要执行哪些指令/代码
        //执行指令的方式有很多种,此处先用一种简单的,直接继承Thread类
        //重写Thread类中的run方法
        //Thread对象被创建出来的时候,内核中没有随之产生一个线程(PCB)
        Thread t=new MyThread();
        //执行这个start方法才是真的创建出一个线程
        //此时内核中才随之出现一个PCB,这个PCB就会对应让CPU来执行该线程的代码(上面的run方法就会被执行)
        t.start();

        while(true){

        }
    }

}
