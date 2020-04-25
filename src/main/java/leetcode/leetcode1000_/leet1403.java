package leetcode.leetcode1000_;

public class leet1403 {

    //mine 排序
/*    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums );
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        List<Integer> list=new ArrayList<>();
        int tsum=0;
        for (int i = nums.length - 1; i >= 0; i--) {
            tsum+=nums[i];
            list.add(nums[i]);
            if(tsum>sum/2) return list;
         }
        return list;
    }*/


   //堆来做  java10
/*
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int sub_sum = 0, total_sum = 0;
        for (var n : nums) {
            pq.offer(n);
            total_sum += n;
        }
        while (sub_sum <= total_sum / 2) {
            res.add(pq.peek());
            sub_sum += pq.poll();
        }
        return res;
    }
*/

    //比较一下效率
/*    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sub_sum = 0, total_sum = 0;
        for (int n : nums) {
            pq.offer(n);
            total_sum += n;
        }
        while (sub_sum <= total_sum / 2) {
            res.add(pq.peek());
            sub_sum += pq.poll();
        }
        return res;
    }*/


    public static void main(String[] args) {
    }
}
