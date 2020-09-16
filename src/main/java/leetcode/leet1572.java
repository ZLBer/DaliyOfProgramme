package leetcode;

public class leet1572 {
    public int diagonalSum(int[][] mat) {
        int res=0;
        int mid=mat.length/2;
        for (int i = 0; i < mat.length; i++) {
          res+=mat[i][i];
          res+=mat[mat.length-1-i][i];
        }

        if(mat.length%2==1) res-=mat[mid][mid];
        return res;

    }

    public static void main(String[] args) {

    }
}
