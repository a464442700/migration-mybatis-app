package file;

import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWriterTest {
    public static void main(String[] args) {
       // 文件名


        Date date = new Date();
        // 设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String fileName = "output/DUPDB"+'/'+sdf.format(date).toString();
        System.out.println(fileName);
        // 格式化日期对象，并输出结果
        Path path = Paths.get(fileName).toAbsolutePath();  // 获取绝对路径
        File folder = new File(path.toString());
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Folder created successfully.");
            } else {
                System.out.println("Failed to create folder.");
            }
        } else {
            System.out.println("Folder already exists.");
        }
//        try {
//            FileWriter fileWriter = new FileWriter(path.toString(), true);  // 以追加方式创建 FileWriter 对象
//            // ... 具体的写入操作 ...
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}