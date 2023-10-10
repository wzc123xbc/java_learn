package IODemo;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/** 文件的压缩与解压缩
 *  1.ZipOutputStream
 *      实现文件的压缩
 *  2.ZipInputStream
 *      实现文件的解压缩
 */
public class ZipStreamDemo {
    /**
     * 压缩
     */
    private static void compression(String zipFileName, File targetFile) {
        System.out.println("正在压缩中...");
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
            BufferedOutputStream bos = new BufferedOutputStream(out);
            zip(out, targetFile, targetFile.getName(), bos);      //递归写个方法
            bos.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zip(ZipOutputStream zOut, File targetFile, String name, BufferedOutputStream bos) throws IOException {
        // 如果是个目录
        if (targetFile.isDirectory()) {
            File[] files = targetFile.listFiles();
            if (files.length == 0) {    //空文件夹
                zOut.putNextEntry(new ZipEntry(name + "/"));// 处理空目录
            }
            for (File f : files) {
                zip(zOut, f, name + "/" + f.getName(), bos);// 递归处理
            }
        } else {
            zOut.putNextEntry(new ZipEntry(name));
            try {
                FileInputStream in = new FileInputStream(targetFile);
                BufferedInputStream bis = new BufferedInputStream(in);
                byte[] bytes = new byte[1024];
                int len = -1;
                while ((len = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
                bis.close();
                System.out.println("压缩完成...");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 解压
     * targetFileName 解压的目标文件
     * parent 解压的目标目录
     */
    private static void decompression(String targetFileName, String parent) {
        try {
            ZipInputStream zIn = new ZipInputStream(new FileInputStream(targetFileName));
            ZipEntry entry = null;
            File file = null;
            while ((entry = zIn.getNextEntry()) != null && !entry.isDirectory()) {
                file = new File(parent, entry.getName());
                if (!file.exists()) { // 如果文件不存在
                    new File(file.getParent()).mkdirs();//创建此文件的上级目录
                }
                OutputStream out = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(out);
                byte[] bytes = new byte[1024];
                int len = -1;
                while ((len = zIn.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
                bos.close();
                System.out.println(file.getAbsolutePath() + "解压成功！");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        // 压缩过程
        //compression("C:\\Users\\good boy\\Desktop\\test\\zip_test.txt", new File("C:\\Users\\good boy\\Desktop\\test\\zip_test.txt"));
        // 解压过程
        decompression("C:\\Users\\good boy\\Desktop\\test\\zip_test.txt","C:\\Users\\good boy\\Desktop\\test");
    }
}