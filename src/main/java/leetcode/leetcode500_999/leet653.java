package leetcode.leetcode500_999;

import leetcode.TreeNode;
import org.omg.CORBA.TRANSACTION_MODE;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created by libin on 2019/1/11.
 */
public class leet653 {
    //   myself 递归法  25ms
 /*   HashSet<Integer> set=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
          if(root==null) return false;

         boolean flag=false;
           if(set.contains(k-root.val))  flag=true;
           else {
              set.add(root.val);
              flag= false;
           }
       return flag || findTarget(root.left,k)||findTarget(root.right,k);

    }*/

    //myself  非递归法   与上法本质上一样  38ms
    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
              if(root==null) return false;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root=stack.pop();
            if(set.contains(k-root.val)) return true;
            else  set.add(root.val);
            if(root.left!=null) stack.add(root.left);
            if(root.right!=null) stack.add(root.right);
    }
    return false;
}



}
