package leetcode;

public class leet1563 {

    //O(n3) 比较好理解
/*
    public int stoneGameV(int[] stoneValue) {
     int[] presum=new int[stoneValue.length];

     presum[0]=stoneValue[0];
     for (int i = 1; i < stoneValue.length; i++) {
            presum[i]=presum[i-1]+stoneValue[i];
        }

     int [][]dp=new int[stoneValue.length][stoneValue.length];

     for(int length=1;length<stoneValue.length;length++){
        for(int i=0;i+length<stoneValue.length;i++){
            int j=i+length;
            for(int mid=i;mid<j;mid++){

                int ls=presum[mid]-(i==0?0:presum[i-1]);
                int lr=presum[j]-presum[mid];

                if(ls==lr){
                    dp[i][j]=Math.max(dp[i][j],Math.max(dp[i][mid],dp[mid+1][j])+ls);
                }else {
                 if(ls>lr){
                  dp[i][j]=Math.max(dp[i][j],dp[mid+1][j]+lr);
                 }else {
                   dp[i][j]=Math.max(dp[i][j],dp[i][mid]+ls);
                 }
                }

            }
        }
     }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
     return dp[0][stoneValue.length-1];
    }
*/




    //dfs +memo
    Integer[][] map;
    public int stoneGameV(int[] sv) {
        for(int i = 1; i < sv.length; ++i)
            sv[i] += sv[i-1];
        map = new Integer[sv.length][sv.length];
        return next(sv,0,sv.length-1, 0);
    }

    int next(int[] sum, int s, int e, int startV){
        if(s >= e)
            return 0;
        if(map[s][e] != null)
            return map[s][e];
        int max = Integer.MIN_VALUE;
        for(int i = s; i < e; ++i){
            int left = sum[i]-startV, right = sum[e]-sum[i];
            if(left < right){
                int nextV = next(sum, s, i,s>0?sum[s-1]:0);
                if(max < left+nextV)
                    max = left+nextV;
            } else if (left > right){
                int nextV = next(sum, i+1, e, sum[i]);
                if(max < right+nextV)
                    max = right+nextV;
            } else {
                int nextV = Math.max(next(sum,s,i,s>0?sum[s-1]:0),next(sum,i+1,e,sum[i]));
                if(max < left +nextV)
                    max = left+nextV;
            }
        }
        map[s][e] = max;
        return max;
    }


}
