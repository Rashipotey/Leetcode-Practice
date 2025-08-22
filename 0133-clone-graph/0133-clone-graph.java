/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node, Node> map=new HashMap<>();
        return dfs(map, node);
    }
    private Node dfs(Map<Node, Node> map, Node curr){
        if(map.containsKey(curr)) return map.get(curr);
        Node clone=new Node(curr.val);
        map.put(curr,clone);
        for(Node neigh: curr.neighbors){
            clone.neighbors.add(dfs(map,neigh));
        }
        return clone;
    }
}