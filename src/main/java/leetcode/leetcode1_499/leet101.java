package leetcode.leetcode1_499;

import leetcode.TreeNode;

import java.util.Stack;

/**
 * Created by libin on 2019/1/9.
 */
public class leet101 {
    //错误解法  层序遍历
//    public boolean isSymmetric(TreeNode root) {
//        if(root==null) return false;
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.add(root);
//        int level=0;
//        while (!queue.isEmpty()){
//            level++;
//            int size=queue.size();
//            LinkedList <Integer> levelVal=new LinkedList<>();
//            while (size-->0) {
//                TreeNode p=queue.poll();
//              levelVal.add(p==null?null:p.val);
//              if(p==null) continue;
//              if(p.left != null||p.right != null) {
//                  queue.add(p.left);
//                  queue.add(p.right);
//              }
//            }
//            if(levelVal.size()%2!=0&&level!=1) return false;
//            int leng=levelVal.size();
//            for(int i=0;i<levelVal.size()/2;i++){
//                if(levelVal.get(i)!=levelVal.get(leng-i-1)) return  false;
//            }
//
//        }
//return true;
//     }
  //递归解法  有点难想
  /*  public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }*/
  //栈遍历
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.empty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (left == null && right == null) continue;
            else if (left == null || right == null || right.val != left.val) return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }



  //遍历 队列
//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        q.add(root);
//        while (!q.isEmpty()) {
//            TreeNode t1 = q.poll();
//            TreeNode t2 = q.poll();
//            if (t1 == null && t2 == null) continue;
//            if (t1 == null || t2 == null) return false;
//            if (t1.val != t2.val) return false;
//            q.add(t1.left);
//            q.add(t2.right);
//            q.add(t1.right);
//            q.add(t2.left);
//        }
//        return true;
//    }

}
