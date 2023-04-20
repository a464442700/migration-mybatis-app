package com.lxf.mapper;

import com.lxf.dao.DependenciesDao;
import com.lxf.pojo.DbaObjects;
import com.lxf.util.Node;

import java.util.List;
import java.util.Map;

public interface BFSMapper {
    DbaObjects selectDbaObjects(Map map);
    List<DbaObjects> selecteAllDependencies(Map map);
    List<Package> selectPackage(Node node);//直接传node进来，不然每次要转map
    List<Package> selectPackageBody(Node node);
}
