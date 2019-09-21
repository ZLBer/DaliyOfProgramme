package leetcode.leetcode500_999;

import java.util.Arrays;

public class leet960$ {
    public int minDeletionSize(String[] A) {
        //dp表示最大的递增串
    int []dp=new int[A[0].length()];
    Arrays.fill(dp,1);
    int res=Integer.MAX_VALUE;
    for(int j=0;j<A[0].length();j++){
        for(int i=0;i<j;i++){
            int k=0;
            for(;k<A.length;k++){
                if(A[k].charAt(i)>A[k].charAt(j)){
                    break;
                }
                if(k==A.length-1&&dp[j]<dp[i]+1){
                    dp[j]=dp[i]+1;
                }
            }
        }
        //n-最大=最小
        res=Math.min(res,A[0].length()-dp[j]);
    }
    return  res;
    }
}
