package leetcode.leetcode500_999;

import java源码学习.util.LinkedList;
import leetcode.TreeNode;
import org.omg.CORBA.TRANSACTION_MODE;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by libin on 2019/2/24.
 */
public class leet783 {
    //很臃肿的做法
  /*  LinkedList<Integer> linkedList=new LinkedList<>();
    public int minDiffInBST(TreeNode root) {
        help(root);
        int min=Integer.MAX_VALUE;
        for (int i=1;i<linkedList.size();i++){
            min=Math.min(min,linkedList.get(i)-linkedList.get(i-1));
        }
        return min;

    }
    void help(TreeNode node){
        if (node==null)  return ;
        help(node.left);
        linkedList.add(node.val);
        help(node.right);
    }*/

    //只用递归，简洁
      Integer res = Integer.MAX_VALUE, pre = null; //用类变量记录pre
      public int minDiffInBST(TreeNode root) {
          if (root.left != null) minDiffInBST(root.left);
          if (pre != null) res = Math.min(res, root.val - pre);
          pre = root.val;
          if (root.right != null) minDiffInBST(root.right);
          return res;
      }


}
