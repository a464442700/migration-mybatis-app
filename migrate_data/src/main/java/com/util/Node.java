package com.util;

public class Node {
    public String owner;
    public String objectName;
    public String objecType;
    public Integer objectId;

    public Node(String owner, String objectName, String objecType, Integer objectId)
    {
        this.owner = owner;
        this.objectName = objectName;
        this.objecType = objecType;
        this.objectId = objectId;
    }
}
