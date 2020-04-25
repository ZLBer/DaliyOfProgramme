package leetcode.leetcode1000_;

import leetcode.TreeNode;

public class leet1373 {

    //mine  第一次错误的解法 虽然能AC
    //没考虑到左子树所有的节点都要比跟节点小，右子树的所有节点都要比根节点大
   /* public int maxSumBST(TreeNode root) {
    dfs(root);
    return maxSum;
    }
    int maxSum=0;
    Integer dfs(TreeNode root){
        if(root==null) return 0;

        Integer left=dfs(root.left),right=dfs(root.right);

        //左右节点均不为空
        if(left!=null&&right!=null){
         if(   (root.left==null||root.left.val<root.val)  && ( root.right==null|| root.right.val>root.val) ){
             int re=left+right+root.val;
             maxSum=Math.maxSum(maxSum,re);
             return re;
         }
         else {
             //不能构成二叉搜索树
             return null;
         }
        }else {
            //不能构成二叉搜索树
            return null;
        }

    }*/

    //mine 需要进一步返回左子树最大值，右子树最小值

    public int maxSumBST(leetcode.TreeNode root) {
        dfs(root);
        return maxSum;
    }
    int maxSum =0;
    int top=4*10000+1;
    int down=-4*10000-1;
    //0 为和 1为最小值  2为最大值
    Integer[] dfs(TreeNode root){
        if(root==null) return new Integer[]{0,top,down};//对空节点的处理

        Integer[] left=dfs(root.left),right=dfs(root.right);

        //左右节点均不为空
        if(left!=null&&right!=null){
            if((root.left==null|left[2]<root.val)  && ( root.right==null|| right[1]>root.val) ){
                int re=left[0]+right[0]+root.val;
                maxSum =Math.max(maxSum,re);
                return new Integer[]{re,Math.min(root.val,Math.min(left[1],right[1])),Math.max(root.val,Math.max(left[2],right[2]))};
            }
            else {
                //不能构成二叉搜索树
                return null;
            }
        }else {
            //不能构成二叉搜索树
            return null;
        }

    }
}
