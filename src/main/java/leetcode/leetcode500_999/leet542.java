package leetcode.leetcode500_999;

public class leet542 {
  //TLE  48/48
/*    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==1) matrix[i][j]=bfs(i,j,matrix,new boolean[matrix.length][matrix[0].length]);
            }
        }
        return matrix;
    }
   int [][]next=new int[][]{
           {0,1},{0,-1},{1,0},{-1,0}
   };
    int bfs(int i,int j,int [][]matrix,boolean[][]visited){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{i,j});
        int length=0;
        visited[i][j]=true;
        while (!queue.isEmpty()){
            length++;
            int size=queue.size();
            while (size-->0){
                int []point=queue.poll();
                for (int k = 0; k < next.length; k++) {
                    int nextX=point[0]+next[k][0];
                    int nextY=point[1]+next[k][1];
                    if(nextX>=0&&nextX<matrix.length&&nextY>=0&&nextY<matrix[0].length&&!visited[nextX][nextY]){
                        if(matrix[nextX][nextY]==0) return length;
                        else {
                            queue.offer(new int[]{nextX,nextY});
                        }
                        visited[nextX][nextY]=true;
                    }
                }
            }
        }
        return 0;
    }*/


   //从0 到1

/*    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue=new LinkedList<>();
        boolean [][]visited=new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0) {
                    queue.offer(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        int length=0;
        while (!queue.isEmpty()){
            length++;
            int size=queue.size();
            while (size-->0){
                int []point=queue.poll();
                for (int k = 0; k < next.length; k++) {
                    int nextX=point[0]+next[k][0];
                    int nextY=point[1]+next[k][1];
                    if(nextX>=0&&nextX<matrix.length&&nextY>=0&&nextY<matrix[0].length&&!visited[nextX][nextY]){
                       matrix[nextX][nextY]=length;
                       queue.offer(new int[]{nextX,nextY});
                       visited[nextX][nextY]=true;
                    }
                }
            }
        }
        return matrix;
    }*/
 static    int [][]next=new int[][]{
            {0,1},{0,-1},{1,0},{-1,0}
    };




 //DFS
 /*   public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0)
            return matrix;

        // Initialize, only "1" who neighbors "0" is determined. Kind of path trimming.
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 1 && !hasNeiberZero(i, j, matrix))
                    matrix[i][j] = matrix.length + matrix[0].length + 1;

        // Start from the determined "1"
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 1)
                    dfs(matrix, i, j, 1);

        return matrix;
    }

    private void dfs(int[][] matrix, int x, int y, int val) {
        // Base case. Boundary condition and new value who is larger than the previous found value, terminates.
        if (x < 0 || y < 0 || y >= matrix[0].length || x >= matrix.length || (matrix[x][y] < val)) {
            return;
        }

        // Set it as new value
        matrix[x][y] = val;

        dfs(matrix, x + 1, y, matrix[x][y] + 1);
        dfs(matrix, x - 1, y, matrix[x][y] + 1);
        dfs(matrix, x, y + 1, matrix[x][y] + 1);
        dfs(matrix, x, y - 1, matrix[x][y] + 1);
    }

    private boolean hasNeiberZero(int x, int y, int[][] matrix) {
        if (x - 1 >= 0 && matrix[x - 1][y] == 0)
            return true;
        if (x + 1 < matrix.length && matrix[x + 1][y] == 0)
            return true;
        if (y - 1 >= 0 && matrix[x][y - 1] == 0)
            return true;
        if (y + 1 < matrix[0].length && matrix[x][y + 1] == 0)
            return true;

        return false;
    }*/



  //DP  从左上和右下进行遍历
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;
            }
        }

        // 从左上角开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        // 从右下角开始
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }


    public static void main(String[] args) {
      //  updateMatrix(new int[][]{{0,1,0},{1,1,1}});
    }
}
