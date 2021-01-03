package leetcode;

import java.util.Arrays;

public class leet1665 {

    public int minimumEffort(int[][] tasks) {
      int sum=0;
        Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
      int cur=0;
        for (int i = 0; i < tasks.length; i++) {
            sum+=Math.max(0,tasks[i][1]-cur);

            cur=Math.max(tasks[i][1],cur);
            System.out.println(sum+" "+cur);
          cur-=tasks[i][0];
         }
       return sum;
    }
}
