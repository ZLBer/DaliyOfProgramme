package leetcode.leetcode500_999;

public class leet959$ {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length, m = grid[0].length();
        int[][] board = new int[n * 3][m * 3];
        int result=0;
        //构造图
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '/') {
                    board[i * 3][j * 3 + 2] = 1;
                    board[i * 3 + 1][j * 3 + 1] = 1;
                    board[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    board[i * 3][j * 3] = 1;
                    board[i * 3 + 1][j * 3 + 1] = 1;
                    board[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }


//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//            }

        //dfs搜索图
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0){
                    dfs(board, i, j);
                    result++;
                }

            }

        }
        return result;
    }
   void dfs(int [][]board,int i,int j){
  if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]==1) return ;
board[i][j]=1;
   int[][]direction= {
           {0,1},{0,-1},{1,0},{-1,0}
   };
   for(int []dir:direction){
       dfs(board,i+dir[0],j+dir[1]);
   }


  /* //小技巧
    int d[] = {0,-1,0,1,0};
       for(int k=0;k<4;k++){
           dfs(board,i+d[k],j+d[k+1]);
       }*/
   }


  //用并查集来做。看成四个方格，每个方格都分成四个
/*    int count, n;
    int[] f;
    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        f = new int[n * n * 4];
        count = n * n * 4;
        for (int i = 0; i < n * n * 4; ++i)
            f[i] = i;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                //需要和左边或者上边的方格合并
                if (i > 0) union(g(i - 1, j, 2), g(i, j, 0));
                if (j > 0) union(g(i , j - 1, 1), g(i , j, 3));
                if (grid[i].charAt(j) != '/') {
                    //和自己的方格合并
                    union(g(i , j, 0), g(i , j,  1));
                    union(g(i , j, 2), g(i , j,  3));
                }
                if (grid[i].charAt(j) != '\\') {
                    //和自己的方格合并
                    union(g(i , j, 0), g(i , j,  3));
                    union(g(i , j, 2), g(i , j,  1));
                }
            }
        }
        return count;
    }
   //找到这个并查集的根
    public int find(int x) {
        if (x != f[x]) {
            f[x] = find(f[x]);
        }
        return f[x];
    }
    //将两个集合合并
    public void union(int x, int y) {
        x = find(x); y = find(y);
        if (x != y) {
            f[x] = y;
            //合并之后需要把count-1
            count--;
        }
    }
    //返回一个编号
    public int g(int i, int j, int k) {
        return (i * n + j) * 4 + k;
    }*/
}
