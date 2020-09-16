package leetcode.leetcode1000_1499;

import java.util.Arrays;

/**
 * Created by libin on 2019/4/8.
 */
public class leet1024 {
    //贪心法
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips,(a,b)->a[0]-b[0]);

        int end=0;
        int count=0;

        for(int i=0;i<clips.length;){
            if(clips[i][0]>end) return -1;
          int newend=end;
            while (i<clips.length&&clips[i][0]<=end)
                newend=Math.max(newend,clips[i++][1]);

            count++;
            end=newend;


            if(end>=T)
                return count;
        }
        return -1;
    }
}
