package leetcode;

import java.util.List;

public class leet1301$ {
    //DFS 无论咋优化都超时  看来就是得DP
/*    public int[] pathsWithMaxScore(List<String> board) {

        int row=board.size();
        int col=board.get(0).length();
        int[][]boards=new int[row][col];
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[0].length; j++) {
                char c=board.get(i).charAt(j);
                if(c=='X') boards[i][j]=-1;
                else if(c<='9'&&c>='0'){
                    boards[i][j]=c-'0';
                }
            }
        }
  DFS(boards,row-1,col-1,0);
  if(map.size()==0){
      return  new int[]{0,0};
  }
  int key=0;
  for( int k: map.keySet()){
 key=Math.max(k,key);
  }
        return new int[]{key,map.get(key)};
    }
    int max=0;
    Map<Integer,Integer> map=new HashMap<>();
    int [][]next=new int[][]{{0,-1},{-1,0},{-1,-1}};


   void DFS(int[][]boards,int x,int y,int score){
       if(x==0&&y==0){
           if(score<max) return;
      map.put(score,map.getOrDefault(score,0)+1);
           max= Math.max(max,score);
           return;
       }
       for (int i = 0; i < next.length; i++) {
         int tx=x+next[i][0];
         int ty=y+next[i][1];
           if(tx>=0&&ty>=0&&boards[tx][ty]!=-1){
               if(tx==0&&ty==0)   DFS(boards,tx,ty,score);
               else
          DFS(boards,tx,ty,score+boards[tx][ty]);
           }
       }
   }*/

   //正宗dp来啦 反正我写不出来
   private static final int[][] DIRS = new int[][]{{0, -1}, {-1, 0}, {-1, -1}};
    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.size(), n = board.get(0).length();
        //一个存score一个存个数
        int[][] dpSum = new int[m][n];
        int[][] dpCnt = new int[m][n];
        dpCnt[m - 1][n - 1] = 1; // start at the bottom right square
        //从右下角开始
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                //跳过障碍物
                if (dpCnt[r][c] == 0) continue; // can't reach to this square
                //方向遍历
                for (int[] dir : DIRS) {
                    //下一个位置
                    int nr = r + dir[0], nc = c + dir[1];
                    //检验合格
                    if (nr >= 0 && nc >= 0 && board.get(nr).charAt(nc) != 'X') {
                        int nsum = dpSum[r][c];
                        //变表示未达到目的地
                        if (board.get(nr).charAt(nc) != 'E')
                            //更新分数
                            nsum += board.get(nr).charAt(nc) - '0';
                        //若比之前的分数高
                        if (nsum > dpSum[nr][nc]) {
                            //重新设置count和sum
                            dpCnt[nr][nc] = dpCnt[r][c];
                            dpSum[nr][nc] = nsum;

                            //只更新count
                        } else if (nsum == dpSum[nr][nc]) {
                            //结果要mod
                            dpCnt[nr][nc] = (dpCnt[nr][nc] + dpCnt[r][c]) % 1000000007;
                        }
                    }
                }
            }
        }
        return new int[]{dpSum[0][0], dpCnt[0][0]};
    }








    //自己模仿一遍  会模仿才会进步

   /* private static final int[][] next = new int[][]{{0, -1}, {-1, 0}, {-1, -1}};
    public int[] pathsWithMaxScore(List<String> board) {
        int m=board.size(),n=board.get(0).length();
        int [][]score=new int[m][n];
        int [][]count=new int[m][n];
        count[m-1][n-1]=1;
        for(int r=m-1;r>=0;r--){
            for(int c=n-1;c>=0;c--){
              if(count[r][c]==0) continue;
                for (int i = 0; i < next.length; i++) {
                   int tr=r+next[i][0];
                   int tc=c+next[i][1];
                   if(tr>=0&&tc>=0&&tr<m&&tc<n&&board.get(tr).charAt(tc)!='X'){
                       int sum=score[r][c];
                       if(board.get(tr).charAt(tc)!='E'){
                           sum+=board.get(tr).charAt(tc)-'0';
                       }

                       if(sum>score[tr][tc]){
                           score[tr][tc]=sum;
                           count[tr][tc]=count[r][c];
                       }else if(sum==score[tr][tc]){
                           count[tr][tc]=(count[tr][tc]+count[r][c])%1000000007;
                       }

                   }
                }
            }
        }
        return new int[]{score[0][0],count[0][0]};
    }*/
}
