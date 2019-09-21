package leetcode.leetcode1_499;

import leetcode.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by libin on 2019/1/11.
 */
public class leet429 {
    //非递归层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> temp=new LinkedList<>();
            while (size-- > 0) {
                root = queue.poll();
                temp.add(root.val);
                for(int i=0;i<root.children.size();i++){
                    queue.add(root.children.get(i));
                }

            }
            result.add(temp);

        }
return  result;
    }
}
