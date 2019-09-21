package leetcode.leetcode500_999;

import leetcode.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by libin on 2019/1/11.
 */
public class leet589 {
    //递归法
/*    List<Integer> result=new LinkedList<>();
    public List<Integer> preorder(Node root) {
 search(root);
return result;
     }
     void search(Node node ){
        if(node==null) return;
       List <Node> childs=node.children;
          result.add(node.val);
        for(int i=0;i<childs.size();i++){
            search(childs.get(i));
        }
     }
     */
     //递归的简明版本
/*    public List<Integer> preorder(Node root) {
        if (root == null)
            return result;

        result.add(root.val);
        for(Node node: root.children)
            preorder(node);

        return result;
    }*/
  //非递归 用栈  10ms
    public List<Integer> preorder(Node root) {

        List<Integer> result=new LinkedList<>();
        if(root==null) return result;
        Stack<Node> stack=new Stack<>();
        stack.push(root);
               while(!stack.isEmpty()){
                   root=stack.pop();
                   result.add(root.val);
                   List<Node> te=root.children;
            for(int i=te.size()-1;i>=0;i--){
                stack.push(te.get(i));
            }
               }
               return result;
    }
}
