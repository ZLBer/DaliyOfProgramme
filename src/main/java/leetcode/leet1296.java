package leetcode;

import java.util.*;

public class leet1296 {

    //mine 用List慢慢构造，当list长度等于k时，删除这个list，每次都要遍历所有的list
    //超级慢啊
/*    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList(nums[0])));
        for (int i = 1; i < nums.length; i++) {
            boolean flat=true;
            int index=-1;
            for (int j = 0; j < ans.size(); j++) {
                List<Integer> an=ans.get(j);
                if(an.size()<k&&an.get(an.size()-1)+1==nums[i]){
                    an.add(nums[i]);
                    flat=false;
                    index=j;
                    break;
                }
            }

            if(flat){
                ans.add(new ArrayList<>(Arrays.asList(nums[i])));
            }else {
                if(ans.get(index).size()==k) {
                    ans.remove(index);
                }
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            if(ans.get(i).size()!=k) return false;
        }
        return true;
    }*/

   //用PriorityQueue和Map来做
    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if(len % k != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        for(int n: map.keySet())
            pq.add(n);
        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(map.get(cur) == 0) continue;
            int times = map.get(cur);
            //需要遍历所有的情况
            for(int i = 0; i < k; i++){
                if(!map.containsKey(cur + i) || map.get(cur + i) < times)
                    return false;
                map.put(cur + i, map.get(cur + i) - times);
            }
        }
        return true;
    }
}
