
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        String filename = "output.txt";
        String content = "hello world\nthis is a test.";
        try {
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.flush();  // 刷新缓冲区，将数据真正写入磁盘
            bufferedWriter.close();  // 关闭文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}