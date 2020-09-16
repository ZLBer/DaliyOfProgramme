package leetcode.leetcode1000_1499;

import leetcode.TreeNode;

/**
 * Created by libin on 2019/4/12.
 */
public class leet1008$ {

    //递归做法
    int nodeindex;
    public TreeNode bstFromPreorder(int[] preorder) {
       if(preorder==null) return null;
       return helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    TreeNode helper(int [] preorder,int start ,int end){
        if(nodeindex==preorder.length||preorder[nodeindex]<start||preorder[nodeindex]>end)
            return null;
        TreeNode node= new TreeNode(preorder[nodeindex++]);
        node.left=helper(preorder,start,node.val);
        node.right=helper(preorder,node.val,end);
        return node;

    }


    //用栈遍历
   /* public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder==null) return null;
        Stack<TreeNode> stack=new Stack<>();
       ;
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for(int i=1;i<preorder.length;i++){
            TreeNode node = new TreeNode(preorder[i]);
            if(node.val<stack.peek().val)
            {
                stack.peek().left=node;
            }
            else {
                TreeNode parent =stack.peek();
                  while (!stack.isEmpty()&& node.val>stack.peek().val){
                      parent=stack.pop();
                  }
                  parent.right=node;
            }



            stack.push(node);
        }
        return root;

    }*/


}
