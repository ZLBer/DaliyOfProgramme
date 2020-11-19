package leetcode;

public class leet474 {
    public int findMaxForm(String[] strs, int m, int n) {
      int [][]dp=new int[m+1][n+1];
        for (String str : strs) {
           int []count=countZero(str);
            for(int zero=m;zero>=count[0];zero--){
               for(int one=n;one>=count[1];one--){
                   dp[zero][one]=Math.max(dp[zero][one],dp[zero-count[0]][one-count[1]]+1);
               }
         }
        }
        return dp[m][n];
    }

    int [] countZero(String str){
        int []count=new int[2];
        for (char c : str.toCharArray()) {
            count[c-'0']++;
        }
        return count;
    }
}
