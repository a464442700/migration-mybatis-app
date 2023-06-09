package com.lxf.util;


import com.lxf.dao.DependenciesDaoImpl;
import com.lxf.dao.SourceCodeDaoImpl;

import java.util.*;

public class BFS {
    public BFS() {
    }

    public AdjacencyListGraph<Node> getGraph() {
        return graph;
    }

    public BFS(Node startNode) {
        this.startNode = startNode;
        this.queue = new LinkedList<Node>();
        this.set = new HashSet<Node>();
        this.graph=new AdjacencyListGraph<Node>();
        this.init();
    }

    private AdjacencyListGraph<Node> graph;
    private Node startNode;//广度优先搜索起点
    private Queue<Node> queue;//辅助队列
    private Set<Node> set;//访问标记集合，防止带环图无限循环

    public Stack<Node> getStack() {
        return this.stack;
    }

    public Set<Node> getSet() {
        return this.set;
    }

    private Stack<Node> stack = new Stack<Node>();//访问一个节点入栈，这样从栈弹出顺序就是编译顺序



    //该节点是否被访问
    public boolean isVisited(Node node) {
//        System.out.print(node);
//        System.out.print(node.hashCode());
//        System.out.print(node.getClass());
//        System.out.print(this.set);
//        System.out.println(this.set.contains(node));
        return this.set.contains(node);

    }

    private void setSourceCode(Node node){
        SourceCodeDaoImpl s=new SourceCodeDaoImpl();
        s.getSourcode(node);
        s.getSourcodeHash(node);
    }

    //设置访问标签
    public void visited(Node node) {
        this.set.add(node);//写入集合
        this.stack.add(node);//入栈，作用是从栈弹出的一定是level最高的
        this.graph.addVertex(node);
        this.setSourceCode(node);
    }

    //初始化
    private void init() {


    }

    private ArrayList<Node> getNeighbors(Node node) {
        DependenciesDaoImpl d = new DependenciesDaoImpl();
        ArrayList<Node> nodes = d.findAllNeighborNode(node);
        return nodes;
    }


    public void Traverse() {
        Node  v = this.startNode;//起始节点
        this.visited(v);//设置访问标记
        this.queue.add(v);//访问后入队
        while (!this.queue.isEmpty()) {
            v = this.queue.poll();//出队
            //开始访问所有v的子节点
            for (Node u : this.getNeighbors(v)) {
                this.graph.addSide(v,u);

                if (!this.isVisited(u)) {
                    this.visited(u);//访问
                    this.queue.add(u);//入队
                }
            }


        }

    }

    public static void main(String[] args) {

    }
}

//react-force-graph
//https://potoyang.gitbook.io/spring-in-action-v5/