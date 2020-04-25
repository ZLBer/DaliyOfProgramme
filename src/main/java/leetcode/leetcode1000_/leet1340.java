package leetcode.leetcode1000_;

public class leet1340 {
    //mine  排序然后dp
  /*  public int maxJumps(int[] arr, int d) {
         List<int[]> arrIndex=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrIndex.add(new int[]{i,arr[i]});
        }
        Collections.sort(arrIndex,(int []a,int []b)->a[1]-b[1]);
        int []dp=new int[arr.length];
        Arrays.fill(dp,1);
        int res=0;
        for(int []a:arrIndex){
              int i=a[0];
              int k=0;
              for(int x=1;x<=d;x++){
               int j=i+x;
               if(j>=arr.length) break; ;
               k=Math.maxSum(arr[j],k);
               if(arr[i]>k){
                   dp[i]=Math.maxSum(dp[i],dp[j]+1);
               }
              }
              k=0; //再次初始
            for(int x=1;x<=d;x++){
                int j=i-x;
                if(j<0) break;
                k=Math.maxSum(arr[j],k);
                if(arr[i]>k){
                    dp[i]=Math.maxSum(dp[i],dp[j]+1);
                }
            }
            res=Math.maxSum(res,dp[i]);
            System.out.println( a[0]+"  "+res);
        }
        return res;

    }*/



//dfs+memo 省略了排序的过程
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int dp[] = new int[n];
        int res = 1;
        for (int i = 0; i < n; ++i)
            res = Math.max(res, dfs(arr, n, d, i, dp));
        return res;
    }

    private int dfs(int[] arr, int n, int d, int i, int[] dp) {
        if (dp[i] != 0) return dp[i];
        int res = 1;
        for (int j = i + 1; j <= Math.min(i + d, n - 1) && arr[j] < arr[i]; ++j)
            res = Math.max(res, 1 + dfs(arr, n, d, j, dp));
        for (int j = i - 1; j >= Math.max(i - d, 0) && arr[j] < arr[i]; --j)
            res = Math.max(res, 1 + dfs(arr, n, d, j, dp));
        return dp[i] = res;
    }
}
