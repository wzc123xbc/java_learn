package IODemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/** 字节数组流学习
 *  基于内存操作，内部维护着一个字节数组，我们可以利用流的读取机制来处理字符串。无需关闭
 */
public class ArrayStreamDemo {
   private static void byteArray(){
       String s = "123456tgsdczxewrwwdasx@@$23SDFSDFW2EWDASCXS";
        // 需求：将字符串中的字母提取出来
       ByteArrayInputStream bais = new ByteArrayInputStream(s.getBytes());
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
       int curr = -1; // 每次读取的字节
       while((curr=bais.read())!=-1){
           if((curr>=65&&curr<=90)||(curr>=97&&curr<=122)){
               baos.write(curr);
           }
       }
       // 此时无需关闭，因为字节数组流时基于内存的操作流
       System.out.println(baos.toString());
   }
    public static void main(String[] args) {
       byteArray();
    }
}
