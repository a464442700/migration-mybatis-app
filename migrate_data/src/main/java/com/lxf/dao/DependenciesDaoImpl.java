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
import java.util.*;
import java.util.stream.Stream;

public class DependenciesDaoImpl  implements  DependenciesDao {
    private ArrayList<Node> getNodes(List<DbaObjects> allNeighbors,Node parentNode,String dependence_type) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        for (DbaObjects obj : allNeighbors) {
            Node node = new Node(obj.getOwner(), obj.getObjectName(), obj.getobjectType());
            node.setLevel(parentNode);
            node.setDependence_type(dependence_type);
            nodes.add(node);
        }
        return nodes;
    }
    private ArrayList<Node> getIndexes( BFSMapper mapper,Map dbaobjMap,Node parantNode ){

        List<DbaObjects> Indexes= mapper.selectIndexes(dbaobjMap);
        return getNodes(Indexes,parantNode,"Indirect");

    }

    private ArrayList<Node> getAllNeighborNode( BFSMapper mapper,Map dbaobjMap,Node parantNode ){

        List<DbaObjects> allDirectNeighbors = mapper.selecteDirectDependencies(dbaobjMap);
        return  getNodes(allDirectNeighbors,parantNode,"Direct");

    }


    private ArrayList<Node> getSynonym( BFSMapper mapper,Map dbaobjMap,Node parantNode ){

        List<DbaObjects> allDirectNeighbors = mapper.selectSynonym(dbaobjMap);
        return  getNodes(allDirectNeighbors,parantNode,"Indirect");

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


            ArrayList<Node> allAllNeighborNode=new ArrayList<Node>();


            allAllNeighborNode.addAll(getAllNeighborNode(mapper,dbaobjMap,node));

            if (node.objectType.equals("TABLE")) {
                allAllNeighborNode.addAll(getIndexes(mapper, dbaobjMap, node));
            }
            allAllNeighborNode.addAll(getSynonym(mapper,dbaobjMap,node));

            // sqlSession.close();


              return   allAllNeighborNode;




        } catch (IOException v) {
  return  null;
        }




    }



}