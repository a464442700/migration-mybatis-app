package com.lxf.util.file;

import com.lxf.util.Node;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
public class FileStorageImpl implements FileStorage {
    //  private String
    private String pathname;

    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }


    private String createFilePath(Node node) {
        Date date = new Date();
        // 设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String fileName = "output/"+node.getDatabase() + '/' + sdf.format(date).toString();
      //  System.out.println(fileName);
        // 格式化日期对象，并输出结果
        Path path = Paths.get(fileName).toAbsolutePath();  // 获取绝对路径
        File folder = new File(path.toString());
        if (!folder.exists()) {
            if (folder.mkdirs()) {
              //  System.out.println(fileName+" created successfully.");
            } else {
             //   System.out.println("Failed to create folder.");
            }
        } else {
            // System.out.println("Folder already exists.");
        }
        return fileName;
    }

    private String  getFileName(Node node){
       String fileName="["+StringUtils.leftPad(String.valueOf(node.getLevel()),3, "0")+"]"
               +"["+node.getDatabase()+"]"
               +"["+node.objectType+"]"
               +node.owner+"."
               +node.objectName;
   String extension="sql";
   if (node.objectType.equals("PACKAGE")){
       extension="pkg";

   }
   return fileName+"."+extension;

      //  [001][DUPDB][PACKAGE]APPS.XXXX.SQL
       //  s

    }

   private void createFile(Node node,String filePath){
       String filename =filePath+"/"+ getFileName(node);

       String content =node.getSourceCode();
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
    @Override
    public void writeToFile(Node node) {
       String filePath= createFilePath(node);
        createFile(node,filePath);


    }
}
