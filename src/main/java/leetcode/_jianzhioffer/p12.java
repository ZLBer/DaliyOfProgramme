package leetcode._jianzhioffer;

public class p12 {
    public boolean exist(char[][] board, String word) {

       boolean [][]visited=new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(i,j,board,0,word,visited)) return true;
            }
        }
        return false;
    }

    int [][]next=new int[][]{
            {0,1},{0,-1},{1,0},{-1,0}
    };
    boolean dfs(int x,int y,char[][]board,int index,String word,boolean[][]visited){
      if(index>=word.length()) return true;

     if(word.charAt(index)!=board[x][y]) return false;
    if(index==word.length()-1) return true;
     visited[x][y]=true;
        for (int i = 0; i < next.length; i++) {
            int nextX=x+next[i][0];
            int nextY=y+next[i][1];
           if(nextX>=0&&nextY>=0&&nextX<board.length&&nextY<board[0].length&&!visited[nextX][nextY]){
              if(dfs(nextX,nextY,board,index+1,word,visited)) return true;
           }
        }
       visited[x][y]=false;
       return false;
    }


    //不用visied数组

/*    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }*/


}
