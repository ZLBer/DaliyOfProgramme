package leetcode.tianchi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class tianchi1107 {
    public String CharacterDeletion(String str, String sub) {
       Set<Character> set = new HashSet<>();
       StringBuilder sb = new StringBuilder();
        for (char c : sub.toCharArray()) {
            set.add(c);
        }
       
        for (char c : str.toCharArray()) {
            if(!set.contains(c)) sb.append(c);
        }

        return sb.toString();
    }

    public List<List<Integer>> Mine_sweeping(int[][] Mine_map, int[] Start) {
      Queue<int[]> queue=new LinkedList<>();
      queue.add(Start);
   boolean [][] vis=new boolean[Mine_map.length][Mine_map[0].length];
      int [][]next=new int[][]{
              {0,1},{1,0},{-1,0},{0,-1}
      };
     vis[Start[0]][Start[1]]=true;
    List<List<Integer>> res=new ArrayList<>();
   res.add(Arrays.asList(Start[0],Start[1]));
      while (!queue.isEmpty()){
         int []p=queue.poll();
          if(Mine_map[p[0]][p[1]]==0) continue;
          for (int[] ints : next) {
              int x=p[0]+ints[0],y=p[1]+ints[1];
              if(x<0||y<0||x>=Mine_map.length||y>=Mine_map[0].length||vis[x][y]) continue;
              queue.add(new int[]{x,y});

              res.add(Arrays.asList(x,y));

              vis[x][y]=true;

          }
      }
      return res;
    }

  static   public int takeAwayTheBottle(int[] arr) {
        int [][]dp=new int[arr.length][arr.length];


        for (int[] ints : dp) {
            Arrays.fill(ints,(int)arr.length);
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][i]=1;
        }

      for(int len=1;len<arr.length;len++){
         for(int begin=0;begin+len<arr.length;begin++){

            if(len==1){
                if(arr[begin]==arr[begin+len])  dp[begin][begin+len]=1;
                else dp[begin][begin+len]=2;

            }else {
                if(arr[begin]==arr[begin+len]) {
                    dp[begin][begin+len]=dp[begin+1][begin+len-1];
                }

                for(int k=begin;k<begin+len;k++){
                    dp[begin][begin+len]=Math.min(dp[begin][begin+len],dp[begin][k]+dp[k+1][begin+len]);

                }



            }

         }
      }

      /*  for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
      return dp[0][arr.length-1];
    }

    public static void main(String[] args) {
        takeAwayTheBottle(new int[]{1,3,4,1,5});
    }
}
