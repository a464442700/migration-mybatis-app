package com.lxf.mapper;

import com.lxf.pojo.DbaObjects;

import java.util.Map;

public interface BFSMapper {
    DbaObjects selectDbaObjects(Map dbaobjMap);
}
