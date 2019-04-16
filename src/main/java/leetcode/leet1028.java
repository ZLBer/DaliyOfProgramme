package leetcode;

import org.omg.CORBA.TRANSACTION_MODE;

import java.util.Stack;

/**
 * Created by libin on 2019/4/16.
 */
public class leet1028 {

    //mine 糟糕的代码  基本思想就是用两个栈分别存储node和depth  ，然后遍历S串
   static public TreeNode recoverFromPreorder(String S) {
     if(S.length()==0) return null;
        Stack<TreeNode> treeStack=new Stack<>();
        Stack<Integer>  depthStack=new Stack<>();
      int index=0;

       StringBuilder r=new StringBuilder();
       while (index<S.length()&&S.charAt(index)!='-'){
           r.append(S.charAt(index++));
       }

       TreeNode root =new TreeNode(Integer.parseInt(r.toString()));
        treeStack.push(root);
        depthStack.push(0);
      int predepth=0;


     while (index<S.length()){
      int depth=0;
       while (S.charAt(index)=='-'){
           depth++;
           index++;
       }
      //子节点
         StringBuilder sb=new StringBuilder();
         while (index<S.length()&&S.charAt(index)!='-'){
           sb.append(S.charAt(index++));
         }



         TreeNode node =new TreeNode(Integer.parseInt(sb.toString()));
       if(depth>predepth){

           treeStack.peek().left=node;

       }
       //同层节点
       else if (depth==predepth){
           treeStack.pop();
           depthStack.pop();
           treeStack.peek().right=node;
       }
       //该层结束
       else{
           while (depthStack.peek()!=depth-1){
               depthStack.pop();
               treeStack.pop();
           }
           treeStack.peek().right=node;
       }
         treeStack.push(node);
         depthStack.push(depth);
         predepth=depth;

     }

     return root;
    }




  //大神的代码   清晰简洁明了
    //大体思想一样 用栈来存贮node，但是巧妙地利用栈的大小来表示depth ，要明白这一点：栈其实指挥保存一条路径
 /*   public TreeNode recoverFromPreorder(String S) {
        int level, val;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < S.length();) {
            for (level = 0; S.charAt(i) == '-'; i++) {
                level++;
            }
            for (val = 0; i < S.length() && S.charAt(i) != '-'; i++) {
                val = val * 10 + (S.charAt(i) - '0');
            }
          //node的层次和栈顶元素层次比较，找到node的父节点
            while (stack.size() > level) {
                stack.pop();
            }
            TreeNode node = new TreeNode(val);
          //添加左孩子或右孩子
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            //添加这个node
            stack.add(node);
        }

        //返回栈顶，即root
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }
*/


    public static void main(String[] args) {
       recoverFromPreorder("10-7--8");
        System.out.println();
    }
}
