package leetcode.leetcode500_999;

import leetcode.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by libin on 2019/1/11.
 */
public class leet606 {
    //错误的解法
//    public String tree2str(TreeNode t) {
//      if(t==null) return "";
//        String result=preorder(t);
////        System.out.println(result);
////        System.out.println(result.length());
////        return "";
//        return result.substring(1,result.length()-1);
//
//    }
//
//    String preorder(TreeNode t){
//        if(t==null) return "()";
//        if(t.left==null&&t.right==null) return "("+t.val+")";
//        return "("+t.val+preorder(t.left)+preorder(t.right)+")";
//    }
//

    //递归解法  25ms
/*
    public String tree2str(TreeNode t) {
        if (t == null) return "";

        String result = t.val + "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left == "" && right == "") return result;
        if (left == "") return result + "()" + "(" + right + ")";
        if (right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }
*/


  //非递归算法  26ms
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        Stack< TreeNode > stack = new Stack < > ();
        stack.push(t);
        Set< TreeNode > visited = new HashSet< >();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            //如果之前访问过，添加）
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                //首次访问，添加(
                visited.add(t);
                s.append("(" + t.val);
                //左子树空，右子树不空  添加()
                if (t.left == null && t.right != null)
                    s.append("()");
                 //右孩子节点入栈
                if (t.right != null)
                    stack.push(t.right);
               //左孩子节点入栈
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }
}
