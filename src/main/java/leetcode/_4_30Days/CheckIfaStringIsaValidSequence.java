package leetcode._4_30Days;

import leetcode.TreeNode;

public class CheckIfaStringIsaValidSequence {
    public boolean isValidSequence(TreeNode root, int[] arr) {
  return dfs(root,arr,0);
    }

    boolean dfs(TreeNode node,int []arr,int index){
        if(node==null) return false;

        if(index==arr.length-1){
      if(arr[index]==node.val&&node.left==null&&node.right==null)
          return true;
      return false;
   }


      if(node.val!=arr[index]) return false;

      boolean left=dfs(node.left,arr,index+1);

      if(left) return true;

      return dfs(node.right,arr,index+1);


    }
}
