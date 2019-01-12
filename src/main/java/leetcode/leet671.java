package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by libin on 2019/1/12.
 */
public class leet671 {
    int min=Integer.MAX_VALUE;int secondMin=Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        if(secondMin== Integer.MAX_VALUE) return -1;
         return secondMin;
    }
    void  helper(TreeNode node){
        if (node==null) return ;
        if(node.val<min) {
            secondMin=min;
            min=node.val;
        }
        else if(node.val<secondMin&&node.val>min){
            secondMin=node.val;
        }
        helper(node.left);
        helper(node.right);
    }
}
