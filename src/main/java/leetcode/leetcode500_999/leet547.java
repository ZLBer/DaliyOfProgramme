package leetcode.leetcode500_999;

import java.util.HashSet;
import java.util.Set;

public class leet547 {
   /* public int findCircleNum(int[][] M) {

     boolean []visited=new boolean[M.length];
     int result=0;
     for (int i = 0; i < visited.length; i++) {
            if(visited[i]==false){
                DFS(i,M,visited);
                result++;
            }
        }
     return result;

    }

    void DFS(int student,int[][]M,boolean[]visited){
       if(visited[student]) return;
        visited[student]=true;
        for(int i=0;i<M[0].length;i++){
            if(M[student][i]==1){
                DFS(i,M,visited);
            }
        }
    }*/
   public int findCircleNum(int[][] M) {
       UnionFind uf=new UnionFind(M.length);
       for(int i=0;i<M.length;i++){
           for(int j=0;j<M.length;j++){
               if(M[i][j]==1) {
                   uf.union(i, j);
               }
           }
       }

       return uf.count;
   }
    private class UnionFind{
         int[] parent;
         int[]weight;
         int count=0;
        UnionFind(int count){
            this.count=count;
            parent=new int[count];
            weight=new int[count];
            for (int i = 0; i < count; i++) {
                weight[i] = 1;
                parent[i] = i;
            }
        }

        public  int find(int index){
            while (index!=parent[index]){
                index=parent[index];
            }

            return index;
        }
        public void union(int p,int q){
            int pRoot=find(p);
            int qRoot=find(q);
            if(pRoot==qRoot)
                return ;
            if(weight[pRoot]>weight[qRoot]){
                parent[qRoot]=pRoot;
                weight[pRoot]+=weight[qRoot];
            }else {
                parent[pRoot]=qRoot;
                weight[qRoot]+=weight[pRoot];

            }
            count--;
        }
    }
}
