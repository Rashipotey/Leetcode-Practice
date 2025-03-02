import java.util.*;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Double> result=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelSize=q.size(); 
            double sum=0;
            for(int i=0;i<levelSize;i++){
                TreeNode node=q.poll();
                sum+=node.val; 
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            double average=sum/levelSize;
            result.add(average);
        }
        
        return result;
    }
}
