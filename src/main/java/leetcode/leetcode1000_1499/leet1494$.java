package leetcode.leetcode1000_1499;

import java.util.Arrays;

public class leet1494$ {
    //状态压缩+ 枚举子集
    //别搞了 ，自己写不出来  枚举子集都没听说过
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
   int N=1<<n;
   int []preCourse=new int[n];
   //1.先求先行课程
        for (int i = 0; i < dependencies.length; i++) {
            preCourse[dependencies[i][1]-1]|=(1<<(dependencies[i][0]-1));
        }
        int []setPre=new int[N];
        boolean []valid=new boolean[N];
       for(int mask=0;mask<N;mask++){
           if(Integer.bitCount(mask)<=k){
               for(int i=0;i<n;i++){
                   if((mask&(1<<i))>0){ //mask里有这么课
                      //计算状态mast需要的先导课程。也就是修这些课程，需要先修哪些课程
                       setPre[mask]|=preCourse[i];
                   }
               }
              //如果mask包含自己的先导课程，则说明这个mask无效
             valid[mask]=((mask&setPre[mask])==0);

           }
       }
        int []dp=new int[N];
       Arrays.fill(dp,Integer.MAX_VALUE/2);
     dp[0]=0;
       for(int mask=0;mask<N;mask++){
         for(int subset=mask;subset>0;subset=mask&(subset-1)){   //枚举子集的方式
             if(valid[subset]&&((mask&setPre[subset])==setPre[subset])){  //首先subset是好状态，其次mask需要已经包含subset的先修课
                 dp[mask]=Math.min(dp[mask],dp[mask^subset]+1);  //dp更新，取最小  ，mask^subset 是求之前的状态
             }
         }
     }
     return dp[N-1];
    }
}
