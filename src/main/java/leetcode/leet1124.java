package leetcode;
import	java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.List;

public class leet1124 {
/*    public int longestWPI(int[] hours) {

       int result =0;
       int []temps=new int[hours.length];
       int temp=0;
        for (int i = 0; i < hours.length; i++) {
              if(hours[i]>8) temp++;
              else temp--;

              if(temp>0){
                  result=Math.max(result,i+1);
              }
              temps[i]=temp;
        }
      for(int i=0;i<temps.length;i++){
          for(int j =i+1;j<temps.length; j++){
              if (temps[j]-temps[i]>0){
                  result=Math.max(result, j-i+1);
              }
          }
      }

        return result;
    }*/

    // 牛皮的做法

    /*
     *
     *
 If the score is a new lowest score, we record the day by seen[cur] = i.
seen[score] means the first time we see the score is seen[score]th day.

We want a positive score, so we want to know the first occurrence of score - 1.
score - x also works, but it comes later than score - 1.
So the maximum interval is i - seen[score - 1]
*
* 例如：score=-1 score-1=-2  从开始这个位置是-2
*  那么 -2-（-1）=1 严格大于0  此段区间符合条件
* 也可以去 score-x  但比score-1靠后
     */
    public int longestWPI(int[] hours) {
        int res = 0, score = 0, n = hours.length;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1;
            } else {
                seen.putIfAbsent(score, i);
                if (seen.containsKey(score - 1))
                    res = Math.max(res, i - seen.get(score - 1));
            }
        }
        return res;
    }
}
