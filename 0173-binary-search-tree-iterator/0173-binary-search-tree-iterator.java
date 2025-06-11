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
class BSTIterator {
    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        TreeNode curr=root;
        while(curr!=null){
            st.push(curr);
            if(curr.left!=null){
                curr=curr.left;
            }else{
                break;
            }
        }
    }
    
    public int next() {
        TreeNode n=st.pop();
        TreeNode curr=n;
        if(curr.right!=null){
            curr=curr.right;
            while(curr!=null){
                st.push(curr);
                if(curr.left!=null){
                    curr=curr.left;
                }else{
                    break;
                }
            }
        }
        return n.val;
    }
    
    public boolean hasNext() {
        return !st.empty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */