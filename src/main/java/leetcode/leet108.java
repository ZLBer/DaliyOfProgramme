package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by libin on 2019/1/12.
 */
public class leet108 {
    //myself递归法  每次截取中间  分成两部分 依次递归下去
/*    public TreeNode sortedArrayToBST(int[] nums) {
        return order(nums,0,nums.length-1);
    }
    TreeNode order(int []nums,int begin,int end){
       if(end<begin) return null;
      if(begin==end) return new TreeNode(nums[begin]);
        int order =(end-begin)/2;
        TreeNode root =new TreeNode(nums[order]);

           root.left=order(nums,begin,order-1);
          root.right=order(nums,order+1,end);
              return root;
    }*/
    //另一个递归版本
   /* public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }*/


   //遍历法 good  solution
    public TreeNode sortedArrayToBST(int[] nums) {

        int len = nums.length;
        if ( len == 0 ) { return null; }

        // 0 as a placeholder
        TreeNode head = new TreeNode(0);

        Deque<TreeNode> nodeStack       = new LinkedList<TreeNode>() {{ push(head);  }};
        Deque<Integer>  leftIndexStack  = new LinkedList<Integer>()  {{ push(0);     }};
        Deque<Integer>  rightIndexStack = new LinkedList<Integer>()  {{ push(len-1); }};

        while ( !nodeStack.isEmpty() ) {
            TreeNode currNode = nodeStack.pop();
            int left  = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid   = left + (right-left)/2; // avoid overflow
            currNode.val = nums[mid];
            if ( left <= mid-1 ) {
                currNode.left = new TreeNode(0);
                nodeStack.push(currNode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid-1);
            }
            if ( mid+1 <= right ) {
                currNode.right = new TreeNode(0);
                nodeStack.push(currNode.right);
                leftIndexStack.push(mid+1);
                rightIndexStack.push(right);
            }
        }
        return head;
    }
}
