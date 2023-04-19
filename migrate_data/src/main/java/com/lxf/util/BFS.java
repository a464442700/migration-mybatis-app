package com.lxf.util;


import com.lxf.dao.DependenciesDaoImpl;

import java.util.*;

public class BFS {
    public BFS() {
    }

    public BFS(Node startNode) {
        this.startNode = startNode;
        this.init();
    }

    private Node startNode;//广度优先搜索起点
    private Queue<Node> queue = new LinkedList<Node>();//辅助队列
    private Set<Node> set = new HashSet<Node>();//访问标记集合，防止带环图无限循环
    private Stack<Node> stack = new Stack<Node>();//访问一个节点入栈，这样从栈弹出顺序就是编译顺序

    //该节点是否被访问
    public boolean isVisited(Node node) {
        return this.set.contains(node);

    }

    //设置访问标签
    public void visited(Node node) {
        this.set.add(node);
        this.stack.add(node);
    }

    //初始化
    private void init() {


    }
    private getNeighbors(){
        DependenciesDaoImpl d =new DependenciesDaoImpl();
        Node node=new Node("APPS","CUX_TABLE","TABLE");
        ArrayList<Node>  nodes= d.findAllNeighborNode(node);
    }

    public void Traverse() {
        Node v;
        v = this.startNode;//起始节点
        this.visited(v);//设置访问标记
        this.queue.add(v);//访问后入队
        while (!this.queue.isEmpty()) {
            v = this.queue.poll();//出队
            //开始访问所有v的子节点
            vs=

        }

    }

    public static void main(String[] args) {

    }
}

//regraph.js