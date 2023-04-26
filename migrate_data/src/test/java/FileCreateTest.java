
import java.io.File;
public class FileCreateTest {
    public static void main(String[] args) {
        // 获取resources目录的绝对路径
        ClassLoader classLoader = FileCreateTest.class.getClassLoader();
        String resourcePath = classLoader.getResource("").getPath();
        System.out.println("Resource Path: " + resourcePath);
        // 创建目录
        String folderPath = resourcePath + "my_folder";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Folder created successfully.");
            } else {
                System.out.println("Failed to create folder.");
            }
        } else {
            System.out.println("Folder already exists.");
        }
    }




}