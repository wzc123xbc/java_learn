package ThreadDemo.com.vince;

public class ThreadDemo1 {
    /**
     * 可以发现线程一和线程二的执行顺序是随机的
     * 推荐使用线程二的接口实现方式，更加灵活

     *  线程的休眠：
     *    在当前线程的执行中，暂停指定的毫秒数，释放CPU的时间片
     *    具体1取决于系统定时器的调度程序的精度和精确性。线程不会丢失任何显示七的所有权
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start(); // 启动线程1

        // 推荐
        MyRunnable mr = new MyRunnable();
        Thread t2 = new Thread(mr);
        t2.start(); // 启动线程2
    }
}

/**
 *  实现线程的第一种方式，继承Tread类
 */
class MyThread extends Thread{
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+'-'+i);

            // 添加线程休眠！！！
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

/**
 * 实现线程的第二种方式：实现Runnable接口
 */
class MyRunnable implements Runnable{
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+'-'+i);

            // 添加线程休眠！！！
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}