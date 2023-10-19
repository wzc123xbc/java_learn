package NetWorkCook.com.vince.Communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ExecutorService es = Executors.newSingleThreadExecutor();
        try {
            Socket socket = new Socket("127.0.0.1",8888);

        System.out.println("服务器连接成功！");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ios = new ObjectInputStream(socket.getInputStream());
        // 向服务端发送登录信息
            System.out.println("请输入名称：");
            String name = input.nextLine();
            Message msg = new Message(name,null,MessageType.TYPE_LOGIN,null);
            oos.writeObject(msg);
            msg = (Message)ios.readObject();
            System.out.println(msg.getInfo()+msg.getFrom());

        // 启动读取消息线程(接收信息)
            es.execute(new ReadInfoThread(ios));
            // 使用主线程来发送消息
            boolean flag = true;
            while(flag){
                msg = new Message();
                System.out.println("To:");
                msg.setTo(input.nextLine());
                msg.setFrom(name);
                msg.setType(MessageType.TYPE_SEND);
                System.out.println("Info:");
                msg.setInfo(input.nextLine());
                oos.writeObject(msg);
            }

        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

/**
 * 读取消息用到的线程
 */
class ReadInfoThread implements Runnable{
    private ObjectInputStream in;
    private boolean flag = true;
    public ReadInfoThread(ObjectInputStream in){
        this.in = in;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void run(){
        try {
            while(flag){
                Message message = (Message) in.readObject();
                System.out.println("["+message.getFrom()+"]对我说："+message.getInfo());
            }
            if(in!=null)
                in.close();
        }catch (ClassNotFoundException e) {
                e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
