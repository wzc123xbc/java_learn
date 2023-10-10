package IODemo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/** 字符串流
 *  需求：计算字符串中出现多少个单词
 *  作用：
 *      再WEB开发中，我们经常需要从服务器上获取数据，数据的返回格式通过是一个字符串，我们需要把这个字符串构造成一个字符流
 *      然后再用第三方的数据解析器来解析数据
 *  StringWriter
 */
public class StringStreamDemo {
    private static void stringReader(){
        String info = "good good study day day up";
        StringReader sr = new StringReader(info);
        // 流的标记器
        StreamTokenizer st = new StreamTokenizer(sr);
        int count =0;
        while(st.ttype!=StreamTokenizer.TT_EOF){
            try {
                if (st.nextToken() == StreamTokenizer.TT_WORD) {
                    count++;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            sr.close();
            System.out.println("count="+count);
        }
    }
    public static void main(String[] args) {
        stringReader();
    }
}
