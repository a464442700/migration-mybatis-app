package com.lxf.mapper;

import com.lxf.dao.DependenciesDao;
import com.lxf.pojo.DbaObjects;

import java.util.List;
import java.util.Map;

public interface BFSMapper {
    DbaObjects selectDbaObjects(Map dbaobjMap);
    List<DbaObjects> selecteAllDependencies(Map dbaobjMap);
}
