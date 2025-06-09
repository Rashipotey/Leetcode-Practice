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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key){
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode succ=getSuccessor(root);
            root.val=succ.val;
            root.right=deleteNode(root.right, succ.val);
        }
        if(root.val>key){
            root.left=deleteNode(root.left, key);
        }else{
            root.right=deleteNode(root.right, key);
        }
        return root;
    }
    private TreeNode getSuccessor(TreeNode root){
        root=root.right;
        while(root!=null && root.left!=null){
            root=root.left;
        }
        return root;
    }
}