package ThreadDemo.com.vince;

/**
 *  join与中断线程
 *  1. join方法的主要作用就是同步，它可以使得线程之间的并行执行变为串行执行
 *     join会抛出中断异常
 *  2. 中断线程
 *  (1) 使用interrupt方法来中断线程：
 *      首先从外部打上一个中断标记：interrupt（）
 *      因为程序中有休眠，会抛出中断异常，并且清楚中断状态异常，所以在休眠异常执行中我们必须重新给线程打上中断标记：Thread.currentThread().interrupt();
 *      最后，测试线程中断状态，在测试过程中把中断状态清除
 * （2）使用自定义标记来控制中断线程（boolean）推荐使用
 *     以上三步略显繁琐。所以建议想要中断线程，使用自定义标记的方法实现会比interrupt方法更加实用
 *
 *
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        MyRunable2 mr2 = new MyRunable2();
        Thread t = new Thread(mr2);
       // t.start();

        MyRunnable3 mr3 = new MyRunnable3();
        Thread t2 = new Thread(mr3);
        t2.start();


        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+'-'+i);
            try{
                Thread.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(i==20){
                try{
                    t.join();   // 让t线程执行完毕，主线成才继续进行
                }catch (InterruptedException e){
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
               // t.interrupt();  // 方法1：中断线程，只是做了一个中断标记，最后还是得看会t线程
                // 方法二：
                mr3.flag = false;

            }
        }
    }
}

class MyRunable2 implements Runnable{
    public void run(){
        for(int i=0;i<50;i++){
            if(Thread.interrupted()){   // 测试中断状态，此方法会把中断状态清除
                break;
            }
            System.out.println(Thread.currentThread().getName()+'-'+i);
            try{
                Thread.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable3 implements Runnable{
    public boolean flag = true;
    public MyRunnable3(){
        flag = true;
    }
    public void run(){
        int i =0;
        while(flag){
            System.out.println(Thread.currentThread().getName()+"-"+(i++));
            try{
                Thread.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
