package IODemo;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/** 管道流
 *  管道流测试
 *  作用：用于管道数据之间的联系
 *
 */
public class PipedStreamDemo {
    public static void main(String[] args) {
        // 两个管道口
        PipedInputStream pin = new PipedInputStream();
        PipedOutputStream pout = new PipedOutputStream();
        try{
            pin.connect(pout);  // 两个管道进行连接打通
        }catch (IOException e){
            e.printStackTrace();
        }
        // 输入与输出流连接
        ReadTread readTh = new ReadTread(pin);
        WriteTread writeTh = new WriteTread(pout);
        new Thread(readTh).start();         // A线程启动
        new Thread(writeTh).start();        // B线程启动
    }
}

// 读取数据的线程
class ReadTread implements Runnable{
    private PipedInputStream pin;   //输入管道
    ReadTread(PipedInputStream pin){
        this.pin = pin;
    }
    public void run(){
        try{
            byte[] buf = new byte[1024];
            int len = pin.read(buf);    // read阻塞
            String s = new String(buf,0,len);
            System.out.println("读到:"+s);
            pin.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
// 写入数据的线程
class WriteTread implements Runnable{
    private PipedOutputStream pout; // 输出管道
    WriteTread(PipedOutputStream pout){
        this.pout = pout;
    }
    public void run(){
        try{
            pout.write("一个美女...".getBytes());   // 管道输出流
            pout.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
