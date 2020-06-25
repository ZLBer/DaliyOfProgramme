package leetcode;

public class leet1448 {
    public int goodNodes(TreeNode root) {
return helper(root,Integer.MIN_VALUE);

    }

   int helper(TreeNode root,int max){
       if(root==null) return 0;

      if(root.val>=max){
       return  1+helper(root.left,root.val)+helper(root.right,root.val);
      }else {
          return helper(root.left,max)+helper(root.right,max);
      }
   }
}
