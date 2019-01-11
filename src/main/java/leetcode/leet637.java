package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by libin on 2019/1/11.
 */
public class leet637 {
    public List<Double> averageOfLevels(TreeNode root) {
         List<Double> result=new LinkedList<>();
        Queue<TreeNode> queue= new LinkedList<>();

        if(root==null) return result;
        queue.add(root);
        while (!queue.isEmpty()){
            int size =queue.size();
            double sum=0;
            int count=size;
            while(size-->0){
                 root=queue.poll();
                   sum+=root.val;
                   if(root.left!=null) queue.add(root.left);
                   if(root.right!=null) queue.add(root.right);
            }

            result.add(sum/count);

        }
return  result;
    }
}
