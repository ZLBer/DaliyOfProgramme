package leetcode;

public class DiameterofBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
    helper(root);
    return res;
    }
    int res=0;
    int[] helper(TreeNode node){
        if(node==null) return new int[]{0,0};
        int []left=helper(node.left);
        int[]right=helper(node.right);
        res=Math.max(res,Math.max(left[0],left[1])+Math.max(right[0],right[1]));
        return new int[]{1+Math.max(left[0],left[1]),1+Math.max(right[0],right[1])};
    }
}
