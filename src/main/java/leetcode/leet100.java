package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libin on 2019/1/12.
 */
public class leet100 {
    //myself 递归法 4ms
    /*public boolean isSameTree(TreeNode p, TreeNode q) {
          if(p==null&&q==null) return true;
          if(p==null||q==null) return false;

 return  p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }*/
    //非递归
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(p==null&&q==null) {
          return true;
        }
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            p=queue.poll();
            q=queue.poll();
            if(p==null&&q==null) continue;
            if(p==null||q==null||p.val!=q.val) return  false;
            queue.offer(p.left);
            queue.offer(q.left);
            queue.offer(p.right);
            queue.offer(q.right);
        }
return true;
    }

    }
