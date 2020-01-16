package leetcode;

import java.util.Arrays;

public class leet1319 {
    //mine UF
/*    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        UnionFind unionFind=new UnionFind(n);
        for (int i = 0; i < connections.length; i++) {
            unionFind.union(connections[i][0],connections[i][1]);
        }

        Set<Integer >set=new HashSet<>();
        for (int i = 0; i < unionFind.id.length; i++) {
            System.out.println(unionFind.id[i]);
            set.add(unionFind.id[i]);
        }
        return set.size()-1;

    }
    public class UnionFind {
        private int id[];
        private int count;

        public UnionFind(int N){
            count=N;
            id=new int[N];
            for(int i=0;i<N;i++){
                id[i]=i;
            }
        }

        public int count(){
            return count;
        }

        public boolean connected(int p,int q){
            return find(p)==find(q);
        }

        public int find(int p){
            return id[p];
        }
        public void union(int p,int q){
            int pid=find(p);
            int qid=find(q);
            if(pid==qid)return;
            for(int i=0;i<id.length;i++){
                if(id[i]==pid)id[i]=qid;
            }
            count--;
        }
    }*/




  //还是union find的思路
  public int find(int[] set, int x) {
      if(set[x] == -1) return x;
      return set[x] = find(set, set[x]);
  }
    public int makeConnected(int n, int[][] connections) {
        if(n-1 > connections.length) return -1;
        int[] set = new int[n];
        Arrays.fill(set, -1);

        for(int[] c : connections) {
            int x = find(set, c[0]), y = find(set, c[1]);
            if(x != y) {
                set[x] = y;
                n--;
            }
        }
        //n表示未联通的个数
        return n-1;
    }



}
