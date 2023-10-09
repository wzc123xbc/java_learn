package IODemo;

import java.io.*;

/** 打印流学习
 *  很方便地进行输出
 *  字节打印流
 *      在字节输出时，可以增强输出功能
 *  字符打印流
 *
 */
public class PrintStreamDemo {
    private static void bytePrint(){
        try {
            File file = new File("C:\\Users\\good boy\\Desktop\\vince.txt");
            OutputStream out = new FileOutputStream(file);
            // 加缓存流
            BufferedOutputStream bos = new BufferedOutputStream(out);
            // 加打印流：增强打印功能
            PrintStream ps = new PrintStream(bos);
            ps.println("字节打印流学习！");
            ps.close();         // 依然会帮你关闭其他的
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void charPrint(){
        File file = new File("C:\\Users\\good boy\\Desktop\\vince.txt");
        try{
            Writer out = new FileWriter(file);
            // 加缓存
            BufferedWriter bos = new BufferedWriter(out);
            // 加打印
            PrintWriter pw = new PrintWriter(bos);
            pw.println("字符打印流学习代码！");
            pw.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //bytePrint();
        charPrint();
    }
}
