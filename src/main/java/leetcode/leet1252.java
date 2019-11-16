package leetcode;
//contest 162 fighting!
public class leet1252 {
    //mine
/*    public int oddCells(int n, int m, int[][] indices) {
       int [][]matrix=new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            int row=indices[i][0];
            int column=indices[i][1];

            for(int j=0;j<n;j++){
                matrix[j][column]++;
            }
            for(int j=0;j<m;j++){
                matrix[row][j]++;
            }
        }

        int res=0;
        for (int i = 0; i < matrix.length; i++) {
          for(int j=0;j<matrix[0].length;j++){
              if(matrix[i][j]%2==1) res++;
          }
        }
        return res;
    }*/


/*    public int oddCells(int n, int m, int[][] indices) {
    boolean[]row=new boolean[n],col=new boolean[m];
        for (int i = 0; i < indices.length; i++) {
            row[indices[i][0]]^=true;
            col[indices[i][1]]^=true;
        }
        int res=0;
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                    res+=row[i]^col[j]?1:0;
            }
        }
        return res;
    }*/

 /*   public int oddCells(int n, int m, int[][] indices) {
        boolean[] row = new boolean[n], col = new boolean[m];
        int cntRow = 0, cntCol = 0;
        for (int[] idx : indices) {
            row[idx[0]] ^= true;
            col[idx[1]] ^= true;
        }
        //统计奇数行
        for (boolean r : row)
            cntRow += r ? 1 : 0;
        //统计偶数行
        for (boolean c : col)
            cntCol += c ? 1 : 0;
      //奇数和偶数才能组成奇数行
        return (m - cntCol) * cntRow + (n - cntRow) * cntCol;
    }*/

    //可以进一步优化，直接在一个循环里写
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] row = new boolean[n], col = new boolean[m];
        int cntRow = 0, cntCol = 0;
        for (int[] idx : indices) {
            row[idx[0]] ^= true;
            col[idx[1]] ^= true;
            cntRow += row[idx[0]] ? 1 : -1;
            cntCol += col[idx[1]] ? 1 : -1;
        }
        return (m - cntCol) * cntRow + (n - cntRow) * cntCol;
    }

    public static void main(String[] args) {
        System.out.println(false^false);
    }
}
