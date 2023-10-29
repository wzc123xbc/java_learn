import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void makeSureParentExist(String fileName) {
        if (fileName == null || fileName.trim().length() == 0) {
            return;
        }
        File file = new File(fileName);
        if (!file.exists() && !file.isDirectory()) {
            file = new File(file.getParent());
            file.mkdirs();
        }
    }

    public static boolean createFile(String fileName) throws IOException{
        makeSureParentExist(fileName);
        File file = new File(fileName);
        if (file.exists()) {
            return true;
        }
        return file.createNewFile();
    }
}
