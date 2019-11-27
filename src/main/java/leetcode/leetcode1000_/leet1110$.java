package leetcode.leetcode1000_;

import leetcode.TreeNode;

import java.util.*;

public class leet1110$ {
    // 错误的解法
//  static   public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
//        List<TreeNode> results=new LinkedList<>();
//        Set<Integer> delete=new HashSet<>();
//        for(int a:to_delete){
//            delete.add(a);
//        }
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.add(root);
//        if(!delete.contains(root.val)) results.add(root);
//        while (!queue.isEmpty()){
//            root= queue.poll();
//            if(root.left!=null) {
//                if (delete.contains(root.left.val)) {
//                    if (root.left.left != null) {
//                        if (!delete.contains(root.left.left.val)) {
//                            results.add(root.left.left);
//                        }
//                        queue.add(root.left.left);
//                    }
//                        if (root.left.right != null) {
//                            if (!delete.contains(root.left.right.val)) {
//                                results.add(root.left.right);
//                            }
//                            queue.add(root.left.right);
//                        }
//                        root.left = null;
//                    } else queue.add(root.left);
//                }
//
//            if(root.right!=null){
//                //需要删除该节点
//                if(delete.contains(root.right.val)){
//                    if(root.right.left!=null)  {
//                        if(!delete.contains(root.right.left.val)){
//                            results.add(root.right.left);
//                        }
//                        queue.add(root.right.left);}
//                    if(root.right.right!=null) {
//                        if(!delete.contains(root.right.right.val)){
//                            results.add(root.right.right);
//                        }
//                        queue.add(root.right.right);}
//                    root.right=null;
//                }
//                //不需要删除该节点
//                else queue.add(root.right);
//            }
//        }
//return results;
//    }
    List<TreeNode> result=new ArrayList<>();
    Set<Integer> set = new HashSet<>();
       public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
         }
        helper(root,true);
        return result;

       }
  //递归用的太好了
       TreeNode helper(TreeNode node,boolean isRoot){
           if(node==null) return null;

           boolean delete = set.contains(node.val);

           if(isRoot&&!delete) result.add(node);
           node.left=helper(node.left,delete);
           node.right=helper(node.right,delete);

           return delete?null:node;
       }

    public static void main(String[] args) {
/*        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        TreeNode temp=new TreeNode(3);
        temp.right=new TreeNode(4);
        root.right=temp;
        delNodes(root,new int[]{2,1});  */
    }
}
