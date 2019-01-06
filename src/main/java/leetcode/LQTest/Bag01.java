package leetcode.LQTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by libin on 2018/3/28.
 */
public class Bag01 {
   public static int DP(int []weight,int []value,int capacity){
        int [][]dp=new int[weight.length][capacity+1];
        for(int i=0;i<weight[0]-1;i++){
            dp[0][i]=0;
        }
        for(int i=weight[0];i<capacity;i++){
            dp[0][i]=value[0];
        }
      for(int i=1;i<weight.length;i++){
            int jmax=Integer.min(weight[i],capacity);
            for(int j=0;j<jmax;j++)
                dp[i][j]=dp[i-1][j];
          for(int j=jmax;j<=capacity;j++){
    dp[i][j]=Integer.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
          }
      }
      return dp[weight.length-1][capacity];
    }

    public static void main(String[] args) {

        Pattern pattern=Pattern.compile("baike*");
        Matcher matcher=pattern.matcher("baik");
        System.out.println(matcher.matches());
    //    System.out.println(DP(new int[]{2,1,3,2},new int[] {12,10,20,15},5));

    }
}
