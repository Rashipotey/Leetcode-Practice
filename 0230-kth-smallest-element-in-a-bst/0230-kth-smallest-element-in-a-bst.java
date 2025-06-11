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
    int count=0, result=-1;
    public int kthSmallest(TreeNode root, int k) {
        findKthSmallest(root, k);
        return result;
    }
    private void findKthSmallest(TreeNode root, int k){
        if(root==null || count>=k) return;
        findKthSmallest(root.left,k);
        count++;
        if(count==k){
            result=root.val;
            return;
        }
        findKthSmallest(root.right,k);
    }
}