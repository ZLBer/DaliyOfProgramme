package leetcode;

import java.util.*;

/**
 * Created by libin on 2019/1/12.
 */
public class leet257$ {

    //试图前序遍历  但总是不对
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> result = new LinkedList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        if (root == null) return result;
//        TreeNode p = root;
//        String s = "";
//        while (!stack.isEmpty() || p != null) {
//            if (p!= null) {
//                s += p.val + "->";
//                stack.push(p);
//                if(p.left==null&&p.right==null) result.add(s+p.val);
//                s = s.substring(0, s.lastIndexOf("->")+2);
//                p = p.left;
//            } else {
//                p = stack.pop();
//                //  System.out.println(p.val);
//                s = s.substring(0, s.lastIndexOf(p.val)-2);
//
//                p = p.right;
//            }
//
//        }
//        return result;
//
//    }
    //递归法
/*    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }*/

    //DFS - Stack  用另一个栈保存该节点当前的路径
  /*  public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<String>();
        Stack<TreeNode> sNode=new Stack<TreeNode>();
        Stack<String> sStr=new Stack<String>();

        if(root==null) return list;
        sNode.push(root);
        sStr.push("");
        while(!sNode.isEmpty()) {
            TreeNode curNode=sNode.pop();
            String curStr=sStr.pop();

            if(curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);

            if(curNode.right!=null) {
                sNode.push(curNode.right);
                sStr.push(curStr+curNode.val+"->");
            }
            if(curNode.left!=null) {
                sNode.push(curNode.left);
                sStr.push(curStr+curNode.val+"->");
            }
        }
        return list;
    }*/

    //BFS - Queue  用队列保存当前节点的路径
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        Queue<TreeNode> qNode = new LinkedList<TreeNode>();
        Queue<String> qStr = new LinkedList<String>();

        if (root == null) return list;
        qNode.add(root);
        qStr.add("");
        while (!qNode.isEmpty()) {
            TreeNode curNode = qNode.remove();
            String curStr = qStr.remove();

            if (curNode.left == null && curNode.right == null) list.add(curStr + curNode.val);
            if (curNode.left != null) {
                qNode.add(curNode.left);
                qStr.add(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                qNode.add(curNode.right);
                qStr.add(curStr + curNode.val + "->");
            }
        }
        return list;
    }
    public static void main(String[] args) {

    }
}
