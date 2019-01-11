package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libin on 2019/1/11.
 */
public class leet559 {
    //递归 6ms
/*    public int maxDepth(Node root) {
         if(root==null) return 0;
         int max=0;
         //找到最大深度
         for(int i=0;i<root.children.size();i++){
             int maxI=maxDepth(root.children.get(i));
             max=max>maxI?max:maxI;
         }
         //返回最大深度+1
         return max+1;
    }*/
    //非递归 9ms
     int maxdepth=0;
    public int maxDepth(Node root) {
     if(root==null) return 1;
        Queue <Node> queue=new LinkedList<>();
        root.val=1;
        queue.add(root);
         while(!queue.isEmpty()){
             root=queue.poll();
             for(int i=0;i<root.children.size();i++){
                int curMax= root.val+1;
                root.children.get(i).val=curMax;
                    maxdepth=Math.max(curMax,maxdepth);
                    queue.add(root.children.get(i));
             }
         }
         return maxdepth;
    }
}
