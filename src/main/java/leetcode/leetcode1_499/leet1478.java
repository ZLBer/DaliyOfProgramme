package leetcode.leetcode1_499;

import java.util.Arrays;

public class leet1478 {
    int[][]costs;
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
       costs=new int[houses.length][houses.length];
       memo=new int[k+1][houses.length];
        for (int i = 0; i < houses.length; i++) {
            for (int j = i; j < houses.length; j++) {
                for(int m=i;m<=j;m++){
                     costs[i][j]+=Math.abs(houses[(i+j)/2]-houses[m]);
                }
            }
        }
      return helper(houses,k,0);
    }
    int [][]memo;
   int helper(int []houses,int k,int i){
     if(k==0&&i==houses.length) return 0;
     if(k==0||i==houses.length) return 100*10000+1;
     if(memo[k][i]!=0) return memo[k][i];
     int ans=100*10000+1;
     for(int j=i;j<houses.length;j++){
         ans=Math.min(ans,costs[i][j]+helper(houses,k-1,j+1));
     }
     return memo[k][i]=ans;
   }
}
