package com.lxf.mapper;

import com.lxf.dao.DependenciesDao;
import com.lxf.pojo.DbaObjects;
import com.lxf.util.Node;
import org.apache.ibatis.annotations.Param;

import java.sql.Clob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BFSMapper {
    DbaObjects selectDbaObjects(Map map);
    List<DbaObjects> selecteDirectDependencies(Map map);
    List<DbaObjects> selectIndexes(Map map);
    List<DbaObjects> selectSynonym(Map map);
    List<DbaObjects> selectDBlink(Map map);
    List<DbaObjects> selectTrigger(Map map);
    List<Package> selectPackage(Node node);//直接传node进来，不然每次要转map
    List<Package> selectPackageBody(Node node);
    void callGetHashCode(Map map);
    void callGetDDL(Map map);
}
