package leetcode.leetcode500_999;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libin on 2019/2/19.
 */
public class leet994$ {
    public int orangesRotting(int[][] grid) {
   int rows=grid.length;
   int cols=grid[0].length;
   Queue<int []> queue=new LinkedList<>();
   int freshOrange=0;
   for(int i=0;i<rows;i++){
       for(int j=0;j<cols;j++){
           if(grid[i][j]==1) freshOrange++;
           if(grid[i][j]==2) queue.offer(new int[]{i,j});
       }
   }

        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
  if(freshOrange == 0) return 0;
while (!queue.isEmpty()){
    count++;
       int size=queue.size();
       while (size>0){
           size--;
           int []point=queue.poll();
           //遍历四个方向
           for(int []dir:dirs){
               int x = point[0] + dir[0];
               int y = point[1] + dir[1];
                //此时什么都不做
               if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
               //感染这个句子
               grid[x][y] = 2;
               //加入队列
               queue.offer(new int[]{x , y});
               freshOrange--;
           }
       }
}

return  freshOrange==0?count-1:-1;
    }


}
