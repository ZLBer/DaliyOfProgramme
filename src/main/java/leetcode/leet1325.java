package leetcode;

public class leet1325 {

    //mine 后序遍历
/*    public TreeNode removeLeafNodes(TreeNode root, int target) {
     TreeNode dummy=new TreeNode(0);
     dummy.left=root;
      helper(root,target,dummy,true);
      return dummy.left;
    }

    void helper(TreeNode node,int taget,TreeNode parent,boolean isLeft){
        if(node==null) return;


        helper(node.left,taget,node,true);
        helper(node.right,taget,node,false);

        if(node.left==null&&node.right==null){
            if(node.val==taget){
                if(isLeft) parent.left=null;
                else  parent.right=null;
            }
            return;
        }
    }*/


    //minr 另一种后序遍历 简洁一点
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        return helper(root,target);
    }
    TreeNode helper(TreeNode node,int taget){

        if(node==null) return null;
       node.left= helper(node.left,taget);
       node.right=helper(node.right,taget);
        if(node.left==null&&node.right==null){
            if(node.val==taget){
              return null;
            }

        }
        return node;
    }
}
