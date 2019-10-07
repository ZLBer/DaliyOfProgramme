package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class leet1210 {

    //min DFS 	Time Limit Exceeded

/*
    //水平状态时可以改变的状态
    int[][] horizontalChange={
            //向右移动一格
            {0,1,0,1},
            //向下移动
            {1,0,1,0},
            //顺时针旋转
            {1,-1,0,0}
    };
    int [][] varticalChange={
            //向右移动一格
            {1,0,1,0},
            //向下移动
            {0,1,0,1},
            //逆时针旋转
            {-1,1,0,0}
    };
    int min=Integer.MAX_VALUE;
    Set<String> set=new HashSet<>();
    public int minimumMoves(int[][] grid) {
        DFS(grid,0,1,0,0,0);
        //   System.out.println(min);
        return min==Integer.MAX_VALUE?-1:min;
    }

    void DFS(int [][]grid,int head0,int head1,int tail0,int tail1,int step){
        if(set.contains(head0+""+head1+""+tail0+""+tail1)) return;
        // System.out.println(head0+"  "+head1+"  "+tail0+"   "+tail1+"  "+step);
        if(head0==grid.length-1&&head1==grid.length-1&&tail0==grid.length-1&&tail1==grid.length-2){
            min=Math.min(min,step);
            return;
        }



        set.add(head0+""+head1+""+tail0+""+tail1);
        //水平状态
        if(head0==tail0){
            for(int i=0;i<3;i++){
                if(i==2&&((head0+1)>=grid.length||grid[head0+1][head1]==1)) continue;
                int th0=head0+ horizontalChange[i][0];
                int th1=head1+horizontalChange[i][1];
                int tt0=tail0+horizontalChange[i][2];
                int tt1=tail1+horizontalChange[i][3];
                if(th0<grid.length&&th1<grid.length&&grid[th0][th1]==0&&grid[tt0][tt1]==0)
                    DFS(grid,th0,th1,tt0,tt1,step+1);
            }

        }
        //垂直状态
        else {
            for(int i=0;i<3;i++){
                if(i==2&&(((head1+1)>=grid.length||grid[head0][head1+1]==1))) continue;
                int th0=head0+ varticalChange[i][0];
                int th1=head1+varticalChange[i][1];
                int tt0=tail0+varticalChange[i][2];
                int tt1=tail1+varticalChange[i][3];
                if(th0<grid.length&&th1<grid.length&&grid[th0][th1]==0&&grid[tt0][tt1]==0)
                    DFS(grid,th0,th1,tt0,tt1,step+1);
            }
        }
        set.remove(head0+""+head1+""+tail0+""+tail1);
    }*/





// DFS  必须用个memo来缓存这个点的最小step  有用dp的味道
    //水平状态时可以改变的状态
     int[][] horizontalChange={
            //向右移动一格
            {0,1,0,1},
            //向下移动
            {1,0,1,0},
            //顺时针旋转
            {1,-1,0,0}
    };
     int [][] varticalChange={
            //向右移动一格
            {1,0,1,0},
            //向下移动
            {0,1,0,1},
            //逆时针旋转
            {-1,1,0,0}
    };
   Set<String> set=new HashSet<>();
    public int minimumMoves(int[][] grid) {
 int result= DFS(grid,0,1,0,0,new int[grid.length][grid.length][2]);

  return result==Integer.MAX_VALUE?-1:result;
    }

    int DFS(int [][]grid,int head0,int head1,int tail0,int tail1,int[][][] memo){


       //System.out.println(head0+"  "+head1+"  "+tail0+"   "+tail1+"  ");
        if(head0==grid.length-1&&head1==grid.length-1&&tail0==grid.length-1&&tail1==grid.length-2){
            return 0;
        }


        int index=head0==tail0?0:1;
        if(memo[head0][head1][index]!=0) return memo[head0][head1][index];
        //为了防止DFS上层的点又被访问到，导致无限循环；所以要终止
        if(set.contains(head0+""+head1+""+tail0+""+tail1)) return Integer.MAX_VALUE;
        set.add(head0+""+head1+""+tail0+""+tail1);

        int result=Integer.MAX_VALUE;
        //水平状态
        if(head0==tail0){
         for(int i=0;i<3;i++){
             if(i==2&&((head0+1)>=grid.length||grid[head0+1][head1]==1)) continue;
             int th0=head0+ horizontalChange[i][0];
             int th1=head1+horizontalChange[i][1];
             int tt0=tail0+horizontalChange[i][2];
             int tt1=tail1+horizontalChange[i][3];
             if(th0<grid.length&&th1<grid.length&&grid[th0][th1]==0&&grid[tt0][tt1]==0)
                 result=Math.min(result,DFS(grid,th0,th1,tt0,tt1,memo));
         }

        }
        //垂直状态
        else {
            for(int i=0;i<3;i++){
                if(i==2&&(((head1+1)>=grid.length||grid[head0][head1+1]==1))) continue;
                int th0=head0+ varticalChange[i][0];
                int th1=head1+varticalChange[i][1];
                int tt0=tail0+varticalChange[i][2];
                int tt1=tail1+varticalChange[i][3];
                if(th0<grid.length&&th1<grid.length&&grid[th0][th1]==0&&grid[tt0][tt1]==0)
                    result=Math.min(result,DFS(grid,th0,th1,tt0,tt1,memo));
            }
        }
        if(result < Integer.MAX_VALUE) result++; //increment the result as we need to consider a move from current position
        memo[head0][head1][index] = result; //store the result in the appropriate memo table
        return result;
    }




   //BFS 把2维矩阵转化成1维来做
   /*  public int minimumMoves(int[][] grid) {
        int n = grid.length, moves = 0;
        Queue<int[]> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.offer(new int[] {0, 1});
        seen.add("0-1");

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] span = q.poll();
                //转换过程
                int first = span[0], second = span[1], x1 = first / n, y1 = first % n, x2 = second / n, y2 = second % n;
                //找到最终答案
                if (x1 == n - 1 && y1 == n - 2 && x2 == n - 1 && y2 == n - 1) return moves;

                if (x1 == x2) { // horizontal
                    if (y2 + 1 < n && grid[x2][y2 + 1] == 0) move(q, second, second + 1, seen); // right
                    if (x2 + 1 < n && grid[x1 + 1][y1] == 0 && grid[x2 + 1][y2] == 0) {
                        move(q, first + n, second + n, seen); // down
                        move(q, first, first + n, seen); // clockwise
                    }
                }

                if (y1 == y2) { // vertical
                    if (x2 + 1 < n && grid[x2 + 1][y2] == 0) move(q, second, second + n, seen); // down
                    if (y2 + 1 < n && grid[x1][y1 + 1] == 0 && grid[x2][y2 + 1] == 0) {
                        move(q, first + 1, second + 1, seen); // right
                        move(q, first, first + 1, seen); // counter clockwise
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private void move(Queue<int[]> q, int first, int second, Set<String> seen) {
        if (!seen.contains(first + "-" + second)) {
            q.offer(new int[] { first, second });
            seen.add(first + "-" + second);
        }
    }*/


}
