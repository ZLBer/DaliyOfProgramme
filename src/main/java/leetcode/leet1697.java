package leetcode;

import java.util.Arrays;

public class leet1697 {
/*    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int [][]arr=new int[n][n];
        int inf=(int)1e9;
        for (int[] ints : arr) {
            Arrays.fill(ints,inf);
        }
        for (int i = 0; i < n; i++) {
            arr[i][i]=0;
        }

        for (int i = 0; i < edgeList.length; i++) {
            int []edge=edgeList[i];
            arr[edge[0]][edge[1]]=Math.min(edge[2],arr[edge[0]][edge[1]]);
            arr[edge[1]][edge[0]]=Math.min(edge[2],arr[edge[1]][edge[0]]);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {


                for (int k = 0; k < arr.length; k++) {
                   arr[i][j]=Math.min(arr[i][j],Math.max(arr[i][k],arr[k][j]));
                }
            }
        }


       boolean[]res=new boolean[queries.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        } 
        
        for (int i = 0; i < queries.length; i++) {
           int []quert=queries[i];
            if(arr[quert[0]][quert[1]]<=quert[2]){
                res[i]=true;
            }else {
                res[i]=false;
            }
        }
        return res;
    }*/
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

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList,(a,b)->a[2]-b[2]);

        int [][]t=new int[queries.length][4];
        for (int i = 0; i < queries.length;  i++) {
            t[i][0]=queries[i][0];
            t[i][1]=queries[i][1];
            t[i][2]=queries[i][2];
            t[i][3]=i;
        }
        Arrays.sort(t,(a,b)->a[2]-b[2]);


        int left=0;
        UnionFind uf=new UnionFind(n);
        boolean []res=new boolean[queries.length];
        for (int i = 0; i < t.length; i++) {
           while (left<edgeList.length&&edgeList[left][2]<t[i][2]){
               uf.union(edgeList[left][0],edgeList[left][1]);
               left++;
           }

           if(uf.find(t[i][0])==uf.find(t[i][1])) {
               res[t[i][3]]=true;
           }

        }
        return res;
    }



}
