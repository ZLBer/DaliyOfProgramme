package leetcode.leetcode500_999;

import java.util.HashSet;
import java.util.Set;

public class leet947 {

    //还是uf连通域问题,但要住要union的选取，这里选取的是stones中的序号
   /* public int removeStones(int[][] stones) {
       UnionFind uf=new UnionFind(stones.length);
       for(int i=0;i<stones.length;i++){
        for(int j=0;j<stones.length;j++){
            if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1])
                uf.union(i,j);
        }
       }


       //求有几个连通域
       return stones.length-uf.count;
    }

    private class UnionFind{
        private  int[] parent;
        private int[]weight;
        int count=0;
        UnionFind(int count){
            parent=new int[count];
            weight=new int[count];
            this.count=count;
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
    }*/


   //mine dfs
    public int removeStones(int[][] stones) {

        boolean []visited=new boolean[stones.length];
        int result=0;
        for (int i = 0; i < stones.length; i++) {
            if(!visited[i]){
                DFS(stones,visited,i,stones[i][0],stones[i][1]);
                result++;
            }

        }
return stones.length-result;
    }

    void DFS(int[][]stons,boolean []visited,int index,int row,int column){
        if(visited[index]) return;
        visited[index]=true;
        for(int i=0;i<stons.length;i++){
            if(!visited[i]&&(stons[i][0]==row||stons[i][1]==column))
                DFS(stons,visited,i,stons[i][0],stons[i][1]);
        }

    }
}
