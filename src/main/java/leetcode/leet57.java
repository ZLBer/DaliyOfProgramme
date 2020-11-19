package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet57 {

    //难 道是不难 ，就需要考虑多点
  /*  public int[][] insert(int[][] intervals, int[] newInterval) {
       if(intervals.length==0) return new int[][]{newInterval};
       List<int[]> res=new ArrayList<>();
      if(newInterval[1]<intervals[0][0]){
          res.add(newInterval);
          res.addAll(Arrays.asList(intervals));
      }else if(newInterval[0]>intervals[intervals.length-1][1]){
         res.addAll(Arrays.asList(intervals));
         res.add(newInterval);
      }else {
           boolean flag=false;
          for (int i = 0; i < intervals.length; i++) {
             if(intervals[i][1]<newInterval[0]){
                 res.add(intervals[i]);
             }else if(intervals[i][0]>newInterval[1]){
                 if(!flag) {
                   res.add(newInterval);
                   flag=true;
                 }
                 res.add(intervals[i]);
             }
             else {
                 //处理交集部份
                 while (i<intervals.length&&newInterval[1]>=intervals[i][0]){
                     newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
                     newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
                     i++;
                 }
                 flag=true;
                res.add(newInterval);
                 if(i>=intervals.length) break;
                i--;
             }
          }
      }
      int [][]temp=new int[res.size()][2];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=res.get(i);
        }
      return temp;
    }*/

   //比俺的简洁多了  恨啊
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

}
