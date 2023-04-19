package com.lxf.dao;

import com.lxf.util.Node;

import java.util.ArrayList;

public interface DependenciesDao {
    ArrayList<Node> findAllNeighborNode(Node node) throws Exception;
}
