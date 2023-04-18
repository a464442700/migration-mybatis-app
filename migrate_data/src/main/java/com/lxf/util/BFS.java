package com.lxf.util;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {
    public BFS() {
    }
    public BFS(Node startNode) {
        this.startNode = startNode;
        this.init();
    }
    private Node startNode;//广度优先搜索起点
    private Queue<Node> queue = new LinkedList<Node>();//辅助队列
    private Set<Node> set = new HashSet<Node>();//访问集合，防止带环图无限循环
    //该节点是否被访问
    public boolean isVisited(Node node){
       return this.set.contains(node);

    }
    //设置访问标签
    public void setVisited(Node node){

    }


    private void init() {


    }

    public static void Traverse() {


    }

    public static void main(String[] args) {

    }
}
