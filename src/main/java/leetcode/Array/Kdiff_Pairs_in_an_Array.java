package leetcode.Array;

import java.util.Arrays;

/**
 * Created by libin on 2017/10/14.
 */
public class Kdiff_Pairs_in_an_Array {
    public int findPairs(int[] nums, int k) {
        int pairs=0;
        Arrays.sort(nums);
        if(k==0){
            for(int i=0;i<nums.length-1;){
                if(nums[i]==nums[i+1]&&(i==0||nums[i]!=nums[i-1])){
                    pairs++;
                    i+=2;
                }
                else i+=1;
            }
            return pairs;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) {
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]-nums[i]==k) {
                    pairs++;
                    break;
                }
                if(nums[j]-nums[i]>k) break;
            }
        }
        return pairs;
    }
}
