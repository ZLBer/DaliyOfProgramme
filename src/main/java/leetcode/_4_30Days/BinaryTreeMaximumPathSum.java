package leetcode._4_30Days;

import leetcode.TreeNode;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {

         dfs(root);
         return max;
    }
     int max=Integer.MIN_VALUE;
    int dfs(TreeNode node){
       if(node==null) return 0;
      int left=dfs(node.left);
      int right=dfs(node.right);
      max=Math.max(max,left+right+node.val);
      return Math.max(0,Math.max(left+node.val,right+node.val));
    }
}
