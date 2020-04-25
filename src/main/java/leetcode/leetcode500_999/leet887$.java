package leetcode.leetcode500_999;


public class leet887$ {

    //TLE 32 / 121
/*     public int superEggDrop(int K, int N) {
     return  helper(K,N);
    }

    int helper(int K,int N){
         if(N==0||N==1||K==1)
             return N;

         int res=Integer.MAX_VALUE;
         for(int i=1;i<=N;i++){
           int temp=Math.maxSum(helper(K-1,i-1),helper(K,N-i));
           res=Math.min(res,1+temp);
         }
         return res;
    }*/


//依旧是tle 74 / 121
 /*   public int superEggDrop(int K, int N) {
        dp=new int[K+1][N+1];
        return  helper(K,N);
    }

    int dp[][];
    int helper(int K,int N){
        if(N==0||N==1||K==1)
            return N;


        if(dp[K][N]!=0) return dp[K][N];
        int res=Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            int temp=Math.maxSum(helper(K-1,i-1),helper(K,N-i));
            res=Math.min(res,1+temp);
        }
        dp[K][N]=res;
        return res;
    }*/

    //直接用循环做  tle  93/121

 /*   public int superEggDrop(int K, int N) {
       int [][] dp=new int[K+1][N+1];
        for(int i=0;i<=N;i++){
             dp[0][i]=0;  //没有鸡蛋
             dp[1][i]=i;  //一个鸡蛋
        }
        for(int i=0;i<=K;i++){
            dp[i][0]=0; //没有楼层
        }

        for(int k=2;k<=K;k++){
            for(int n=1;n<=N;n++){
               int temp=Integer.MAX_VALUE;
                for(int x=1;x<=n;x++) {
                    temp = Math.min(temp, 1 + Math.maxSum(dp[k][x - 1], dp[k - 1][n - x]));
                }
                dp[k][n]=temp;
            }
        }

return dp[K][N];

    }*/



    //另一种思路     链接：https://leetcode-cn.com/problems/super-egg-drop/solution/ji-dan-diao-luo-xiang-jie-by-shellbye/
/*    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            dp[0][m] = 0; // zero egg
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
                if (dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }*/


    //2020/4/11  mine 自己做一次


    public int superEggDrop(int K, int N) {
    int [][]dp=new int[K+1][N+1];

    //一层楼的情况
        for (int i = 1; i <= K; i++) {
            dp[i][1]=1;
        }
        //一个鸡蛋的情况
        for (int i = 1; i <= N; i++) {
            dp[1][i]=i;
        }
        for(int i=2;i<=K;i++){
            for(int j=2;j<=N;j++){

                dp[i][j]=1+binary(i,j,1,j-1,dp);
                System.out.println(i+" "+j+" " +dp[i][j]);
            }
        }
        return dp[K][N];
    }


    int binary(int i,int j,int low,int high,int[][]dp){
        //寻找最低处的两个点
        while (low+1<high){
            int mid=(low+high)/2;
            int up=dp[i-1][mid-1];//递增的那一条
            int down=dp[i][j-mid];//递减的那一条
            if(up<down){
                low=mid;
            }else if(up>down){
                high=mid;
            }else {
                return up; //提前返回
            }
        }
        return Math.min(Math.max(dp[i-1][low-1],dp[i][j-low]),Math.max(dp[i-1][high-1],dp[i][j-high]));
    }

}
