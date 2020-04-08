package leetcode;

public class leet1406 {

    //自己写的  dfs+memo
/*    public String stoneGameIII(int[] stoneValue) {
     int []fixSum=new int[stoneValue.length+1];
        for (int i = stoneValue.length - 1; i >= 0; i--) {
            fixSum[i]=(fixSum[i+1]+stoneValue[i]);
        }
       int[]dp=new int[stoneValue.length];
        int alice= dfs(stoneValue,fixSum,dp,0); //alice能获得的最大


        
        if(alice*2>fixSum[0]){
            return "Alice";
        }else if(alice*2==fixSum[0]) return "Tie";
        else return "Bob";
    }

    int dfs(int []storeValue,int[]fixSum,int[]dp ,int index){
        if(dp[index]!=0) return dp[index];
        if(index>=storeValue.length) return 0;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=3;i++){
         max=Math.max(max,fixSum[index]-dfs(storeValue,fixSum,dp,index+i));
        }
        dp[index]=max;
        return max;
    }*/

    //参考自己写的  纯动态规划
    public String stoneGameIII(int[] stoneValue) {
        int sum=0;
        int []dp=new int[stoneValue.length+1];
        for (int i = stoneValue.length - 1; i >= 0; i--) {
            sum+=stoneValue[i];
            dp[i]=Integer.MIN_VALUE;
            for(int j=i+1;j<=i+3&&j<=stoneValue.length;j++){
                dp[i]=Math.max(dp[i],sum-dp[j]);
            }
        }

        if(dp[0]*2>sum){
            return "Alice";
        }else if(dp[0]*2==sum) return "Tie";
        else return "Bob";
    }
}
