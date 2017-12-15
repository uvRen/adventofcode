package com.adventofcode.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private TreeNode parent;
    private String name;
    private List<TreeNode> children;
    private int weight;
    
    public TreeNode() {
        this.parent = null;
        this.name = "";
        this.children = new ArrayList<TreeNode>();
        this.weight = 0;
    }
    
    public TreeNode(String name, int weight) {
        this.parent = null;
        this.name = name;
        this.children = new ArrayList<TreeNode>();
        this.weight = weight;
    }
    
    public List<TreeNode> getChildren() {
        return this.children;
    }

    // Recursive function to get the total weight of whole tree
    public int sumOfAllChild() {
        int sum = 0;
        for(TreeNode node : children) {
            sum += node.sumOfAllChild();
        }
        return sum + weight;
    }
    
    public String getName() {
        return this.name;
    }
    
    public TreeNode getParent() {
        return this.parent;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public void setParent(TreeNode node) {
        this.parent = node;
    }
    
    public void addChild(TreeNode child) {
        this.children.add(child);
    }
}
