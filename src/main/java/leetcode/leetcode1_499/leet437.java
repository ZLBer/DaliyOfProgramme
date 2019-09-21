package leetcode.leetcode1_499;

import leetcode.TreeNode;

/**
 * Created by libin on 2019/1/10.
 */
public class leet437 {
    int count;
    //两层DFS（两层递归） 32ms
    public int pathSum(TreeNode root, int sum) {
        inorder(root,sum);
        return count;
     }
      void inorder(TreeNode node,int sum){
        if(node==null) return;
        search(node,sum);
        inorder(node.left,sum);
        inorder(node.right,sum);
      }

     void search(TreeNode node,int sum){
        if(node==null) return ;
       search(node.left,sum-node.val);
       search(node.right,sum-node.val);
       if(sum-node.val==0) count++;
    }

   //一样的思想

/*  public int pathSum(TreeNode root, int sum) {
            if (root == null) return 0;
            return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        private int pathSumFrom(TreeNode node, int sum) {
            if (node == null) return 0;
            return (node.val == sum ? 1 : 0)
                    + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
        }*/

  //理解不了  17ms
    /*
    *  TODO: 等待理解
    * @date : 2019/1/10 11:27
    */
    //
//    public int pathSum(TreeNode root, int sum) {
//        HashMap<Integer, Integer> preSum = new HashMap();
//        preSum.put(0,1);
//        helper(root, 0, sum, preSum);
//        return count;
//    }
//    int count = 0;
//    public void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
//        if (root == null) {
//            return;
//        }
//
//        currSum += root.val;
//
//        if (preSum.containsKey(currSum - target)) {
//            count += preSum.get(currSum - target);
//        }
//
//        if (!preSum.containsKey(currSum)) {
//            preSum.put(currSum, 1);
//        } else {
//            preSum.put(currSum, preSum.get(currSum)+1);
//        }
//
//        helper(root.left, currSum, target, preSum);
//        helper(root.right, currSum, target, preSum);
//        preSum.put(currSum, preSum.get(currSum) - 1);
//    }
}