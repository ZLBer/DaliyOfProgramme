package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by libin on 2019/1/11.
 */

public class leet590 {
 //递归   9ms
    List<Integer> result=new LinkedList<>();
/*    public List<Integer> postorder(Node root) {
        search(root);
        return result;
    }
    void search(Node node ){
        if(node==null) return;
        List <Node> childs=node.children;

        for(int i=0;i<childs.size();i++){
            search(childs.get(i));
        }
        result.add(node.val);
    }*/
    //非递归  10ms
   /* public List<Integer> postorder(Node root) {
            LinkedList<Integer> list = new LinkedList();
            if(root == null) return list;

            Stack<Node> s = new Stack();
            s.push(root);

            while(!s.isEmpty()) {
                Node temp = s.pop();
                list.addFirst(temp.val);
                for(Node n : temp.children) {
                    s.push(n);
                }
            }

            return list;
        }*/
}
