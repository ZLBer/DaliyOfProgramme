package leetcode._4_30Days;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueNumber {
    class FirstUnique {
        Map<Integer,DoubleLink> set=new HashMap<>();
        DoubleLink head=new DoubleLink(null,null,-1);
        DoubleLink tail=new DoubleLink(head,null,-1);
        public FirstUnique(int[] nums) {
        head.next=tail;
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int showFirstUnique() {
       if(head.next==null) return -1;
       else return head.next.val;
        }

        public void add(int value) {
        if(set.containsKey(value)){
            remove(value);
        }else {
            DoubleLink t=new DoubleLink(tail.pre,tail,value);
            tail.pre.next=t;
            tail.pre=t;
           set.put(value,t);
        }
        }
        void remove(int value){
           DoubleLink p=set.get(value);
           if(p==null) return; //表示已经大于2个了
           p.pre.next=p.next;
           p.next.pre=p.pre;
           set.put(value,null);
        }
    }

    class DoubleLink{
        DoubleLink pre;
        DoubleLink next;
        int val;

        public DoubleLink(DoubleLink pre, DoubleLink next, int val) {
            this.pre = pre;
            this.next = next;
            this.val = val;
        }
    }
}
