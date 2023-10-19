package NetWorkCook.com.vince;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 处理多个客户端
 *      通过线程池可以同时启动3个线程
 *  主线程用于监听客户端的连接，每次有连接成功，开启了一个线程来处理该客户端的消息
 */
public class MutilServerDemo {
    public static void main(String[] args) {
        // 开辟固定大小的线程池
        ExecutorService es = Executors.newFixedThreadPool(3);
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("服务器已启动，正在等待链接>..");
            while(true){
                Socket s = server.accept();
                System.out.printf(s.getInetAddress().getHostAddress());
                es.execute(new UserThread(s));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

/**
 * 用来处理客户端请求的线程任务
 */
class UserThread implements Runnable{
    private Socket s;
    public UserThread(Socket s){
        this.s = s;
    }
    public void run(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintStream ps = new PrintStream(new BufferedOutputStream(s.getOutputStream()));
            String info = br.readLine();
            System.out.printf(info);
            ps.println("echo:"+info);
            ps.flush();
            ps.close();
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}