package IODemo;

import java.io.*;

/** 缓存流学习
 * 缓存的目的是为了解决在写入文件操作时，频繁的操作文件所带来的性能降低的问题
 * BufferedOutputStream 内部默认的缓存大小是8KB，每次写入时，先存储到缓存中的byte数组里，当数组存满的时候，会把数组中的数据写入文件中，并且缓存下标归零
 * 缓冲流不可以单独使用
 *
 * 字符流：
 * 1.加入字符缓冲流，增强读取的功能（readLine）
 * 2.更高效的读取内容
 */
public class BufferStreamDemo {
    // 字节输出缓冲流
    private static void byteWriter() {
        File file = new File("C:\\Users\\good boy\\Desktop\\vince.txt");
        try {
            OutputStream out = new FileOutputStream(file);
            // 构造字节缓冲流
            BufferedOutputStream bos = new BufferedOutputStream(out);
            //
            String info = "字节缓冲流学习代码！";
            bos.write(info.getBytes());
            bos.close();            // 关闭流就会把缓存中的数据存到文件中去
            // out.close();
            /** 以下为更高级的写法，可以不用关闭流文件
             *  try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))){
             *      String info = "字节缓冲流学习代码！";
             *      bos.write(info.getBytes());
             *  }
             */
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // 字节输入缓冲流
    private static void byteReader(){
        File file = new File("C:\\Users\\good boy\\Desktop\\vince.txt");
        try {
            InputStream in = new FileInputStream(file);
            // 构建一个字节缓冲流
            BufferedInputStream bis = new BufferedInputStream(in);
            byte[] bytes = new byte[1024];
            int len = -1;
            while((len = bis.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
            bis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // 字符输出缓冲流
    private static void charWriter(){
        File file = new File("C:\\Users\\good boy\\Desktop\\vince.txt");
        try{
            Writer writer = new FileWriter(file);
            BufferedWriter bw =new BufferedWriter(writer);
            bw.write("字符缓冲流学习代码！");
            bw.flush();
            bw.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // 字符输入缓冲流
    private static void charReader(){
        File file = new File("C:\\Users\\good boy\\Desktop\\vince.txt");

        try{
            Reader reader = new FileReader(file);
            // 为字符流提供缓冲，以达到高效读取的目的
            BufferedReader br = new BufferedReader(reader);
            char []cs = new char[1024];
            int len = -1;
            while((len = br.read(cs))!=-1){
                System.out.println(new String(cs,0,len));
            }
            br.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        byteWriter();
        byteReader();
        /*----------*/
        charWriter();
        charReader();

    }
}
