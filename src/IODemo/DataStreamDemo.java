package IODemo;

import java.io.*;

/** 数据流学习
 *  数据输入流 DataInputStream
 *    数据输入流允许程序以与机器无关的方式从底层输入流中读取基本的java数据类型。但对于多线程的访问并不一定是安全的。线程安全是可选的，他由此类方法的使用者负责
 *  数据输出流 DataOutputStream
 *    允许应用程序以适当的方式将基本java数据类型写入输入流
 *  案例：实现文件分割合并
 */
public class DataStreamDemo {

    private static void write(){
        File file = new File("C:\\Users\\good boy\\Desktop\\vince.txt");
        try{
            OutputStream out = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(out);
            DataOutputStream dos = new DataOutputStream(bos);
            dos.writeInt(10);    // 写入4个字节
            dos.writeByte(1);    // 写入一个字节
            dos.writeUTF("中"); //
            dos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void read(){
        File file = new File("C:\\Users\\good boy\\Desktop\\vince.txt");
        try{
            InputStream in = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(in);
            DataInputStream dis = new DataInputStream(bis);
            int num = dis.readInt();
            byte b = dis.readByte();
            String s = dis.readUTF();
            System.out.println(num+','+b+','+s);
            dis.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
