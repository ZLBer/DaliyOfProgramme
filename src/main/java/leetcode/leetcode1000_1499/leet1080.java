package leetcode.leetcode1000_1499;

import leetcode.TreeNode;

public class leet1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        TreeNode newTree=new TreeNode(0);
      preOrder(root,root.val,limit,newTree);
   //  test(root,newTree);
      dfs(root,newTree);
      if(root.left==null&&root.right==null&&newTree.val==1)
          return root;
      return root;
    }

    void preOrder(TreeNode node,int sum,int limit,TreeNode newTree){
           if(node==null) return;
            if(sum<limit) {
                newTree.val = 1;
               // System.out.println(sum+"  "+newTree.val);
            }
            else {
                newTree.val=0;
            //    System.out.println(sum+"  "+newTree.val);

            }
        if(node.left!=null)  {
            newTree.left=new TreeNode(0);
            preOrder(node.left,sum+node.left.val, limit,newTree.left);
        }
        if(node.right!=null){
            newTree.right=new TreeNode(0);
            preOrder(node.right,sum+node.right.val,limit,newTree.right);
        }
    }

    //后序遍历
    void  dfs(TreeNode node,TreeNode newTree){
        if(node==null) return;

        dfs(node.left,newTree.left);
        dfs(node.right,newTree.right);

        //判断左节点
        if(node.left!=null&&node.left.left==null&&node.left.right==null&&newTree.left.val==1)
            node.left=null;
        //判断右节点
        if(node.right!=null&&node.right.left==null&&node.right.right==null&&newTree.right.val==1)
            node.right=null;
    }

    void  test(TreeNode node,TreeNode newTree){
        if(node==null ) return;
        System.out.println(node.val+" "+newTree.val+" ");
        test(node.left,newTree.left);
        test(node.right,newTree.right);
    }
}
