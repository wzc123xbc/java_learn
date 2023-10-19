package ThreadDemo.com.vince;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程共享数据时，会发生线程不安全的情况
 * 使用synchronized 实现线程同步
 * 线程同步是确保多线程共享数据的安全性，同时过多还可能产生死锁，因此务必需求使用同步

 * 实现同步的三种方法
 * （1）使用同步代码块
 * （2）使用同步方法
 * （3）使用Lock（更加灵活）
 * 多线程共享数据会有安全问题，使用同步可以解决安全问题，但同时会牺牲性能，所以同步的代码块要尽量
   保持简短，把不随数据变化的代码块移出
 */
public class ThreadDeom4 {
    public static void main(String[] args) {
        MyRunnable5 mr5 = new MyRunnable5();

        Thread t1 = new Thread(mr5);   // 第一个售票窗口
        Thread t2 = new Thread(mr5);   // 第二个售票窗口
        t1.start();
        t2.start();

    }
}

class MyRunnable5 implements Runnable{
    private int ticket = 10;   // 售票
    private Object obj = new Object();
    public void run(){
        for(int i=0;i<300;i++){
            if(ticket>0) {
                // 线程同步代码块
                synchronized (obj) {
                    ticket--;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("您购买的票剩余" + ticket+ "张");
                }
            }
        }
    }

    // 2.同步方法：
    private synchronized void method(){
        if(ticket>0) {
            // 线程同步
                ticket--;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("您购买的票剩余" + ticket+ "张");
        }
    }
    // 互斥锁：
    ReentrantLock lock = new ReentrantLock();
    // lOCK实现同步
    private  void method2() {
        lock.lock();    // 锁
        try {
            if (ticket > 0) {
                ticket--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("您购买的票剩余" + ticket + "张");
            }
        } finally {
            lock.unlock();
        }
    }
}
