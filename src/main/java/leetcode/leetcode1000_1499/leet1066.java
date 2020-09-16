package leetcode.leetcode1000_1499;

public class leet1066 {
    public int assignBikes(int[][] workers, int[][] bikes) {
       dfs(workers,bikes,0,new boolean[bikes.length],0);
       return min;
    }
    int min = Integer.MAX_VALUE;
    void dfs(int [][]worker,int  [][]bikes,int i,boolean[]used,int sum){
         //更新最小值
          if(i==worker.length){
              min=Math.min(min,sum);
              return;
          }

         // 剪枝
          if(sum>min) return;
          //遍历所有分支
          for(int j=0;j<bikes.length;j++){
              if(used[j]) continue;
              used[j]=true;
              dfs(worker,bikes,i+1,used,sum+getdistance(worker[i],bikes[j]));
              used[j]=false;
          }
    }
    int getdistance(int []worker,int []bike){
        return Math.abs(worker[0]-bike[0])+Math.abs(worker[1]-bike[1]);
    }
}
