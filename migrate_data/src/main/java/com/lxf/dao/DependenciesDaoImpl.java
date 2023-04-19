package com.lxf.dao;

import com.lxf.mapper.BFSMapper;
import com.lxf.pojo.DbaObjects;
import com.lxf.util.Node;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DependenciesDaoImpl  implements  DependenciesDao {
    private ArrayList<Node> getNodes(List<DbaObjects> allNeighbors,Node parentNode) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        for (DbaObjects obj : allNeighbors) {
            Node node = new Node(obj.getOwner(), obj.getObjectName(), obj.getobjectType());
            node.setLevel(parentNode);
            nodes.add(node);
        }
        return nodes;
    }

    @Override
    public ArrayList<Node> findAllNeighborNode(Node node)  {
        String resource = "mybatis-config.xml";

        Map dbaobjMap = new HashMap();
        dbaobjMap.put("owner", node.owner);
        dbaobjMap.put("objectType", node.objectType);
        dbaobjMap.put("objectName", node.objectName);

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            BFSMapper mapper = (BFSMapper) sqlSession.getMapper(BFSMapper.class);

            List<DbaObjects> allNeighbors = mapper.selecteAllDependencies(dbaobjMap);
            sqlSession.close();



            return getNodes(allNeighbors,node);


        } catch (IOException v) {
  return  null;
        }

    }
}