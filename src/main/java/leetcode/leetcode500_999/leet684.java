package leetcode.leetcode500_999;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leet684 {



    //mine
  /*  List<int[]> result=new ArrayList<>();
    public int[] findRedundantConnection(int[][] edges) {
         UnionFind uf=new UnionFind(1001);
        for (int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0],edges[i][1]);
        }
  
       
        return result.get(result.size()-1);
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
            if(pRoot==qRoot) {
                result.add(new int[]{p, q});
                return;
            }
            if(weight[pRoot]>weight[qRoot]){
                parent[qRoot]=pRoot;
                weight[pRoot]+=weight[qRoot];
            }else {
                parent[pRoot]=qRoot;
                weight[qRoot]+=weight[pRoot];

            }
        }
    }*/



  //简约版并查集
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (int[] edge: edges){
            int f = edge[0], t = edge[1];
            if (find(parent, f) == find(parent, t)) return edge;
            //把f连接到t上
            else parent[find(parent, f)] = find(parent, t);
        }

        return new int[2];
    }

    private int find(int[] parent, int f) {
        if (f != parent[f]) {
            parent[f] = find(parent, parent[f]);
        }
        return parent[f];
    }

  //可以dfs  对于每个u v ，从u开始dfs 看能否找到v ，否则就添加（u，v）（v，u）双向
   /* public int[] findRedundantConnection(int[][] edges) {
        int[] ret = null;
        int n = edges.length;
        List<Set<Integer>> adjList = new ArrayList<>(1001);
        for(int i=0; i < 1001; i++)
            adjList.add(new HashSet<>());

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            if(dfs(u, v, 0, adjList)){
                ret = edge;
            }else{
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
        return ret;
    }

    private boolean dfs(int u, int v, int pre, List<Set<Integer>> adjList){
        if(u == v)
            return true;
        for(int w : adjList.get(u)){
            if(w == pre) continue;
            boolean ret = dfs(w, v, u, adjList);
            if(ret) return true;
        }
        return false;
    }*/
}
