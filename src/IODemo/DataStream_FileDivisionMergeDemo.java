package IODemo;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/** 数据流的案例
 *  实现文件的分割和合并
 */
public class DataStream_FileDivisionMergeDemo {
    /**
     * 文件的分割
     * targetFile要分割的文件
     * cutSize 每个文件的大小
     */
    private static void division(File targetFile,long cutSize){
        if(targetFile == null)return;
        // 计算总分割的文件数
        int num = targetFile.length()%cutSize==0?
                (int)(targetFile.length()/cutSize):(int)(targetFile.length()/cutSize+1);
        try {
            // 构造文件输入流
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(targetFile));
            // 构造文件输出流
            BufferedOutputStream out = null;
            // 每次要读取的字节数
            byte[] bytes = null;
            int len = -1;       // 每次实际读取的长度
            int count = 0;      // 每个文件要读取的次数

            // 循环次数为申辰文件的个数
            for(int i=0;i<num;i++){
                out = new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\good boy\\Desktop\\test\\"+(i+1)+"-temp-"+targetFile.getName())));
                // 文件小于1024
                if(cutSize<=1024){
                    bytes = new byte[(int)cutSize];
                    count=1;
                }else{
                    bytes = new byte[1024];
                    count = (int)cutSize/1024;
                }
                // count要放前面 不然会多读一次了
                while(count>0 && (len=in.read(bytes))!=-1){
                    out.write(bytes,0,len);
                    out.flush();    // 清除缓存
                    count--;
                }
                // 单独处理可能多出来的少于1024字节的部分，计算余数来决定是否再读一次
                if(cutSize%1024!=0){
                    bytes = new byte[(int)cutSize%1024];
                    len = in.read(bytes);
                    out.write(bytes,0,len);
                    out.flush();
                    out.close();
                }
            }
            in.close();     // 文件关闭，代表输入结束
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * 文件的合并
     * 通过合并流完成文件的合并
     */
    private static void merge(Enumeration<InputStream> es){
        // 构造一个合并流
        SequenceInputStream sis = new SequenceInputStream(es);
        try {
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream("C:\\Users\\good boy\\Desktop\\test\\(合并版)4K航拍万里长江蜿蜒崎岖自然风光.mp4"));
            byte[] bytes = new byte[1024];
            int len = -1;
            while((len = sis.read(bytes))!=-1){
                bos.write(bytes,0,len);
                bos.flush();
            }
            bos.close();
            sis.close();
            System.out.println("合并完成！");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //File file = new File("C:\\Users\\good boy\\大学生涯规划\\学习\\学习工具类\\视频素材\\视频素材pr\\pr教程\\pr01\\4K航拍万里长江蜿蜒崎岖自然风光.mp4");
        //division(file,1024*1024*20);

        // 将待合并的文件封装成数组，传入合并方法中！
        try{
            InputStream in1 = new FileInputStream((new File("C:\\Users\\good boy\\Desktop\\test\\1-temp-4K航拍万里长江蜿蜒崎岖自然风光.mp4")));
            InputStream in2 = new FileInputStream((new File("C:\\Users\\good boy\\Desktop\\test\\2-temp-4K航拍万里长江蜿蜒崎岖自然风光.mp4")));
            InputStream in3 = new FileInputStream((new File("C:\\Users\\good boy\\Desktop\\test\\3-temp-4K航拍万里长江蜿蜒崎岖自然风光.mp4")));
            InputStream in4 = new FileInputStream((new File("C:\\Users\\good boy\\Desktop\\test\\4-temp-4K航拍万里长江蜿蜒崎岖自然风光.mp4")));

            // 集合工具类，内部实现使用了数组
            Vector<InputStream> v = new Vector<InputStream>();
            v.add(in1);
            v.add(in2);
            v.add(in3);
            v.add(in4);

            Enumeration<InputStream>es = v.elements();
            merge(es);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
