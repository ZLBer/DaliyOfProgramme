package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leet1615 {

    public int maximalNetworkRank(int n, int[][] roads) {
    int []count=new int[n+1];

    Set<String> set=new HashSet<>();
        for (int i = 0; i < roads.length; i++) {
           count[roads[i][0]]++;
           count[roads[i][1]]++;
           set.add(roads[i][0]+"-"+roads[i][1]);
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
        int res=0;
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               if(i==j) continue;
               if(set.contains(i+"-"+j)||set.contains(j+"-"+i))
                   res=Math.max(count[i]+count[j]-1,res);
               else {
                   res=Math.max(count[i]+count[j],res);
               }

           }
       }

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
