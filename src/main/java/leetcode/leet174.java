package leetcode;

public class leet174 {

    //做了半天还是不对啊
   /* public int calculateMinimumHP(int[][] dungeon) {
        int [][]dp=new int[dungeon.length][dungeon[0].length];
        int [][]min=new int[dungeon.length][dungeon[0].length];
        dp[0][0]=dungeon[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0]=dp[i-1][0]+dungeon[i][0];
            min[i][0]=Math.min(dp[i][0],min[i-1][0]);
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i]=dp[0][i-1]+dungeon[0][i];
            min[0][i]=Math.min(dp[0][i],min[0][i-1]);
        }

        for (int i = 1; i < dungeon.length; i++) {
            for (int j = 1; j < dungeon[0].length; j++) {

                if(dp[i][j-1]>=dp[i-1][j]){
                    dp[i][j]=dp[i][j-1]+dungeon[i][j];
                    min[i][j]=Math.min(dp[i][j],min[i][j-1]);
                }else {
                    dp[i][j]=dp[i-1][j]+dungeon[i][j];
                    min[i][j]=Math.min(dp[i][j],min[i-1][j]);
                }


            }
        }

        int res= -min[dungeon.length-1][dungeon[0].length-1];
       return  res==0?1:res ;
    }
*/

    //转dfs
  /*   public int calculateMinimumHP(int[][] dungeon) {
      int [][]dp=new int[dungeon.length][dungeon[0].length];

      int val=  dfs(0,0,dungeon.length,dungeon[0].length,dungeon,dp);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return val;
    }

   int dfs(int i,int j,int m,int n,int[][]dungeon,int [][]dp){

      if(i<m&&j<n&&dp[i][j]>0){
          return dp[i][j];
      }
      if(i==m-1&&j==n-1){// 到达最后
        int val=Math.max(1-dungeon[i][j],1); //若是正值返回1即可
      dp[i][j]=val;
      }
    else if(i==m-1){ //最后一行
      dp[i][j]=Math.max(dfs(i,j+1,m,n,dungeon,dp)-dungeon[i][j],1);
     }
    else if(j==n-1){
        dp[i][j]=Math.max(dfs(i+1,j,m,n,dungeon,dp)-dungeon[i][j],1);
      }else {
          dp[i][j]=Math.max(Math.min(dfs(i,j+1,m,n,dungeon,dp),dfs(i+1,j,m,n,dungeon,dp))-dungeon[i][j],1);
      }

    return dp[i][j];
    }*/

    public int calculateMinimumHP(int[][] dungeon) {
        int [][]dp=new int[dungeon.length][dungeon[0].length];

        int m=dungeon.length,n=dungeon[0].length;
        dp[m-1][n-1]=Math.max(1-dungeon[m-1][n-1],1);
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if(i==m-1&&j==n-1){
                    continue;
                }else if(i==m-1){
                    dp[i][j]=Math.max(dp[i][j+1]-dungeon[i][j],1);
                }else if(j==n-1){
                    dp[i][j]=Math.max(dp[i+1][j]-dungeon[i][j],1);

                }else {
                    dp[i][j]=Math.max(Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j],1);

                }
            }
        }
        return dp[0][0];
    }

}
