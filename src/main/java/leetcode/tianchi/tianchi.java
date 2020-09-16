package leetcode.tianchi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class tianchi {
    /**
     * @param A: an integer array
     * @return: return maxium contiguous non-negative subarray sum
     */
    public int maxNonNegativeSubArray(int[] A) {
        int sum = 0;
        int res = -1;
        boolean flag=false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                sum += A[i];
                flag=true;
            } else {
                res = Math.max(res, sum);
                sum = 0;
            }
        }
        if(!flag)return -1;
        return Math.max(res, sum);
    }

   static public long getSecondDiameter(int[][] edge) {
        // write your code here
     /*    Map<Integer, List<int[]>> map=new HashMap<>();
       for (int i = 0; i < edge.length; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
          map.get(edge[i][0]).add(new int[]{edge[i][1],edge[i][2]});
            map.get(edge[i][1]).add(new int[]{edge[i][0],edge[i][2]});
        }*/
   /*     boolean []visited=new boolean[edge.length];
        int one=0,two=0;
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]){

            }
        }  */
       Integer [][]dp=new Integer[edge.length+1][edge.length+1];
        for (int i = 0; i < edge.length; i++) {
            dp[edge[i][0]][edge[i][1]]=edge[i][2];
            dp[edge[i][1]][edge[i][0]]=edge[i][2];
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if(i==j){
                    dp[i][j]=0;
                    continue;
                }
               for(int k=0;k<dp.length;k++){
                 if(dp[i][k]!=null&&dp[k][j]!=null){
                     if(dp[i][j]==null){
                         dp[i][j] = dp[i][k] + dp[k][j];
                     }else {
                         dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
                     }
                 }

               }
            }
        }
       int one=0,two=0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                if(dp[i][j]==null) continue;
                if(dp[i][j]>one){
                  two=one;
                  one=dp[i][j];
                }
               else if(dp[i][j]>two){
                   two=dp[i][j];
                }
                System.out.print(((dp[i][j]==null)?-1:dp[i][j])+" ");
            }
            System.out.println();
        }

        return two;
    }


/*    void bfs(boolean[]visited,int index,Map<Integer, List<int[]>> map){
    Queue<Integer> queue=new LinkedList<>();
    queue.add(index);
    while (!queue.isEmpty()){
        int p=queue.poll();
        for (int[] ints : map.get(p)) {
         if(visited[ints[0]]) continue;
         queue.add()
        }
    }
    }*/


  static public long painttheCeiling(int s0, int n, int k, int b, int m, long a) {
        // write your code here
   Set<Integer> set=new HashSet<>();
  // List<Integer> set=new ArrayList<>();
        int preS=s0;
        set.add(preS);
        for (int i = 1; i < n; i++) {
        int newS=((k*preS+b)%m)+1+preS;
        preS=newS;
        if(set.contains(preS)){
         break;
        }else {
         set.add(preS);
        }
        }
      int res=0;
     List<Integer> list=new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(list.get(i)*list.get(j)<a)res++;
            }
        }
        return res;
    }


//字符串复制
  static   int answer(String s){
    int []dp=new int[s.length()+1];
    dp[0]=0;
        for (int i = 0; i < s.length(); i++) {
          dp[i+1]=dp[i]+1;//可以添加一个字符生成当前


            for(int j=i-1;j>0;j--){
             int length=i-j+1;
           if(j-length<0) break;
          String a=s.substring(j-length,j);
          String b=s.substring(j,i+1);
         if(a.equals(b)){
            dp[i+1]=Math.min(dp[i+1],j+1);
         }
         }
        }
 return dp[s.length()];
    }

    public static void main(String[] args) {
      answer("acdeffffff");
    }

}
