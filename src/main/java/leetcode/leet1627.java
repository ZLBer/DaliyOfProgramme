package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet1627 {
    long gcd(long a,long b) {
        while(b!=0)
        {
            long temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    //并查集
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


    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {

        UnionFind unionFind=new UnionFind(n+1);
        //暴力过不了 TLE
 /*       for (int i = threshold+1; i <= n; i++) {
           for(int j=i+1;j<=n;j++){
              if(gcd(i,j)>threshold){
                  unionFind.union(i,j);
              }
           }
        }*/

        //反向求
        for (int i = threshold+1; i <= n; i++) {
            for(int j=2;i*j<=n;j++){
                    unionFind.union(i,i*j);

            }
        }

       List<Boolean> res=new ArrayList<>();
        for (int[] query : queries) {
            if(unionFind.find(query[0])==unionFind.find(query[1])){
                res.add(true);
            }else res.add(false);

        }
        return res;

    }
}
