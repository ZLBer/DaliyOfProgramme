package leetcode;

import java.util.Arrays;

public class leet1402 {
    //mine 类似贪心
  /*  public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max=0;
        for (int i = 0; i < satisfaction.length; i++) {
           int tmax=0;
           int index=1;
            for(int j=i;j<satisfaction.length;j++){
              tmax+=satisfaction[j]*(index++);
           }
            max=Math.max(tmax,max);
        }
        return max;
    }*/

    //其实不用两趟变历 从大到小变历就行
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum=0;
        int ans=0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
           sum+=satisfaction[i];
           if(sum<0) break;
           ans+=sum;
        }
        return ans;
    }
}
