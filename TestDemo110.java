/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo110
 * @Author: LENOVO
 * Date: 2020/6/4 21:31
 * project name: 20200603
 * @Version:
 * @Description:
 */
public class TestDemo110 {
    //本质上就是描述了一段要执行的线程的任务
    static class MyRunnable implements  Runnable{
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }
    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnable());
        t.start();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("我是一个新线程");
            }
        };
        Thread t1=new Thread(runnable);
        t1.start();

        Thread t2=new Thread(()->{
            System.out.println("我是一个新线程");
        });
        t2.start();
    }


}
