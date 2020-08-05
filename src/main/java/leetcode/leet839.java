package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet839 {


    //并查集
    public int numSimilarGroups(String[] A) {
UnionFind unionFind=new UnionFind(A.length);

        for (int i = 0; i < A.length; i++) {
          for(int j=i-1;j>=0;j--){
            if(check(A[i],A[j])){
                unionFind.union(i,j);
            }
          }

        }
        return unionFind.count;
    }

    boolean check(String  a,String b){
       List<Character> list=new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
           if(a.charAt(i)==b.charAt(i)) continue;
           else {
             list.add(a.charAt(i));list.add(b.charAt(i));
           }
          if(list.size()>4) return false;
        }
       if(list.size()==2) return false;
       return list.size()==0||(list.get(0)==list.get(3)&&list.get(1)==list.get(2));
    }

    class UnionFind {
        final int[] parents;
        int count;

        public UnionFind(int n) {
            this.parents = new int[n];
            reset();
        }

        public void reset() {
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            count = parents.length;
        }

        public int find(int i) {
            int parent = parents[i];
            if (parent == i) {
                return i;
            } else {
                int root = find(parent);
                parents[i] = root;
                return root;
            }
        }

        public boolean union(int i, int j) {
            int r1 = find(i);
            int r2 = find(j);
            if (r1 != r2) {
                count--;
                parents[r1] = r2;
                return true;
            } else {
                return false;
            }
        }
    }
}
