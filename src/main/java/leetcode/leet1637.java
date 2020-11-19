package leetcode;

import java.util.Arrays;

public class leet1637 {
    //啊这..
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(a,b)->a[0]-b[0]);
        int res=0;
        for (int i = 1; i < points.length; i++) {
           res=Math.max(points[i][0]-points[i-1][0],res);
        }
        return res;
    }
}
