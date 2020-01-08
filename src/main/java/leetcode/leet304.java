package leetcode;

public class leet304 {

    //mine  居然没TLe
 /*   class NumMatrix {
        int[][]matrix;
        public NumMatrix(int[][] matrix) {
      this.matrix=matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
             int sum=0;
             for(int i=row1;i<=row2;i++){
                 for(int j=col1;j<=col2;j++){
                     sum+=matrix[i][j];
                 }
             }
             return sum;
        }
    }*/

    //mine 还可以这样  求前n项和
    class NumMatrix {
        int [][]preSum;
        public NumMatrix(int[][] matrix) {
            if(matrix.length==0) return;
            preSum=new int[matrix.length+1][matrix[0].length+1];
            for (int i = 0; i < matrix.length; i++) {
                int sum=0;
                for (int j = 0; j < matrix[0].length; j++) {
                    if(i!=0){

                        preSum[i+1][j+1]=preSum[i][j+1];
                    }
                    sum+=matrix[i][j];
                    preSum[i+1][j+1]+=sum;
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2+1][col2+1]+preSum[row1][col1]-preSum[row1][col2+1]-preSum[row2+1][col1];
        }
    }
}
