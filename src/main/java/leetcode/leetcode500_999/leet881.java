package leetcode.leetcode500_999;

import java.util.Arrays;

public class leet881 {

    //mine 排序+双指针+贪心
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left=0,right=people.length-1;
        int res=0;
        while (left<=right){
            if(people[left]+people[right]<=limit){
           right--;left++;
                res++;
            }
            else {
                res++;
                right--;
            }
        }
        return res;
    }
}
