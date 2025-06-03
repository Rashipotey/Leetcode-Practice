/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res=new ArrayList<>();
        helper(root,target,k,res);
        return res;
    }
    private int helper(TreeNode root, TreeNode target, int k, List<Integer> res){
        if(root==null) return -1;
        if(root==target){
            findNodes(root, k, res);
            return 1;
        }
        int left=helper(root.left, target, k, res); //distance from root's left child to target
        if(left!=-1){
            if(k-left==0){
                res.add(root.val);
            }else{
                findNodes(root.right,k-left-1,res);
            }
            return left+1;
        }
        int right=helper(root.right, target, k, res);
        if(right!=-1){
            if(k-right==0){
                res.add(root.val);
            }else{
                findNodes(root.left,k-right-1,res);
            }
            return right+1;
        }
        return -1;
    }
    private void findNodes(TreeNode root, int dis, List<Integer> res){
        if(root==null) return;
        if(dis==0){
            res.add(root.val);
            return;
        }
        findNodes(root.left,dis-1,res);
        findNodes(root.right,dis-1,res);
    }
}