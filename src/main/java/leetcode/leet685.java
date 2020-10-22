package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] two = null;
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0], to = edges[i][1];
            if (!map.containsKey(to)) {
                map.put(to, i);
            } else { //找到入度数为2
                two = new int[]{map.get(to), i};
                break;
            }
        }

        if (two == null) { //没有入读为2的 返回环的最后一个
            UnionFind unionFind = new UnionFind(edges.length);
            for (int i = 0; i < edges.length; i++) {
                if(!unionFind.union(edges[i][0]-1,edges[i][1]-1)) return new int[]{edges[i][0],edges[i][1]};
            }
        } else {
            for (int i = two.length - 1; i >= 0; i--) {
                if(check(two[i],edges)) return new int[]{edges[two[i]][0],edges[two[i]][1]};
            }
        }
        return null;
    }

        boolean check(int index,int[][]edges){
            UnionFind unionFind = new UnionFind(edges.length);
        for (int i = edges.length - 1; i >= 0; i--) {
                if(i==index) continue;
               if(!unionFind.union(edges[i][0]-1,edges[i][1]-1)) return false;
            }
        return true;
        }
    class UnionFind{
        public final int[] parents;
        public int count;

        public UnionFind(int n){
            this.parents = new int[n];
            reset();
        }

        public void reset(){
            for(int i =0;i<parents.length;i++){
                parents[i] = i;
            }
            count = parents.length-1;
        }

        public int find(int i){
            int parent = parents[i];
            if(parent == i){
                return i;
            }else{
                int root = find(parent);
                parents[i] = root;
                return root;
            }
        }

        public boolean union(int i, int j){
            int r1 = find(i);
            int r2 = find(j);
            if(r1 != r2){
                count--;
                parents[r1] = r2;
                return true;
            }else{
                return false;
            }
        }

    }



   //官方题解
  /*  public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        UnionFind uf = new UnionFind(nodesCount + 1);
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i; //入读为2的点，并未加入并查集
            } else {
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i; //构成圆的最后一个
                } else {
                    uf.union(node1, node2);
                }
            }
        }
        if (conflict < 0) {  //没有入读为2的点
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) { //还有环的话一定是之前的造成的
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else { //自己造成的环
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }
}*/

}
