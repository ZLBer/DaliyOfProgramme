package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet1261 {
    class FindElements {
    Set<Integer> set=new HashSet<>();
        public FindElements(TreeNode root) {
            root.val=0;
        helper(root);
        }
        void helper(TreeNode node){
            if(node==null) return;
            if(node.left!=null){
               set.add(node.left.val=2*node.val+1);
            }
            if(node.right!=null){
                set.add(node.right.val=2*node.val+2);
            }
            helper(node.left);
            helper(node.right);
        }

        public boolean find(int target) {
           return set.contains(target);
        }
    }

}
