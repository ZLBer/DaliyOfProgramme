package leetcode.leetcode1_499;

public class leet01 {

    public int numSpecial(int[][] mat) {

        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && check(mat,i,j)){
                    res++;
                }
            }
        }
        return res;

    }
   boolean check(int[][]mat,int i,int j) {
      int count=0;
       for (int k = 0; k < mat[0].length; k++) {
          if(mat[i][k]==0) continue;
          else count++;
       }
      if(count>1) return false;
      count=0;
       for (int k = 0; k < mat.length; k++) {
           if(mat[k][j]==0)continue;
           else count++;
       }
      if(count>1) return false;
      return true;
   }

}
