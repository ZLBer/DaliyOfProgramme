package leetcode.leetcode1_499;

public class leet329 {

    //mine  注意memo就好了，并且memo不需要考虑太多东西，比如说访问重复等等，递增保证了不会重复使用元素
     public int longestIncreasingPath(int[][] matrix) {
      if(matrix.length==0) return 0;
       int [][]memo=new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(memo[i][j]==0) dfs(memo,matrix,i,j);
            }
        }
        return res;
    }
 int res=0;
     int [][]next=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int dfs(int[][]memo,int [][]matrix,int x,int y){
         if(memo[x][y]>0) return memo[x][y];

         int max=0;
        for (int i = 0; i < next.length; i++) {
            int tx=next[i][0]+x;
            int ty=next[i][1]+y;
            if(tx>=0&&ty>=0&&tx<matrix.length&&ty<matrix[0].length&&matrix[tx][ty]>matrix[x][y]){
            max=Math.max(max,dfs(memo,matrix,tx,ty));
            }

        }
        memo[x][y]=max+1;
        res=Math.max(res,memo[x][y]);
        return memo[x][y];
    }

    public static void main(String[] args) {
     //   longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}});
    }
}
