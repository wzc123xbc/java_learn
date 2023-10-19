package ThreadDemo.com.vince;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 *   是一种预先创建线程的技术，线程池在还没有任务到来之前，创建一定数量的线程，放入到空闲队列中，然后对这些资源进行复用。减少频繁的创建和销毁对象
 *   java里面的线程池的顶级接口是Executor，是一个执行线程的工具
 *   线程池的接口是ExecutorService

 *   newSingleTreadExecutor 创建一个单线程池
 *   newFixedTgreadPool: 创建固定大小的线程池
 *   newCachedTreadPool: 创建一个可缓存的线程池
 *   newScheduledThreadPool：创建一个无线大小的线程池
 */
public class ThreadDemo5 {
    public static void main(String[] args) {
        // 创建线程池（4种）
            //1.创建一个单线程池
        ExecutorService es = Executors.newSingleThreadScheduledExecutor();
        // 不想写！！！
    }
}

class MyRunable6 implements Runnable{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("run--"+i);
        }
    }
}