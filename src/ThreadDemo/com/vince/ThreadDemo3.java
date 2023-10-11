package ThreadDemo.com.vince;

/**
 * 守护线程 daemon与 yield
 * 用来让其（这里暂称之为子线程）随着调用它的主线程（这里暂称之为main方法）的结束而结束，
 * 不管该线程任务是否圆满完成，只要调用它的主线程结束了，它（子线程）就跟随着结束。
 # 拿老板和员工举例：
 ~给员工设置了守护线程，就意味着只要老板（主线程）“休假”(工作完成，没事可做了)，员工（子线程）也跟着休假不用上班，无论员工手头的活干完没有；
 ~没给员工设置守护线程，就意味着，即使老板“休假”了，员工依然要在后台继续完成它可能永远都完不成的工作！

 *  其他方法：
 *  t.isAlive()-->测线程活动状态
 *
 */

public class ThreadDemo3 {
    public static void main(String[] args) {
        MyRunnable4 mr4 = new MyRunnable4();
        Thread t = new Thread(mr4);
        // 线程可以分为两种：守护线程和用户线程（非守护），当进程中没有用户线程时，JVM退出
        t.setDaemon(true);  // 把线程设置为守护线程
        t.start();

        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+'-'+i);
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(i==5){
                Thread.yield(); // 让出本次CPU执行的时间片
            }
        }
    }
}

class MyRunnable4 implements Runnable{
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+'-'+i);
            try {
                Thread.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
