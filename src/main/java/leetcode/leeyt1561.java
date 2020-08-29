package leetcode;

import java.util.Arrays;

public class leeyt1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int left=0,right=piles.length-1;
        int res=0;
        while (left<right){
         left++;
         right--;
         res+=piles[right];
         right--;
        }
        return res;
    }
}
