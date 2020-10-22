package leetcode;

import java.util.Arrays;

public class leet1617 {


    //可以做 就是麻烦点
    //contest没debug出来 后来很快就写出来了
/*    Map<Integer, List<Integer>> map  =new HashMap<>();
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        for (int i = 1; i <= n; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
          map.get(edges[i][0]).add(edges[i][1]);
          map.get(edges[i][1]).add(edges[i][0]);
        }

     res=new int[n-1];

        //计算点到点的距离
     dp =new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dfs(map,new boolean[n+1],i,i,0);
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        //枚举连通子集
     helper(1,n,new boolean[n+1]);
        return res;
    }
    int [][]dp;
   int []res;
  void dfs(Map<Integer,List<Integer>> map,boolean []visited,int from,int index,int len){
      if(visited[index]) return;
      visited[index]=true;
      dp[from][index]=len;
      for (Integer integer : map.get(index)) {

          dfs(map,visited,from,integer,len+1);
      }
  }


 //枚举子集
  void  helper(int index,int n,boolean[]visited){
    if(index>n){
      if(check2(visited)){
          int c = get(visited);
          if(c==0) return;
          else res[c-1]++;

      }
        return;
    }
     helper(index+1,n,visited);

    visited[index]=true;
    helper(index+1,n,visited);
    visited[index]=false;
  }

  //求max距离
 int get(boolean []visited){
     int max=0;
      for (int i = 1; i < visited.length; i++) {
         for (int j = 1; j < visited.length; j++) {
             if(!visited[i]||!visited[j]) continue;
              max=Math.max(max,dp[i][j]);
         }

     }
      return max;
 }

//检查是不是连通
 boolean check2(boolean[]visied){
    Set<Integer> set=new HashSet<>();
    int index=-1;
    for (int i = 1; i < visied.length; i++) {
         if(visied[i]){
             index=i;
             set.add(i);
         }
     }

    if(index==-1 ) return  false;
     Set<Integer> set1=new HashSet<>();
     set1.add(index);
     count=0;
      dfs2(map,index,set,new boolean[visied.length]);

 return count==set.size();
 }
int count=0;
    void dfs2(Map<Integer,List<Integer>> map,int index,Set<Integer> a,boolean[]visited){
     visited[index]=true;
     count++;
    for (Integer integer : map.get(index)) {
       if(a.contains(integer)&&!visited[integer]) {
          dfs2(map,integer,a,visited);
       }
    }
}*/



  //试着用状态压缩来做
    //要明白是从小到大慢慢扩展的过程
  public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
    int [][]dist=new int[n+1][n+1];
  int []dp=new int[(1<<n)];
   for(int i=1;i<=n;i++){
       Arrays.fill(dist[i],Integer.MAX_VALUE);
     dist[i][i]=0;
   }
      for (int[] edge : edges) {
         dist[edge[0]][edge[1]]=1;
         dist[edge[1]][edge[0]]=1;
        dp[1<<(edge[0]-1)|1<<(edge[1]-1)]=1;
       }
    //floyd 计算距离
    for(int k=1;k<=n;k++){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
               if(dist[i][k]==Integer.MAX_VALUE||dist[k][j]==Integer.MAX_VALUE) continue;
                dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
            }
        }
    }
/*      for (int i = 0; i < dist.length; i++) {
          for (int j = 0; j < dist[0].length; j++) {
              System.out.print(dist[i][j]+" ");
          }
          System.out.println();
      }*/


//要明白，状态只能由小变大 ，就是说添加一个结点之后，状态肯定变大了，所以可以从小往大遍历
    for(int i=1;i<(1<<n);i++){
       if(dp[i]==0) continue;

       for(int j=0;j<n;j++){

           //节点重复
           if((i&(1<<j))!=0) continue;
            //已经计算过了
           if(dp[i|(1<<j)]!=0) continue;

           //查看是否可以连通
           for(int k=0;k<n;k++){
              //跳过不能联通的节点
               if(((1<<k)&i)==0||dist[j+1][k+1]!=1) continue;
                 dp[i|(1<<j)]=dp[i]; //把之前连通集的距离复制过来
                  break;
           }

           //不能连通直接返回
           if(dp[i|(1<<j)]==0) continue;

           //求最大距离
           for(int k=0;k<n;k++){

               if(((1<<k)&i)==0) continue;

               dp[i|(1<<j)]=Math.max(dp[i|(1<<j)],dist[k+1][j+1]);
           }


       }
    }

    int []res=new int[n-1];

      for (int i : dp) {
          if(i!=0) res[i-1]++;
      }
      return res;

    }

public static void main(String[] args) {

}
}
