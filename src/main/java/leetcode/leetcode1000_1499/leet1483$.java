package leetcode.leetcode1000_1499;

public class leet1483$ {


    //TLE
/*    class TreeAncestor {
        int []parent;
        public TreeAncestor(int n, int[] parent) {
        this.parent=parent;
        this.dp=new int[n][n];
        }
     int [][]dp;
        public int getKthAncestor(int node, int k) {
            if(k>=parent.length) return -1;
         int pre=node;

            while (k-->0&&pre!=-1){
           pre= parent[pre];
                System.out.println(pre);
            }

         return     k>0?-1:pre;
        }
    }*/




    //Binary Lifting倍增
    class TreeAncestor {

        int [][]dp;
        public TreeAncestor(int n, int[] parent) {
        dp=new int[(int)(Math.log(n)/Math.log(2))+1][n];
        dp[0]=parent;

        for(int i=1;i<dp.length;i++){
            for (int j = 0; j < n; j++) {
                int pre=dp[i-1][j];
               dp[i][j]=(pre==-1?-1:dp[i-1][pre]);
            }
        }
        }

        public int getKthAncestor(int node, int k) {
            int maxPow=dp.length;
  while (k>0&&node!=-1){
      if(k>=1<<maxPow){
       node=dp[maxPow][node];
       k-=1<<maxPow;
      }else {
        maxPow-=1;
      }
  }

return node;
        }
    }
}
