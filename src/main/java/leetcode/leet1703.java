package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet1703 {


    //TLE
 /*   public int minMoves(int[] nums, int k) {
        Deque<Integer> deque=new LinkedList<>();

        int pre=-1;
        int i=0;
        for (i = 0; i < nums.length; i++) {
            if(nums[i]==1) {
                pre=i;
                break;
            }
        }

        int res=Integer.MAX_VALUE;
        for (i++; i < nums.length; i++) {
            if(nums[i]==1){
                deque.addLast(i-pre-1);
                if(deque.size()>k-1) {
                    deque.pollFirst();

                }
                if(deque.size()==k-1) res=Math.min(res,helper(new LinkedList<>(deque)));
                pre=i;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }


    int helper(Deque<Integer> deque){
        int res=0;
        int round=1;
        while (deque.size()>=2){
            Integer first = deque.pollFirst();
            Integer last = deque.pollLast();
            res+=(first+last)*(round++);
        }

        if(deque.size()==1){
            res+=deque.poll()*round;
        }
        return res;
    }*/


  static   public int minMoves(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        sum.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {

                //g是最难想到的 用 index-第几个1，方便后期算交换次数
                int g = i - list.size();
                list.add(g);
                sum.add(sum.get(sum.size() - 1) + g);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int begin = 0; begin + k <= list.size(); begin++) {
            int mid=(begin+k-1+begin)/2;
            int q=list.get(mid);
            //计算左右两边到mid的距离
            int left=q*(mid-begin) -sum.get(mid)-sum.get(begin);
            int right=sum.get(begin+k)-sum.get(mid+1)-q*(begin+k-1-mid);
            res = Math.min(left+right,res);
        }

        return res== Integer.MAX_VALUE?0:res;

    }


    public static void main(String[] args) {
   minMoves(new int[]{0,1,1,0,0,1,0,0,0},3);
    }


}
