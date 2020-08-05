package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LCP13 {
    public int minimalSteps(String[] maze) {

        //找到各个组件
   List<int[]> OS=new ArrayList<>();
   List<int[]> MS=new ArrayList<>();
    int []start=new int[2];
    int []target=new int[2];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                char c=maze[i].charAt(j);
                if(c=='S'){
                   start[0]=i;
                   start[1]=j;
                }else if(c=='O'){
                  OS.add(new int[]{i,j});
                }else if(c=='M'){
                    MS.add(new int[]{i,j});
                }else if(c=='T'){
                    target[0]=i;
                    target[1]=j;
                }
            } 
        }
     MS.add(start);
     OS.add(target);
        //计算 机关 -> 石头 的最短距离
        int [][] m2o=new int[MS.size()][OS.size()];
        for (int i = 0; i < MS.size(); i++) {
            for (int j = 0; j < OS.size(); j++) {
                m2o[i][j]=dfs(MS.get(i),OS.get(j),maze);
            }
        }


        int[][]m2m=new int[MS.size()][MS.size()];
        //计算 机关 -> 石头 ->机关 的距离
        for (int i = 0; i < MS.size(); i++) {
            for (int j = 0; j < MS.size(); j++) {
                if(i==j)continue;
                m2m[i][j]=Integer.MAX_VALUE;
                for (int k = 0; k < OS.size()-1; k++) { //注意此处不要把taget加上，taget是假的石头
                    if(m2o[i][k]==-1||m2o[j][k]==-1) continue;
                    m2m[i][j]=Math.min(m2m[i][j],m2o[i][k]+m2o[j][k]);
                }   
            }
        }



        //状态压缩 ，机关的状态
      int lim=1<<(MS.size()-1); //  注意里面有个start哦 ，要减去
        Integer [][]dp=new Integer[MS.size()][lim];
        dp[MS.size()-1][0]=0; //从最后一个MS开始是0
        for (int status = 0; status < lim; status++) {
            //本次机关
            for (int i = 0; i < MS.size(); i++) {
                //下次机关
                if(dp[i][status]==null) continue;
                for (int j = 0; j < MS.size()-1; j++) {  //注意这里 ，不能把start加上，这里是假的机关
                   if(i==j||(1&(status>>j))==1||m2m[i][j]==Integer.MAX_VALUE) continue;
                    if(dp[j][status|(1<<j)]==null)  dp[j][status|(1<<j)]=dp[i][status]+m2m[i][j];
                   else  dp[j][status|(1<<j)]=Math.min(dp[j][status|(1<<j)],dp[i][status]+m2m[i][j]);
                }
            }
        }

       int res=Integer.MAX_VALUE;
        for (int i = 0; i < MS.size(); i++) {
           if(dp[i][lim-1]==null) continue;;
           if(m2o[i][OS.size()-1]==-1) continue;
           res=Math.min(dp[i][lim-1]+m2o[i][OS.size()-1],res);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
   static int [][]next=new int[][]{
            {0,1},{0,-1},{-1,0},{1,0}
    };
 static   int dfs(int []from,int[] to,String[]maze){
       Queue<int[]> queue=new LinkedList<>();
       queue.add(from);
       int step=0;

       boolean[][]visited=new boolean[maze.length][maze[0].length()];
     visited[from[0]][from[1]] = true;
       while (!queue.isEmpty()){
          int size=queue.size();
          while (size-->0) {
              int[] index = queue.poll();


              for (int i = 0; i < next.length; i++) {
                  int nextX = index[0] + next[i][0];
                  int nextY = index[1] + next[i][1];

                  if (nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length() && !visited[nextX][nextY]&&maze[nextX].charAt(nextY)!='#') {
                      queue.add(new int[]{nextX,nextY});
                      visited[nextX][nextY]=true;
                      if(nextX==to[0]&&nextY==to[1]) return step+1;
                  }
              }
          }
         step++;
       }
       return -1;
   }

    public static void main(String[] args) {
        dfs(new int[]{1,0},new int[]{0,2},new String[]{"S#O", "M..", "M.T"});
    }


    

}
