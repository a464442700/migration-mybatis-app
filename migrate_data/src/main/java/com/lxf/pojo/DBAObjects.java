package com.lxf.pojo;

public class DBAObjects {
    private String owner;
    private String objectName;
    private String objecType;
    private Integer objectId;

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setObjecType(String objecType) {
        this.objecType = objecType;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getObjecType() {
        return objecType;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public String getOwner() {
        return owner;
    }


}
