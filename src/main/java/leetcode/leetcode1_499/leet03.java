package leetcode.leetcode1_499;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leet03 {
    public int minCostConnectPoints(int[][] points) {
     UnionFind unionFind=new UnionFind(points.length);

        List<int[]> list=new ArrayList<>();


        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                list.add(new int[]{i,j,Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])});
            }
        }
        Collections.sort(list,(a,b)->a[2]-b[2]);


        int res=0;
        for (int i = 0; i < list.size(); i++) {
            int []p=list.get(i);
            if(!unionFind.union(p[0],p[1])) continue;
            res+=p[2];
            if(unionFind.count==1) return res;
        }

return res;
    }
    class UnionFind{
        final int[] parents;
        int count;

        public UnionFind(int n){
            this.parents = new int[n];
            reset();
        }

        public void reset(){
            for(int i =0;i<parents.length;i++){
                parents[i] = i;
            }
            count = parents.length;
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
