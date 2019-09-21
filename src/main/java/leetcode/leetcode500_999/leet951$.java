package leetcode.leetcode500_999;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2019/1/17.
 */
public class leet951$ {
    //英语真的读起来有难度啊！！！
    //要明白的题目的意思，是反转后可以得到目标树，不一定要反转
    //错误的解法
  /*  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
              if (root1==null&&root2==null)  return true;
              if(root1==null||root2==null) return false;
              return root1.val==root2.val&&flipEquiv(root1.left,root2.right)&&flipEquiv(root1.right,root2.left);
    }*/


  //递归
/*    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
      //root1和root2全部为空
        if (root1 == root2)
            return true;
        //root1和root2数据不一致
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;
      //只要满足任意一种即可：反转或者不反转
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }*/
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        List<Integer> vals1 = new ArrayList();
        List<Integer> vals2 = new ArrayList();
        dfs(root1, vals1);
        dfs(root2, vals2);
        return vals1.equals(vals2);
    }

    public void dfs(TreeNode node, List<Integer> vals) {
        if (node != null) {
            vals.add(node.val);
            //空用-1表示
            int L = node.left != null ? node.left.val : -1;
            int R = node.right != null ? node.right.val : -1;
            //按照大小原则进行反转
            if (L < R) {
                dfs(node.left, vals);
                dfs(node.right, vals);
            } else {
                dfs(node.right, vals);
                dfs(node.left, vals);
            }
            vals.add(null);
        }
    }


}
