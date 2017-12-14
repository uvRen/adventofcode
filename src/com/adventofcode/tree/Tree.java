package com.adventofcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private TreeNode root;
    private List<TreeNode> nodes;
    
    public Tree() {
        nodes = new ArrayList<TreeNode>();
    }
    
    public TreeNode getRoot() {
        return this.root;
    }
    
    public void buildTree(List<String> data) {
        addAllNodesToList(data);
        TreeNode node = null;
        TreeNode childNode = null;
        String name = "";
        
        for(String row : data) {
            name = row.substring(0, row.indexOf(" "));
            // TreeNode has children
            if(row.indexOf("->") != -1) {
                node = findTreeNodeByName(name);
                String childrenString = row.substring(row.indexOf("->") + 3);
                String[] children = childrenString.split(",");
                for(int i = 0; i < children.length; i++) {
                    childNode = findTreeNodeByName(children[i].trim());
                    childNode.setParent(node);
                    node.addChild(childNode);
                }
            }
        }
        root = findParent();
    }
    
    public TreeNode findParent() {
        for(TreeNode node : nodes) {
            if(node.getParent() == null)
                return node;
        }
        return null;
    }
    
    private void addAllNodesToList(List<String> data) {
        TreeNode node = null;
        String name = "";
        int weight = 0;
        for(String row : data) {
            name = row.substring(0, row.indexOf(" "));
            weight = Integer.parseInt(row.substring(row.indexOf("(") + 1, row.indexOf(")")));
            node = new TreeNode(name, weight);
            nodes.add(node);
        }
    }
    
    private TreeNode findTreeNodeByName(String name) {
        for(TreeNode node : nodes) {
            if(node.getName().equals(name))
                return node;
        }
        return null;
    }

    
}
