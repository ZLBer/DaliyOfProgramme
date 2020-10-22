package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet834$ {

    //floyd 超出内存限制
 /*   public int[] sumOfDistancesInTree(int N, int[][] edges) {
    int [][]dp=new int[N][N];
        for (int[] ints : dp) {
            Arrays.fill(ints,20000);
        }
        for (int i = 0; i < edges.length; i++) {
            int from=edges[i][0],to=edges[i][1];
            dp[from][to]=1;
            dp[to][from]=1;
        }
        for (int i = 0; i < N; i++) {
            dp[i][i]=0;
        }
        for(int k=0;k<N;k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0;j < N; j++) {
                   dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }


      int []res=new int[N];
        for (int i = 0; i < dp.length; i++) {
            int sum=0;
            for (int j = 0; j < dp[0].length; j++) {
                sum+=dp[i][j];
            }
           res[i]=sum;
        }
        return res;
    }*/

    int []dis; int []count;int NN;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
      dis=new int[N];
      count=new int[N];
      NN=N;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
           list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from=edges[i][0],to=edges[i][1];
            list.get(from).add(to);
            list.get(to).add(from);
        }
        Arrays.fill(count,1);
       postOrder(0,-1,list);
       preOrder(0,-1,list);
       return dis;
    }

    void  postOrder(int node,int parent,List<List<Integer>>list){

        for (Integer integer : list.get(node)) {
            if(integer==parent) continue;
            postOrder(integer,node,list);
            count[node]+=count[integer];
            dis[node]+=dis[integer]+count[integer];
        }
    }

    void  preOrder(int node,int parent,List<List<Integer> >list){

        for (Integer integer : list.get(node)) {
           if(integer==parent) continue;

           dis[integer]=dis[node]+NN-2*count[integer];
           preOrder(integer,node,list);
        }

    }
}
