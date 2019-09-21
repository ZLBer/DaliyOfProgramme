package leetcode.leetcode500_999;

/**
 * Created by libin on 2018/12/31.
 */
public class leet867 {
    public int[][] transpose(int[][] A) {
    int transposeA[][]=new int[A[0].length][A.length];
    for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
            transposeA[j][i]=A[i][j];
        }
    }
        return transposeA;
    }

    public static void main(String[] args) {

    }
}
