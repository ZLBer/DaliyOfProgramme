package leetcode.leetcode1_499;

import leetcode.ListNode;
import scala.collection.mutable.Stack;

import java.util.BitSet;

public class leet445 {

    //mine  用最辣鸡的方法来做
/*    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        ListNode p=l1;
        while (p!=null){
            stack1.push(p.val);
            p=p.next;
        }
        p=l2;
        while (p!=null){
            stack2.push(p.val);
            p=p.next;
        }
        int c=0;
        ListNode dumpy=new ListNode(0);
        p=dumpy;
        //采用头插法
        while (!stack1.isEmpty()&&!stack2.isEmpty()){
             int sum=stack1.pop()+stack2.pop()+c;
             c=sum/10;
             ListNode n=new ListNode(sum%10);
              n.next=p.next;
              p.next=n;
        }
        while (!stack1.isEmpty()){
            int sum=stack1.pop()+c;
            c=sum/10;
            ListNode n=new ListNode(sum%10);
            n.next=p.next;
            p.next=n;
        }
        while (!stack2.isEmpty()){
            int sum=stack2.pop()+c;
            c=sum/10;
            ListNode n=new ListNode(sum%10);
            n.next=p.next;
            p.next=n;
        }
        if(c!=0){
            ListNode n=new ListNode(c);
            n.next=p.next;
            p.next=n;
        }
        return dumpy.next;
    }*/


    //别人的两个栈  就写的很简洁
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        //判断最后的进位情况
        return list.val == 0 ? list.next : list;
    }




    //递归也是可以做的
  /*  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getLength(l1);
        int size2 = getLength(l2);
        ListNode head = new ListNode(1);
        // Make sure l1.length >= l2.length
        head.next = size1 < size2 ? helper(l2, l1, size2 - size1) : helper(l1, l2, size1 - size2);
        // Handle the first digit
        if (head.next.val > 9) {
            head.next.val = head.next.val % 10;
            return head;
        }
        return head.next;
    }
    // get length of the list
    public int getLength(ListNode l) {
        int count = 0;
        while(l != null) {
            l = l.next;
            count++;
        }
        return count;
    }
    // offset is the difference of length between l1 and l2
    public ListNode helper(ListNode l1, ListNode l2, int offset) {
        if (l1 == null) return null;
        // check whether l1 becomes the same length as l2
        //若offset不为0 就继续往下递归 保证1和2一样长
        //result为当前节点  post为后继节点
        ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
        ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
        // handle carry
        if (post != null && post.val > 9) {
            result.val += 1;
            post.val = post.val % 10;
        }
        // combine nodes
        result.next = post;
        return result;
    }*/
    public static void main(String[] args) {
        BitSet bitSet=new BitSet();
        bitSet.set(9999999);
        System.out.println(bitSet.length());
        bitSet.clear();
        bitSet.set(100);
        System.out.println(bitSet.length());
    }
}
