package leetcode.leetcode500_999;

import java.util.Collections;
import java.util.HashMap;

/**
 * Created by libin on 2019/1/2.
 */
public class leet697 {
    //利用map类型  存放每个nums[i] 的最左出现位置，最右出现位置  以及 出现的次数
    //得出最大count的key 然后返回right-left
    public int findShortestSubArray(int[] nums) {
        HashMap <Integer,Integer> left=new HashMap<>(),right=new HashMap<>(),count=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(left.get(nums[i])==null)  left.put(nums[i],i);
            right.put(nums[i],i);
            count.put(nums[i],count.getOrDefault(nums[i], 0)+1);
        }
        int degree= Collections.max(count.values());
        int ans=nums.length;
        for(int i:count.keySet()){
            if(count.get(i)==degree)
                ans = Math.min(ans, right.get(i) - left.get(i) + 1);
        }
        return  ans;
    }

//思路一样，只用了一个Map 存的是长度为3的数组，第一个元素是出现次数，第二个是最左索引，第二个是最右索引
//    public int findShortestSubArray(int[] nums) {
//        if (nums.length == 0 || nums == null) return 0;
//        Map<Integer, int[]> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++){
//            if (!map.containsKey(nums[i])){
//                map.put(nums[i], new int[]{1, i, i});  // the first element in array is degree, second is first index of this key, third is last index of this key
//            } else {
//                int[] temp = map.get(nums[i]);
//                temp[0]++;
//                temp[2] = i;
//            }
//        }
//        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
//        for (int[] value : map.values()){
//            if (value[0] > degree){
//                degree = value[0];
//                res = value[2] - value[1] + 1;
//            } else if (value[0] == degree){
//                res = Math.min( value[2] - value[1] + 1, res);
//            }
//        }
//        return res;
//    }
}
