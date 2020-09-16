package leetcode;

import java.util.Arrays;

public class leet1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {

     int res=0;//可以删除的边
     UnionFind unionFind=new UnionFind(n+1);
       //先处理公共边
        for (int i = 0; i < edges.length; i++) {
          int []edge=edges[i];
        if(edge[0]!=3) continue;
        if(!unionFind.union(edge[1],edge[2]))  res++;
        }

        UnionFind unionFind1=new UnionFind(unionFind);
        for (int i = 0; i < edges.length; i++) {
            int []edge=edges[i];
            if(edge[0]!=1) continue;
          if(!unionFind1.union(edge[1],edge[2])) res++;
        }
       if(unionFind1.count!=1) return -1;

     //  UnionFind unionFind2=new UnionFind(unionFind);
        for (int i = 0; i < edges.length; i++) {
            int []edge=edges[i];
            if(edge[0]!=2) continue;
            if(!unionFind.union(edge[1],edge[2])) res++;
        }

   if(unionFind.count!=1) return -1;
   return res;

    }


    class UnionFind{
       public final int[] parents;
       public int count;

        public UnionFind(int n){
            this.parents = new int[n];
            reset();
        }

        public UnionFind(UnionFind unionFind){
            this.parents=Arrays.copyOf(unionFind.parents,unionFind.parents.length);
            this.count=unionFind.count;
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
}
