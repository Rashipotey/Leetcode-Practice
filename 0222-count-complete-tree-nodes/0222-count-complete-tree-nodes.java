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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int leftH=height(root.left);
        int rightH=height(root.right);
        if(leftH==rightH) return (1<<leftH)+countNodes(root.right);
        else return (1<<rightH)+countNodes(root.left);
    }
    private int height(TreeNode root){
        if(root==null) return 0;
        return Math.max(height(root.left), height(root.right))+1;
    }
}