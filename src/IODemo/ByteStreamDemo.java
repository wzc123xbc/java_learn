package IODemo;

import java.io.*;
public class ByteStreamDemo {
    /**
     * 字节流学习
     * 字节输入输出流
     * 输出流：超类OutputStream，对文件的输出流使用子类FileOutputStream
     * 输入流：超类InpputStream，对文件的输入流使用子类FileInputStream
     */
    // 字节输出流
    private static void byteOut(){
        // 0.确定目标文件
        File file = new File("C:\\Users\\good boy\\Desktop\\vince.txt");
        // 1.构建一个文件输出流对象
        try{
            OutputStream out = new FileOutputStream(file,true); // append为true为追加内容
            // 2.输出的内容
            String info =  "wzc学习java啦啦啦!\r\n";
            // 3.把内容写入到文件
                out.write(info.getBytes());
            // 4.关闭流
                out.close();
                System.out.println("write success.");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    // 字节输入流
    private static void byteIn(){
        // 0.确定目标文件
        File file = new File("C:\\Users\\good boy\\Desktop\\vince.txt");
        // 1.构建一个文件输入对象
        try{
            InputStream in = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            StringBuilder buf = new StringBuilder();
            int len = -1;   // 表示每次读取长度
            // 把数据读入到数组中，并返回读取的字节数，当不等于-1时，表示读取到的数据，等于-1表示已读完
            while((len = in.read(bytes))!=-1){
                buf.append(new String(bytes,0,len));
            }
            // 输出内容
            System.out.println(buf);
            // 关闭输入流
            in.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 字符流学习
     * 字符输出流：Writer,对文件的操作使用子类：FileWriter
     * 字符输入流：ReaDer,对文件的操作使用子类：Reader
     * 每次操作的单位是一个字符
     */
    // 字符输出流
    private static void charOut(){
        File file = new File("C:\\Users\\good boy\\Desktop\\vince.txt");
        try {
            Writer out = new FileWriter(file,true);
            out.write("wzc不学java啦！\r\n");
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    // 字符输入流
    private static void charIn(){
        File file = new File("C:\\Users\\good boy\\Desktop\\vince.txt");
        try {
            Reader in = new FileReader(file);
            char[]cs = new char[1];
            int len = -1;
            StringBuilder buf = new StringBuilder();
            while((len=in.read(cs))!=-1){
                buf.append(new String(cs,0,len));
            }
            System.out.println(buf);
            in.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /* 字节流学习 */
        byteOut();
        byteIn();
        /* 字符流学习 */
        charOut();
        charIn();
    }
}
