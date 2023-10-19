package NetWorkCook.com.vince;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 处理单一客户端的服务端
 */
public class EchoServerDemo {
    public static void main(String[] args) {
        // 创建一个服务器端的socket（1024-65535）
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("服务器已启动，正在等待链接。。。");
            // 等待客户端链接，造成阻塞。如果有客户端链接成功，立即返回一个socket对象
            Socket socket = server.accept();
            System.out.println("客户端连接成功！"+server.getInetAddress().getAddress());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 通过输入流来读取网络数据,如果没有数据，那么会造成阻塞
            String info = br.readLine();
            System.out.println(info);
            // 获取输出流，向客户端返回消息
            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            ps.println("echo:"+info);
            ps.flush();
            // 关闭
            ps.close();
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
