package leetcode.leetcode1000_;

import leetcode.TreeNode;

public class leet1372 {

    //mine 从上往下  到每一个点继续累加  或者 从1重新开始
    public int longestZigZag(leetcode.TreeNode root) {

        helper(root.left,true,1);
        helper(root.right,false,1);
   return max;
    }


    int max=0;
    void helper(TreeNode node, boolean isFromLeft, int path){
       if(node==null) return;
        max=Math.max(max,path);
       //若是来自左分支
       if(isFromLeft){
           //右节点++
           helper(node.right,false,path+1);
           helper(node.left,true,1);
       }else {
           //左节点++
           helper(node.left,true,path+1);
           helper(node.right,false,1);
       }
    }


    //从下往上
 /*   public int longestZigZag(TreeNode root) {
        return dfs(root)[2];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{-1, -1, -1};
        int[] left = dfs(root.left), right = dfs(root.right);
        //右节点的左子树  左节点的右子树   每个res都表示一个单独的结果
        int res = Math.maxSum(Math.maxSum(left[1], right[0]) + 1, Math.maxSum(left[2], right[2]));
        return new int[]{left[1] + 1, right[0] + 1, res};
    }*/
}
