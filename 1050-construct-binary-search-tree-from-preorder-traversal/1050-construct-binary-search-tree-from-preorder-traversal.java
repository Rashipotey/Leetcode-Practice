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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode buildTree(int[] preorder, int min, int max){
       if(i>preorder.length-1) return null;
       int val=preorder[i];
       if(val>min && val<max){
            TreeNode root=new TreeNode(preorder[i++]);
            root.left=buildTree(preorder,min,val);
            root.right=buildTree(preorder,val,max);
            return root;
       }
       return null;
    }
}