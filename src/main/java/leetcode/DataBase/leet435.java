package leetcode.DataBase;

import java.util.Arrays;

public class leet435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int last=Integer.MIN_VALUE;
        int res=0;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(interval[0]>=last){
                last=interval[1];
            }else {
               res++;
               last=Math.min(last,interval[1]);
            }
        }
        return res;
    }
}
