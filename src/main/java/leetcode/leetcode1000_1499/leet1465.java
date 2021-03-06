package leetcode.leetcode1000_1499;

import java.util.Arrays;

public class leet1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
       // System.out.println(horizontalCuts[0]);;
     long maxh=horizontalCuts[0]-0,maxv=verticalCuts[0]-0;
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxh=Math.max(horizontalCuts[i]-horizontalCuts[i-1],maxh);
        }
        maxh=Math.max(maxh,h-horizontalCuts[horizontalCuts.length-1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            maxv=Math.max(verticalCuts[i]-verticalCuts[i-1],maxv);
        }
        maxv=Math.max(maxv,w-verticalCuts[verticalCuts.length-1]);
       return (int)((maxh*maxv)%1000000007);
    }
}
