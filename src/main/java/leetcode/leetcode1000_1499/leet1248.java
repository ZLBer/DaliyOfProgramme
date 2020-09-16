package leetcode.leetcode1000_1499;

import java.util.LinkedList;

public class leet1248 {

    //mine 极其难受
/*
 static    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==1) list.add(i);
        }
        if(list.size()<k) return 0;
        int res=0;
        for(int i=0;i+k-1<list.size();i++){
            int begin=list.get(i);
            int end=list.get(i+k-1);
            int p=0,q=0;
            if(i==0){
                p=(begin+1);
            } else {
                int pre = list.get(i - 1);
                p=(begin-pre);
            }

            if(i+k-1==list.size()-1){
               q=(nums.length-end-1);
            }else {
                int next=list.get(i+k);
               q=(next-end-1);
            }

            if(p==0||q==0)
                res+=(p+q);
            else {
                res+=(p*q+p);
            }
        }
        return res;
    }
*/


    //轻松加两个边界解决很多判断
/*    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        list.add(-1);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==1) list.add(i);
        }
        if(list.size()<k) return 0;
        list.add(nums.length);
        int res=0;
        for (int i = 1,j=i+k-1; j < list.size(); i++,j++) {
            int left=list.get(i)-list.get(i-1);
            int right=list.get(j+1)-list.get(j);
            res+=left*right;
        }
        return res;
    }*/



   //不如上面的好理解 类似于滑动窗口
   static public int numberOfSubarrays(int[] nums, int k) {
        LinkedList<Integer> deq = new LinkedList();
        deq.add(-1);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 1) deq.add(i);
            if (deq.size() > k + 1) deq.pop();
            //加一段前面的距离
            if (deq.size() == k + 1) res += deq.get(1) - deq.get(0);
        }
        return res;
    }

    public static void main(String[] args) {
        numberOfSubarrays(new int[]{1,1,0,0},2);
    }
}
