package leetcode.leetcode1000_1499;

import leetcode.TreeNode;

public class leet1448 {
    public int goodNodes(leetcode.TreeNode root) {
return helper(root,Integer.MIN_VALUE);

    }

   int helper(TreeNode root, int max){
       if(root==null) return 0;

      if(root.val>=max){
       return  1+helper(root.left,root.val)+helper(root.right,root.val);
      }else {
          return helper(root.left,max)+helper(root.right,max);
      }
   }
}
