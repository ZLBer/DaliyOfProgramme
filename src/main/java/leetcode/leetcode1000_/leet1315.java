package leetcode.leetcode1000_;

import leetcode.TreeNode;

public class leet1315 {

    //mine  记录下grandparent和parent就好了
    public int sumEvenGrandparent(leetcode.TreeNode root) {

   helper(null,null,root);
return res;
    }

    int res=0;
    void helper(leetcode.TreeNode grandparent, leetcode.TreeNode parent, TreeNode node){
           if(node==null) return;
           if(grandparent!=null){
               if(grandparent.val%2==0)res+=node.val;
           }
           helper(parent,node,node.left);
           helper(parent,node,node.right);
    }



    //可以只存节点的val,不用保存节点

/*    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, 1, 1);
    }

    public int helper(TreeNode node, int p, int gp) {
        if (node == null) return 0;
        return helper(node.left, node.val, p) + helper(node.right, node.val, p) + (gp % 2 == 0 ? node.val : 0);
    }*/
}
