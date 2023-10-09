package IODemo;

import java.io.*;
import java.nio.charset.Charset;

/** 字节字符转换流学习
 *  可以将一个字节流转换成字符流，或相反
 *  OutputStreamWriter：可以将输出的字符流转换成字节流的输出形式
 *  InputStreamReader：将输入的字节流转换成字符流的输入形式
 */

public class ChangeStreamDemo {
    private static void write(OutputStream out){
        Writer writer = new OutputStreamWriter(out,Charset.defaultCharset());
        try {
            writer.write("越学越快乐！\r\n");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void read(InputStream in){
        Reader reader = new InputStreamReader(in, Charset.defaultCharset());
        byte [] cs = new byte[1024];
        int len = -1;
        try {
            while ((len = in.read(cs))!= -1) {
                System.out.println(new String(cs, 0, len));
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
            InputStream in = new FileInputStream("C:\\Users\\good boy\\Desktop\\vince.txt");
            read(in);
            OutputStream out = new FileOutputStream("C:\\Users\\good boy\\Desktop\\vince.txt");
            write(out);
    }
}
