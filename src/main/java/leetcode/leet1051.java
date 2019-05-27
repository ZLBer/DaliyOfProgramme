package leetcode;

import java.util.Arrays;

public class leet1051 {
    public int heightChecker(int[] heights) {
      int []order_heights= heights.clone();
        Arrays.sort(order_heights);
        int result=0;
        for (int i = 0; i < heights.length; i++) {
             if(heights[i]!=order_heights[i]) result++;
        }
        return result;
    }
}
