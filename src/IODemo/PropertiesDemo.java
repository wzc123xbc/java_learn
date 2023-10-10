package IODemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  Properties可以用来做配置文件
 *  Properties文件是java中很常用的一种配置文件，文件后缀为“.properties”，属文本文件，文件的内容格式是“键=值”的格式，可以用“#”作为注释，java编程中用到的地方很多，运用配置文件，可以便于java深层次的解耦。
 *  javaweb javaee 开发中通常会用到
 *  为了达到解耦的目的，我们可以用配置文件来储存数据库的连接字符串。
 */
public class PropertiesDemo {
    public static String version = "";
    public static String username = "";
    public static String password = "";
    private static void readConfig(){
        Properties p = new Properties();
        try{
            InputStream inStream = new FileInputStream("config.properties");
            p.load(inStream);   // 加载文件

            // 从propertieees中获取数据
            version = p.getProperty("app.version");
            username = p.getProperty("db.username");
            password = p.getProperty("db.password");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        readConfig();
        System.out.println(PropertiesDemo.version);
        System.out.println(PropertiesDemo.username);
        System.out.println(PropertiesDemo.password);

    }
}
