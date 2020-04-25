package leetcode.leetcode1_499;

public class leet124 {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
DFS(root);
return max;
    }
    int DFS(TreeNode node){
        if(node==null) return 0;
        int left = Math.max(0,DFS(node.left));
        int right= Math.max(0,DFS(node.right));
        max=Math.max(max,left+right+node.val);
        return Math.max(left+node.val,right+node.val);
    }
}
