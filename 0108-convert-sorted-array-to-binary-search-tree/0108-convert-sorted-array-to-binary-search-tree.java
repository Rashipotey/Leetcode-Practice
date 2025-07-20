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
    public TreeNode sortedArrayToBST(int[] nums) {
        return insert(nums,0,nums.length);
    }
    private TreeNode insert(int[]nums, int i, int n){
        if(i==n) return null;
        int m=i+(n-i)/2;
        TreeNode node=new TreeNode(nums[m]);
        node.left=insert(nums,i,m);
        node.right=insert(nums,m+1,n);
        return node;
    }
}