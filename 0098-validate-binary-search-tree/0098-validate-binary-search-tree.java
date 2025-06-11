/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);
    }
    private boolean isValid(TreeNode root, TreeNode min, TreeNode max){
        if(root==null) return true;
        if(min!=null && min.val>=root.val) return false;
        if(max!=null && max.val<=root.val) return false;
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }
}