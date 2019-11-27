package leetcode.leetcode1000_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leet1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
     int i=0,j=0;
     List<Integer> res=new ArrayList<>();
        Arrays.sort(slots1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        Arrays.sort(slots2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
     while (i<slots1.length&&j<slots2.length){
       int start1= slots1[i][0];
       int end1= slots1[i][1];
       int start2=slots2[j][0];
       int end2=slots2[j][1];
   int start=0;
       if(start1>start2){
           start=start1;
       }else {
           start=start2;
       }
int end=0;
       if(end1>end2){
       end=end2;
       }else {
        end=end1;
       }
       int dis=end-start;
       if(dis>=duration){
           res.add(start);
           res.add(start+duration);
           return res;
       }

      if (end1<end2){
          i++;
      }else {
          j++;
      }
     }
     return res;
    }
}
