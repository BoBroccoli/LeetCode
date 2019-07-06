package com.bobroccoli.linkedlist;
//same to 133 leetcode, use hashmap to copy linked things!!!!
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
public class CloneGraph133 {
	public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        if(node == null)
            return null;
        Node origin = node, constructor = new Node();
        Node res = constructor;
        helper(origin, constructor, map);
        return res;        
    }
    public void helper(Node origin, Node constructor, Map<Node, Node> map){
        constructor.val = origin.val;
        map.put(origin, constructor);
        constructor.neighbors = new ArrayList<Node>();
        for(Node listNode : origin.neighbors){
            if(map.containsKey(listNode)){
                constructor.neighbors.add(map.get(listNode));
            }
            else{
                Node newNode = new Node();
                newNode.val = listNode.val;
                map.put(listNode, newNode);
                constructor.neighbors.add(newNode);
                helper(listNode, newNode, map);
            }
        }
    }
}
