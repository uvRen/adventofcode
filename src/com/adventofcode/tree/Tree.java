package com.adventofcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.adventofcode.util.Pair;

public class Tree {

    private TreeNode root;
    private List<TreeNode> nodes;
    
    public Tree() {
        nodes = new ArrayList<TreeNode>();
    }
    
    public TreeNode getRoot() {
        return this.root;
    }
    
    public TreeNode findUnbalancedNodeFromTop() {
        TreeNode root = this.root;
        List<Integer> weights = new ArrayList<Integer>();
        int index = -1;
        while(true) {
            for(TreeNode node : root.getChildren()) {
                weights.add(node.sumOfAllChild());
            }
            // Set root to be that node that had wrong weight
            index = findIndexOfNodeWithWrongWeight(weights);
            
            weights.clear();
            
            if(index == -1) {
                return root;
            }
            root = root.getChildren().get(index);
        }
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
    
    private int findIndexOfNodeWithWrongWeight(List<Integer> weights) {
        // Add all unique values to list
        List<Pair> values = new ArrayList<Pair>();
        for(Integer i : weights) {
            Pair p = new Pair("" + i);
            if(!values.contains(p))
                values.add(p);
            else {
                values.get(values.indexOf(p)).increaseCount();
            }
        }
        
        // Find the weight that was wrong
        Pair wrong = null;
        if(values.size() > 0) {
            for(Pair p : values) {
                if(p.getCount() == 1)
                    wrong = p;
            }
            
            // We have reach a node where all nodes has equal weight
            if(wrong == null)
                return -1;
            
            // Find out which index the child has that has the wrong weight
            for(int i = 0; i < weights.size(); i++) {
                if(weights.get(i) == Integer.parseInt(wrong.getChar())) {
                    return i;
                }
            }
        }
        return -1;
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
