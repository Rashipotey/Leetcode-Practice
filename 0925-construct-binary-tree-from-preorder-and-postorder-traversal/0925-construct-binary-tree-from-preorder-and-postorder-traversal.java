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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n=preorder.length;
        return constructTree(0,n-1,0,preorder,postorder);
    }
    public TreeNode constructTree(int preS,int preE,int postS,int[] preorder,int[] postorder){
        if(preS>preE) return null;
        if(preS==preE) return new TreeNode(preorder[preS]);
        int left=preorder[preS+1];
        int n=1;
        while(postorder[postS+n-1]!=left){
            n++;
        }
        TreeNode root=new TreeNode(preorder[preS]);
        root.left=constructTree(preS+1,preS+n, postS, preorder, postorder);
        root.right=constructTree(preS+n+1,preE,postS+n,preorder,postorder);
        return root;
    }
}