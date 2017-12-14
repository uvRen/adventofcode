package com.adventofcode.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private TreeNode parent;
    private String name;
    private List<TreeNode> children;
    private int weight;
    private boolean endNode;
    
    public TreeNode() {
        this.parent = null;
        this.name = "";
        this.children = new ArrayList<TreeNode>();
        this.weight = 0;
        this.endNode = false;
    }
    
    public TreeNode(String name, int weight) {
        this.parent = null;
        this.name = name;
        this.children = new ArrayList<TreeNode>();
        this.weight = weight;
        this.endNode = false;
    }
    
    public String getName() {
        return this.name;
    }
    
    public TreeNode getParent() {
        return this.parent;
    }
    
    public void setParent(TreeNode node) {
        this.parent = node;
    }
    
    public void addChild(TreeNode child) {
        this.children.add(child);
    }
    
    public boolean isEndNode() {
        return endNode;
    }
    
    public void markAsEndNode() {
        this.endNode = true;
    }
}
