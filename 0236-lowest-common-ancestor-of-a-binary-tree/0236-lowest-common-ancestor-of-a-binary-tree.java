/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1=new ArrayList<>();
        List<TreeNode> l2=new ArrayList<>();
        getPath(root, p, l1);
        getPath(root, q, l2);
        int i=0;
        TreeNode comm=null;
        while(i<l1.size() && i<l2.size()){
            if(l1.get(i)==l2.get(i)){
                comm=l1.get(i);
            }
            i++;
        }
        return comm;
    }
    private boolean getPath(TreeNode root, TreeNode target, List<TreeNode> path){
        if(root==null) return false;
        path.add(root);
        if(root==target){
            return true;
        }
        if(getPath(root.left, target, path) || getPath(root.right, target, path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}