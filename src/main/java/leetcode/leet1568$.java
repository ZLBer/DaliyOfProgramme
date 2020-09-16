package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet1568$ {

    //有点脑筋急转弯的意思了
    public int minDays(int[][] grid) {

        int land=1;
        int c=check(grid,land++);

        if(c>=2||c==0) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                 if(grid[i][j]!=0){
                   grid[i][j]=0;
                   if(check(grid,land++)>=2){
                       return 1;
                   }
                   grid[i][j]=land;
                 }
            }
        }
        return 2;
    }

  int  check(int [][]grid,int land){
        int count=0;
      for (int i = 0; i < grid.length; i++) {
          for (int j = 0; j < grid[0].length; j++) {
              if(grid[i][j]==land){
                  dfs(i,j,grid,land);
                  count++;
              }
          }
      }
      return count;
  }


  int [][]next=new int[][]{
          {0,1},{0,-1},{1,0},{-1,0}
  };
  void dfs(int x,int y,int[][] grid,int land){

      if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]!=land){
          return;
      }

      grid[x][y]=land+1;
      for (int i = 0; i < next.length; i++) {
        int nx=x+next[i][0];
        int ny=y+next[i][1];
        dfs(nx,ny, grid,land);
      }
  }




static   int answer(int []arr){
   if(arr.length==1){
       return 1;
   }

   if(arr.length==2){
       if(arr[0]==arr[1]) return 2;
       else return 3;
   }

    //找凹点

   List<Integer> list=new ArrayList<>();

   if(arr[0]<=arr[1]) list.add(0);
   if(arr[arr.length-1]<=arr[arr.length-2]) list.add(arr.length-1);

   for (int i = 1; i < arr.length-1; i++) {
  if(arr[i]<=arr[i-1]&&arr[i]<=arr[i+1]) list.add(i);
    }

   //左侧遍历
    int[] ans=new int[arr.length];
    for (int i = 0; i < list.size(); i++) {
     int index=list.get(i);
     ans[index--]=1;
     while (index>=0){
         //如果递减
        if(arr[index]>arr[index+1]){
          ans[index]=Math.max(ans[index+1]+1,ans[index]);
        }else {
            break;
        }
        index--;
     }
    }
    int a=1;
   //右侧遍历
    for (int i = 0; i < list.size(); i++) {
        int index=list.get(i);
        ans[index++]=1;
        while (index<ans.length){
        if(arr[index]>arr[index-1]){
            ans[index]=Math.max(ans[index-1]+1,ans[index]);
        }else {
            break;
        }
        index++;
        }
    }

    int res=0;
    for (int i = 0; i < ans.length; i++) {

        res+=ans[i];
    }

    return res;
  }

    public static void main(String[] args) {
     //   answer(new int[]{4,1,3,3,3,2,1,5,4,6});
       // answer(new int[]{1,1,1,1});
        answer(new int[]{1,0,2});
    }
  

}
