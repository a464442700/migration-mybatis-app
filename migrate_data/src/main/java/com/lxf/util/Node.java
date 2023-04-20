package com.lxf.util;

import java.util.Objects;

public class Node {
    public  String owner;//四个只读属性
    public  String objectName;
    public  String objectType;
    private Integer level=0;
    private String database;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Node parentNode) {
        this.level = parentNode.level+1;
    }

    public Node(){}
    public Node(String owner, String objectName, String objectType)
    {
        this.owner = owner;
        this.objectName = objectName;
        this.objectType = objectType;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.owner,  this.objectName,this.objectType  );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // 如果两个对象引用的是同一个实例，返回 true
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) { // 如果传入的对象为空或不是该类的实例，返回 false
            return false;
        }
        // 将 obj 转换为该类的实例类型
        Node node = (Node) obj;

        // 判断该类的两个属性是否相等
        return  Objects.equals(this.owner, node.owner)
               //  && this.owner == node.owner
                &&
                Objects.equals(this.objectName, node.objectName)
               // && this.objectName == node.objectName
                &&
                Objects.equals(this.objectType, node.objectType);
              // && this.objectType == node.objectType;

    }

    @Override
    public String toString() {
        return "Node{" +
                "owner='" + owner + '\'' +
                ", objectName='" + objectName + '\'' +
                ", objectType='" + objectType + '\'' +
                ", level=" + level +
                '}';
    }
}
