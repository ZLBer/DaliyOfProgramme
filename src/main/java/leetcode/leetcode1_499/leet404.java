package leetcode.leetcode1_499;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libin on 2019/1/12.
 */
public class leet404 {
    //myself 递归法 8ms
/*    public int sumOfLeftLeaves(TreeNode root) {
         int sum=0;
        if(root==null) return 0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null) {
            sum+=root.left.val;
            sum+=sumOfLeftLeaves(root.right);
        } else {
           sum+= sumOfLeftLeaves(root.left);
sum+=sumOfLeftLeaves(root.right);
        }
        return sum;
    }*/
  //更好的递归写法
/*    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        //判断左子树
        if(root.left != null) {
            //判断左子树是否是叶子
            if(root.left.left == null && root.left.right == null) ans += root.left.val;
            //否则递归左子树
            else ans += sumOfLeftLeaves(root.left);
        }
        //递归右子树
        ans += sumOfLeftLeaves(root.right);
       //返回该子树的和
        return ans;
    }*/


    //遍历写法 8ms
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
  int sum=0;
       if(root==null) return 0;
       else queue.offer(root);
       while(!queue.isEmpty()){
           root=queue.poll();
           if(root.left!=null){
               if(root.left.left==null&&root.left.right==null) sum+=root.left.val;
               else queue.offer(root.left);
           }
           if(root.right!=null){

                queue.offer(root.right);
           }
       }
       return sum;
    }
}
