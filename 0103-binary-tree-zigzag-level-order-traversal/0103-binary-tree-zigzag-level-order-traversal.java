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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        boolean leftToRight=true;
        q.add(root);
        while(!q.isEmpty()){
            int level=q.size();
            LinkedList<Integer> temp=new LinkedList<>();
            for(int i=0;i<level;i++){
                TreeNode curr=q.poll();
                if(leftToRight){
                    temp.addLast(curr.val);
                }else{
                    temp.addFirst(curr.val);
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            res.add(temp);
            leftToRight=!leftToRight;
        }
        return res;
    }
}