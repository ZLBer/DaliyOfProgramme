package leetcode.leetcode1000_;

public class leet1043$ {
    public int maxSumAfterPartitioning(int[] A, int K) {
    int []dp=new int[A.length];

    for(int i=0;i<A.length;i++){
        int curMax=0;
        for(int k=1;k<=K&&i-k+1>=0;k++){
            //查找此段最大的值
            curMax=Math.max(curMax,A[i-k+1]);
            dp[i]=Math.max(dp[i],(i>=k?dp[i-k]:0)+curMax*k);
        }
    }
      return  dp[A.length-1];
    }
}
