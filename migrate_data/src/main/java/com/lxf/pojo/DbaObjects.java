package com.lxf.pojo;

public class DbaObjects {
    private String owner;
    private String objectName;
    private String objectType;
    private Integer objectId;

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setobjectType(String objectType) {
        this.objectType = objectType;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getobjectType() {
        return objectType;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "DbaObjects{" +
                "owner='" + owner + '\'' +
                ", objectName='" + objectName + '\'' +
                ", objectType='" + objectType + '\'' +
                ", objectId=" + objectId +
                '}';
    }
}
