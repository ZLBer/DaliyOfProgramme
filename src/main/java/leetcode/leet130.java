package leetcode;

public class leet130 {
   int [][]move=new int[][]{
           {0,1},{1,0},{-1,0},{0,-1}
   };
    public void solve(char[][] board) {
        if(board.length==0) return;
        boolean[][]visited=new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
           if(board[i][0]=='O') helper(i,0,visited,board);
           if(board[i][board[0].length-1]=='O') helper(i,board[0].length-1,visited,board);
        }

        for (int i = 0; i < board[0].length; i++) {
            if(board[0][i]=='O') helper(0,i,visited,board);
            if(board[board.length-1][i]=='O') helper(board.length-1,i,visited,board);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(!visited[i][j]&&board[i][j]=='O') board[i][j]='X';
            }
        } 
    }
   void helper(int i,int j,boolean[][]visited,char [][]board){

        if(i<0||i>=visited.length||j<0||j>=visited[0].length||visited[i][j]||board[i][j]!='O'){
            return;
        }

     //  System.out.println(i+" "+j);
        visited[i][j]=true;
       for (int k = 0; k < move.length; k++) {
           int nextI=i+move[k][0];
           int nextJ=j+move[k][1];
      helper(nextI,nextJ,visited,board);
       }
   }
}
