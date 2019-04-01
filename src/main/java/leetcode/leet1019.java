package leetcode;

import leetcode.LQTest.A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by libin on 2019/4/1.
 */
public class leet1019 {


   // Time Limit Exceeded
//    public int[] nextLargerNodes(ListNode head) {
//        List<Integer> list= new LinkedList<>();
//
//     ListNode  p=head;
//      while (p!=null){
//          ListNode q=p;
//          while (q!=null&&q.val<=p.val)
//              q=q.next;
//
//          if(q!=null)
//              list.add(q.val);
//          else list.add(0);
//
//          p=p.next;
//      }
//
//
//
//        int[] d = new int[list.size()];
//        for(int i = 0;i<list.size();i++) {
//            d[i] = list.get(i);
//        }
//
//        return d;
//        }
   public int[] nextLargerNodes(ListNode head) {
   //转成Arraylist
       List<Integer> list= new ArrayList<>();
       while (head!=null){
           list.add(head.val);
           head=head.next;
       }

       int []result=new int[list.size()];
       Stack<Integer> stack =new Stack<>();
       for (int i = 0; i < list.size(); i++) {

  while (!stack.isEmpty()&&list.get(stack.peek())<list.get(i))
      result[stack.pop()]=list.get(i);

           stack.push(i);
       }

return result;
   }


}
