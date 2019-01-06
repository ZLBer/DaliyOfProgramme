package leetcode;

/**
 * Created by libin on 2018/12/31.
 */
public class leet766 {
   static public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=matrix.length-1;i>0;i--){
            for(int j=1;j<matrix[0].length;j++){
                     if (matrix[i][j]!=matrix[i-1][j-1]) return false;
            }
        }
return  true;
    }

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{
                {1},

        }));
    }
}
