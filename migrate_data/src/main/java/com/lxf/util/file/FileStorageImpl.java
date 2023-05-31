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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private boolean dealFlag = false;

    private String createFilePath(Node node) {
        Date date = new Date();
        // 设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String fileName = "output/" + node.getRootNode().getDatabase() + '/' + "[" + node.getRootNode().getDatabase() + "]"+"[" +
                node.getRootNode().owner + "." +
                node.getRootNode().objectName + "." + node.getRootNode().objectType + "]" +

                sdf.format(date).toString();
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

    private Map<String, Object> getMaxLevel(List<Node> nodes) {
        Node rootNode = null;
        Integer maxLevel = 0;
        for (Node node : nodes) {
            if (node.getLevel().equals(0)) {
                rootNode = node;
            }
            if (node.getLevel() > maxLevel) {
                maxLevel = node.getLevel();
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("maxLevel", maxLevel);
        map.put("rootNode", rootNode);
        return map;
    }

    public void dealNodes(List<Node> nodes) {
        if (!dealFlag) {
            Map<String, Object> map = getMaxLevel(nodes);


            nodes.forEach((node) -> {
                node.setMaxLevel((Integer) map.get("maxLevel"));
                node.setRootNode((Node) map.get("rootNode"));
            });
            dealFlag = true;
        }
    }

    private String getFileName(Node node) {
        String fileName = "[" + StringUtils.leftPad(String.valueOf(node.getMaxLevel() - node.getLevel()), 3, "0") + "]"
                + "[" + node.getDatabase() + "]"
                + "[" + node.objectType + "]"
                + node.owner + "."
                + node.objectName;
        String extension = "sql";
        if (node.objectType.equals("PACKAGE")) {
            extension = "pck";

        }
        return fileName + "." + extension;

        //  [001][DUPDB][PACKAGE]APPS.XXXX.SQL
        //  s

    }

    private void createFile(Node node, String filePath) {
        String filename = filePath + "/" + getFileName(node);

        String content = node.getSourceCode();
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
        String filePath = createFilePath(node);
        createFile(node, filePath);


    }
}
