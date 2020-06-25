package leetcode._jianzhioffer;

import leetcode.TreeNode;

public class p26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
      if(A==null||B==null) return false;
    return dfs(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
   boolean dfs(TreeNode A,TreeNode B){
      if(B==null) return true;
      if(A==null )return  false;

      return A.val==B.val&&dfs(A.left,B.left)&&dfs(A.right,B.right);
   }
}
