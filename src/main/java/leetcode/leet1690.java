package leetcode;

public class leet1690 {

    public int stoneGameVII(int[] stones) {
     int []sum=new int[stones.length+1];
      //求前缀和
        for (int i = 0; i < stones.length; i++) {
            sum[i+1]=sum[i]+stones[i];
        }

        //dp表示先手拿能得到的最大收益
       int[][]dp=new int[stones.length][stones.length];
     for(int len=1;len<stones.length;len++){
       for(int begin=0;begin+len<stones.length;begin++){
           if(len==1){
          dp[begin][begin+len]=Math.max(stones[begin],stones[begin+len]);
           }else {
          dp[begin][begin+len]=Math.max(sum[begin+len+1]-sum[begin+1]-dp[begin+1][begin+len],sum[begin+len]-sum[begin]-dp[begin][begin+len-1]);

           }
       }
     }
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp.length; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        return dp[0][stones.length-1];

    }
}
