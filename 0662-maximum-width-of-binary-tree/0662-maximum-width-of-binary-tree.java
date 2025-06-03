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
    static class Pair{
        TreeNode node;
        int ind;
        Pair(TreeNode node, int ind){
            this.node=node;
            this.ind=ind;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        int max=0;
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().ind;
            int first=-1, last=-1;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                TreeNode curr=p.node;
                int idx=p.ind-min;
                if(i==0) first=idx;
                if(i==size-1) last=idx;
                if(curr.left!=null) q.add(new Pair(curr.left, 2*idx));
                if(curr.right!=null) q.add(new Pair(curr.right, 2*idx+1));
            }
            max=Math.max(max, last-first+1);
        }
        return max;
    }
}