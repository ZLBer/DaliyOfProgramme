package leetcode;

public class leet725 {

    //mine
    public ListNode[] splitListToParts(ListNode root, int k) {
      int count=0;
      ListNode p=root;
      while (p!=null){
          count++;
          p=p.next;
      }
      int groupSize=count/k;
      ListNode[] result=new ListNode[k];
      int index=0;
      int left=count;
      while (root!=null){
          result[index]=root;
          int realSize=groupSize;
          if(groupSize*k<left){
               realSize++;
          }
          ListNode pre=root;
          int trs=realSize;
          while (trs-->0){
              pre=root;
              root=root.next;
          }
          pre.next=null;
          k--;
          left-=realSize;
          index++;

      }
        return result;
    }

  //优雅的代码
 /*   public ListNode[] splitListToParts(ListNode root, int k) {

        ListNode[] res = new ListNode[k];
        if(root==null) return res;
        int n = 0;
        for (ListNode curr = root; curr != null; curr = curr.next) {
            n++;
        }
        int perpart = n / k;
        int remain = n % k;
        ListNode head = root;
        ListNode prev = null;
        for (int i = 0; i < k; i++, remain--) {
            res[i] = head;
            for (int j = 0; j < perpart + (remain > 0 ? 1 : 0); j++) {
                prev = head;
                head = head.next;
            }
            if (prev != null) {
                prev.next = null;
            }

        }
        return res;
    }*/
}
