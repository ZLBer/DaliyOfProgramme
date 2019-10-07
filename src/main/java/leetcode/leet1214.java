package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet1214 {
    //mine n*lgn
/*    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set=new HashSet<>();
        helper(root1,set);
        return check(root2,set,target);

    }

    void helper(TreeNode node,Set<Integer> set){
        if(node==null) return;
        set.add(node.val);
        helper(node.left,set);
        helper(node.right,set);
    }

 boolean check(TreeNode node,Set<Integer> set,int target){
        if(node==null) return false;
        if(set.contains(target-node.val))
            return true;
        return check(node.left,set,target)||check(node.right,set,target);
    }*/

    //这样也是n*lgn
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        return helper(root1,root2,target);

    }

    boolean helper(TreeNode node,TreeNode root2,int target){
        if(node==null) return false;
        boolean result=check(root2,target-node.val);
        if(result) return true;
        else {
            result=helper(node.left,root2,target)||helper(node.right,root2,target);
        }
          return result;
    }

    boolean check(TreeNode node,int target){
        if(node==null) return false;
        if(node.val==target) return true;
        boolean result=false;
        if(target<node.val)
           result= check(node.left,target);
        else
            result=check(node.right,target);
        return result;
    }
}
