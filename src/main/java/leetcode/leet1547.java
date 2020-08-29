package leetcode;

import java.util.Arrays;

public class leet1547 {

    //mine dfs+dp
   static public int minCost(int n, int[] cuts) {
       Arrays.sort(cuts);
       Integer [][]dp=new Integer[cuts.length][cuts.length];
 return dfs(0,n,0,cuts.length-1,cuts,dp);
    }

   static int dfs(int left,int right,int l,int r,int []cuts,Integer[][]dp) {
       if(l>r){
         return 0;
     }

       if(dp[l][r]!=null) return dp[l][r];
     int cost=Integer.MAX_VALUE;
     for(int i=l;i<=r;i++){
      cost=Math.min(cost,dfs(left,cuts[i],l,i-1,cuts,dp)+dfs(cuts[i],right,i+1,r,cuts,dp)+(right-left));
     }

      return dp[l][r]=cost;
   }


   //直接dp
/*   public int minCost(int n, int[] cuts) {
       List<Integer> list = new ArrayList<>();
       //这个就很巧妙
       list.add(0);
       list.add(n);
       for(int num : cuts){
           list.add(num);
       }
       Collections.sort(list);
       int m = list.size();
       int[][] dp = new int[m][m];
       for(int len = 2; len < m; len++){//枚举区间
           for(int i = 0; i + len < m; i++){//枚举左端点
               int j = i + len;//右端点
               dp[i][j] = Integer.MAX_VALUE;
               // 枚举分割点
               for(int k = i+1; k < j; k++){
                   dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + list.get(j) - list.get(i));
               }
           }
       }
       return dp[0][m-1];
   }*/

    public static void main(String[] args) {
     //   minCost(7,new int[]{1,3,4,5});
    }
}
