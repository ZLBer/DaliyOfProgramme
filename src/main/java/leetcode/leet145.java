package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class leet145 {

    //mine
/*   public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        TreeNode node=root;
        Stack<TreeNode> stack=new Stack<>();
        Set<TreeNode> set=new HashSet<>();
        while (node!=null||!stack.isEmpty()){
            if(node!=null&&!set.contains(node)){
                stack.push(node);
                node=node.left;
            }else {
           //  if(stack.isEmpty()) break;
                node = stack.peek();
             if(!set.contains(node)) {
                 set.add(node);
                 node=node.right;
             }
             else{
                 stack.pop();
                res.add(node.val);
                 System.out.println(node.val);
                 node=null;
             }

            }
        }
       return res;
    }*/

    //王道版本
   /* public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        TreeNode node=root;
        Stack<TreeNode> stack=new Stack<>();
        Set<TreeNode> set=new HashSet<>();
        TreeNode rencently=null;
        while (node!=null||!stack.isEmpty()){
            if(node!=null&&!set.contains(node)){
                stack.push(node);
                node=node.left;
            }else {
                node = stack.peek();
                if(node.right!=null&&node.right!=rencently){
                    node=node.right;
                    stack.push(node);
                    node=node.left;
                }else {
                    node=stack.pop();
                    res.add(node.val);
                    rencently=node;//从右节点返回
                    node=null;
                }


            }
        }
        return res;
    }*/

    //mine  改进版本  个人觉得比王道的好
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        TreeNode node=root;
        Stack<TreeNode> stack=new Stack<>();
        Set<TreeNode> set=new HashSet<>();
        while (node!=null||!stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else {
                node = stack.peek();
                if(!set.contains(node)) {
                    set.add(node); //标志已经进入右节点
                    node=node.right;
                }
                else{
                    stack.pop();
                    res.add(node.val);
                    //System.out.println(node.val);
                    node=null; //置空，强制从stack里取
                }

            }
        }
        return res;
    }


}
