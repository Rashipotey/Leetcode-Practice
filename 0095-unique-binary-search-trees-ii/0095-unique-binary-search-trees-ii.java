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
    public List<TreeNode> generateTrees(int n) {
        return buildTrees(1,n);
    }
    private List<TreeNode> buildTrees(int s, int e){
        List<TreeNode> res=new ArrayList<>();
        if(s>e){
            res.add(null);
            return res;
        }
        for(int i=s;i<=e;i++){
            List<TreeNode> left=buildTrees(s,i-1);
            List<TreeNode> right=buildTrees(i+1,e);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}