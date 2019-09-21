package leetcode.leetcode500_999;

import leetcode.TreeNode;

/**
 * Created by libin on 2019/2/24.
 */
public class leet530 {

    Integer min=Integer.MAX_VALUE,pre=null;
    public int getMinimumDifference(TreeNode root) {
          if(root.left!=null) getMinimumDifference(root.left);
          if(pre!=null) min=Math.min(min,root.val-pre);
          pre=root.val;
          if(root.right!=null) getMinimumDifference(root.right);
          return min;
    }
}
