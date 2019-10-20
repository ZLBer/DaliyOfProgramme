package leetcode;

import java.util.Arrays;

public class leetco4 {

    //mine contest之后做出来了
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

      int index=0;
       int [][]job=new int[startTime.length][3];
        for (int i = 0; i < job.length; i++) {
            job[i][0]=startTime[i];
            job[i][1]=endTime[i];
            job[i][2]=profit[i];
        }
        Arrays.sort(job,(a,b)->a[1]-b[1]);
        /*for (int i = 0; i < job.length; i++) {
            System.out.println(job[i][0]+"  "+job[i][1]+" "+job[i][2]);
        }*/
        int []dp=new int[job[job.length-1][1]+1];
        for (int i = 1; i < dp.length; i++) {
          if(job[index][1]>i){
              //没有任何工作适合
              dp[i]=dp[i-1];
              continue;
          }
          dp[i]=Math.max(dp[job[index][0]]+job[index++][2],dp[i-1]);
        while (index<job.length&&job[index][1]==job[index-1][1]){
            System.out.println("test");
            int temp=Math.max(dp[job[index][0]]+job[index][2],dp[i-1]);
            dp[i]=Math.max(dp[i],temp);
            index++;
        }
        }
       /* for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }*/
        return dp[job[job.length-1][1]];
    }

}
