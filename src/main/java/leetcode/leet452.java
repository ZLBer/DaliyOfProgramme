package leetcode;

import java.util.Arrays;
public class leet452 {
    public int findMinArrowShots(int[][] points) {

       if(points.length==0||points==null) return 0;
        Arrays.sort(points,(a,b)->(a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0])));

        int [] union=points[0];
        int res=0;
        for (int[] point : points) {
          if(point[0]<=union[1]){
           union[0]=Math.max(union[0],point[0]);
           union[1]=Math.min(union[1],point[1]);
          }else {
           res++;
           union=point;
          }

        }
        return res+1;
    }
}
