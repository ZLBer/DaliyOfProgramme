package leetcode.tianchi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class tianchi02 {
  static   public int maxValue(int[][] meeting, int[] value) {
        // write your code here
        List<int[]> list = new ArrayList<>(meeting.length);
        for (int i = 0; i < meeting.length; i++) {
            list.add(new int[]{meeting[i][0], meeting[i][1], value[i]});
        }

        Collections.sort(list, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
return  helper(-1,0,new Integer[list.size()],new Integer[list.size()],list);

    }
 static   int  helper(int pre,int i,Integer []dp,Integer[]dp1,List<int []>list){
       if(i>=list.size()) {
           return 0;
       }
        int []point=list.get(i);

     int max=0;

      if(point[0]>=pre){
          if(dp[i]!=null&&dp1[i]!=null) return Math.max(dp[i],dp1[i]);
         if(dp[i]!=null){
             max=dp[i];
         }else {
             dp[i]=helper(point[1],i+1,dp,dp1,list)+point[2];
             max=dp[i];
         }

      }

     if(dp1[i]!=null) return Math.max(dp1[i],max);
     dp1[i]=helper(pre,i+1,dp,dp1,list);
     max=Math.max(max,dp1[i]);

   return max;
   }

    public static void main(String[] args) {
        maxValue(new int[][]{
                {10,30},{25,80}
        },new int[]{3,6});
    }



    public class Solution {
        /**
         * @param meeting: the meetings
         * @param value: the value
         * @return: calculate the max value
         */
        public int maxValue(int[][] meeting, int[] value) {
            // write your code here
            List<int[]> list = new ArrayList<>(meeting.length);
            for (int i = 0; i < meeting.length; i++) {
                list.add(new int[]{meeting[i][0], meeting[i][1], value[i]});

            }

            Collections.sort(list, (int[] a, int[] b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            });
         return    helper(-1,0,new Integer[list.size()],list);

        }
        int  helper(int pre,int i,Integer []dp,List<int []>list){
            if(i>=dp.length) {
                return 0;
            }
            int []point=list.get(i);

            int max=0;
            if(point[0]>=pre){ //可以占用该房间
                if(dp[i]!=null){
                    max=dp[i];

                }else {
                    max= helper(point[1],i+1,dp,list)+point[2];
                    dp[i]=max; //dp表示占用这个房间的最大fit
                }

            }

            max=Math.max(max,helper(pre,i+1,dp,list)); //汇总占用和不占用的fit
          return max;
        }
    }


}
