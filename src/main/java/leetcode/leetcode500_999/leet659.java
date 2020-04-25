package leetcode.leetcode500_999;

import java.util.HashMap;
import java.util.Map;

public class leet659 {
    //仿写
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> freq=new HashMap<>(),append=new HashMap<>();
        for(int num:nums) freq.put(num,freq.getOrDefault(num,0)+1);
        for(int num:nums){
            if(freq.get(num)==0) continue;
            else if(append.getOrDefault(num,0)>0){
                append.put(num, append.get(num)-1);
                append.put(num+1,append.getOrDefault(num+1,0)+1);
            }else if(freq.getOrDefault(num+1,0)>0&&freq.getOrDefault(num+2,0)>0){
                freq.put(num+1,freq.get(num+1)-1);
                freq.put(num+2,freq.get(num+2)-1);

                append.put(num+3,append.getOrDefault(num+3,0)+1);
            }else return false;
            freq.put(num,freq.get(num)-1);
        }
        return true;
    }


    //纯变量存储  https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/106495/Java-O(n)-time-and-O(1)-space-solution-greedily-extending-shorter-subsequence
/*    public boolean isPossible(int[] nums) {
        int pre = Integer.MIN_VALUE;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        int cur = 0;
        int cnt = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        for (int i = 0; i < nums.length; pre = cur, p1 = c1, p2 = c2, p3 = c3) {
            for (cur = nums[i], cnt = 0; i < nums.length && cur == nums[i]; i++) {
                cnt++;
            }

            //最开始的情况
            if (cur != pre + 1) {
                if (p1 != 0 || p2 != 0) {
                    return false;
                }

                c1 = cnt;
                c2 = 0;
                c3 = 0;

            } else {
                if (cnt < p1 + p2) {
                    return false;
                }

                c1 = Math.max(0, cnt - (p1 + p2 + p3));
                c2 = p1;
                c3 = p2 + Math.min(p3, cnt - (p1 + p2));
            }
        }

        return (p1 == 0 && p2 == 0);
    }*/
}
