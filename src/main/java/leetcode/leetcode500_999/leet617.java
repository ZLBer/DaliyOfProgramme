package leetcode.leetcode500_999;

import leetcode.TreeNode;

/**
 * Created by libin on 2019/1/1.
 */
public class leet617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
          if(t1==null) return t2;
          if(t2==null)  return t1;
          t1.val+=t2.val;
          t1.left=mergeTrees(t1.left,t2.left);
          t1.right=mergeTrees(t1.right,t2.right);
           return t1;
    }
   //  非递归遍历（不容易考虑）
    //为什么更慢了？？？？？？？
 /*   public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //第一棵树为空，直接返回第二棵树
        if (t1 == null)
            return t2;
    Stack< TreeNode[] > stack = new Stack < > ();
    //树根入栈
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
        TreeNode[] t = stack.pop();
        // 只有两种情况 1.第二个节点为空  2.两个节点均为空
            // 此处第一棵树节点为空的情况已经被排除，或者说这种节点根本不会入栈
        if (t[0] == null || t[1] == null) {
            continue;
        }
        t[0].val += t[1].val;
        //第二棵左子树空，直接将第二棵左子树复制过来
        if (t[0].left == null) {
            t[0].left = t[1].left;
        } else {
            //否则加入栈中，重新进行计算
            stack.push(new TreeNode[] {t[0].left, t[1].left});
        }
            //第二棵右子树空，直接将第二棵右子树复制过来
        if (t[0].right == null) {
            t[0].right = t[1].right;
        } else {
            //否则加入栈中，重新进行计算
            stack.push(new TreeNode[] {t[0].right, t[1].right});
        }
    }
        return t1;
}
*/

}
