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
        return getLCA(root,p,q);
    }
    private TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        if(root==p || root==q){
            return root;
        }
        TreeNode leftLCA=getLCA(root.left,p,q);
        TreeNode rightLCA=getLCA(root.right,p,q);
        if(rightLCA==null) return leftLCA;
        if(leftLCA==null) return rightLCA;
        return root;
    }
}