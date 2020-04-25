package leetcode.leetcode1000_;

public class leet1292 {

    //mine 用一个矩阵暂存前n项和
/*    public int maxSideLength(int[][] mat, int threshold) {

        int [][] row=new int[mat.length][mat[0].length];
     //   int [][]col=new int[mat.length][mat[0].length];
       //  int[][]dp=new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            int sum=0;
            for (int j = 0; j < mat[0].length; j++) {
                sum+=mat[i][j];
                row[i][j]=sum;
            }
        }

  *//*      for (int i = 0; i < mat[0].length; i++) {
            int sum=0;
            for (int j = 0; j < mat.length; j++) {
                sum+=mat[j][i];
                col[j][i]=sum;
            }
        }*//*

    *//*    for (int i = 0; i < mat.length; i++) {
            if(mat[0][i]<=threshold) dp[0][i]=1;
        }
        for (int i = 0; i < mat[0].length; i++) {
            if(mat[i][0]<=threshold) dp[i][0]=1;
        }*//*


       int length=Math.min(mat[0].length,mat.length);
       for(;length>1;length--){
          for(int r=0;r+length<=mat.length;r++){
              for(int c=0;c+length<=mat[0].length;c++){
                   int rowBegin=r,rowEnd=r+length-1;
                   int colBegin=c,colEnd=c+length-1;
                  if(cost(row,rowBegin,rowEnd,colBegin,colEnd)<=threshold)
                      return length;
              }
          }
       }
return 0;
        
    }

    int cost(int [][]row,int rowBegin,int rowEnd,int colBegin,int colEnd){
        int sum=0;
     for(int i=rowBegin;i<=rowEnd;i++){
         if(colBegin==0) sum+=row[i][colEnd];
        else  sum+=(row[i][colEnd]-row[i][colBegin-1]);
     }
     return sum;
    }*/

    // 另一种preSum  求一个矩阵块的preSum
  /*  public int maxSideLength(int[][] mat, int threshold) {
     int[][]preSum=new int[mat.length+1][mat[0].length+1];


     //求preSum
        for (int i = 0; i < mat.length; i++) {
            int sum=0;
            for (int j = 0; j < mat[0].length; j++) {
                sum+=mat[i][j];
                preSum[i+1][j+1]=(preSum[i][j+1]+sum);
            }
        }


        for(int k = Math.min(mat.length, mat[0].length)-1; k > 0; k--) {
            for(int i = 1; i+k <= mat.length; i++) {
                for(int j = 1; j+k <= mat[0].length; j++) {
                    if(preSum[i+k][j+k] - preSum[i-1][j+k] - preSum[i+k][j-1] + preSum[i-1][j-1] <= threshold) {
                        return k+1;
                    }
                }
            }
        }

        return 0;
    }*/



    //可以直接一次遍历  这个就太巧妙了吧
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];

        int res = 0;
        int len = 1; // square side length

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //每次循环也都要计算前sum和
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
                //顺便计算以len为边长，i,j为右下角的方块   比之前的三重循环要效率高
                if (i >= len && j >= len && sum[i][j] - sum[i-len][j] - sum[i][j-len] + sum[i-len][j-len] <= threshold)
                    res = len++;
            }
        }

        return res;
    }



   /* int m, n;

    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];

        //也是要先计算preSum
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
            }
        }


        //根据边长进行二分搜索 增加了从大到小进行搜索的线性顺序
        int lo = 0, hi = Math.min(m, n);

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isSquareExist(sum, threshold, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }


    private boolean isSquareExist(int[][] sum, int threshold, int len) {
        for (int i = len; i <= m; i++) {
            for (int j = len; j <= n; j++) {
                if (sum[i][j] - sum[i-len][j] - sum[i][j-len] + sum[i-len][j-len] <= threshold) return true;
            }
        }
        return false;
    }*/
}
