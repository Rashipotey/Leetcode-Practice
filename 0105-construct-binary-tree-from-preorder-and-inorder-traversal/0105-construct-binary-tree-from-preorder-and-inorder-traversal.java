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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){
        if(preStart>preEnd || inStart>inEnd) return null;
        int rootVal=preorder[preStart];
        TreeNode root=new TreeNode(rootVal);
        int inRoot=map.get(rootVal);
        int numsLeft=inRoot-inStart;
        root.left=build(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,map);
        root.right=build(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1, inEnd,map);
        return root;
    }
}