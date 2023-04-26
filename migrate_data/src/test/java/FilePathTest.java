
import java.io.FileWriter;
import java.io.IOException;

public class FilePathTest {
    public static void main(String[] args) {
        String filePath = "src/test/resources/example.txt"; // 文件相对路径
        String content = "Hello, World!"; // 待写入的内容

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
            System.out.println("文件生成成功！");
        } catch (IOException e) {
            System.out.println("文件生成失败！");
            e.printStackTrace();
        }
    }
}