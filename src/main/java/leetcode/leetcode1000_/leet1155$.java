package leetcode.leetcode1000_;

public class leet1155$ {
/*    int mod=1000000000 + 7;
    public int numRollsToTarget(int d, int f, int target) {

       Map<String,Integer> map=new HashMap<>();

       return  helper(d,f,target,map);

    }
    int helper(int d,int f,int target,Map<String,Integer> map){

        //筛子用完并且target为0
        if(d==0&&target==0)
            return 1;

        //傻子或者target 提前用完
        if(d==0||target==0)
            return 0;

        if(map.containsKey(d+"-"+target))
            return map.get(d+"-"+target);
int res=0;

       //模拟摇色子的过程，共有1-f种情况
        for(int i=1;i<=f;i++){
            if(target>=i)
                  res=(res+ helper(d-1,f,target-i,map)%mod)%mod;
            else break;
        }

        map.put(d+"-"+target,res);
        return res;


    }*/



//dp  会发现和dfs大同小异
    public int numRollsToTarget(int d, int f, int target) {
        int MOD = 1000000007;
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0]=1;
        for(int i=1;i<=d;i++){
      for(int j=1;j<=target;j++){

        if(j>i*f){
            continue;
        }
        else {
            for(int k=1;k<=f&& k <= j;k++){
                dp[i][j]=(dp[i][j]+dp[i-1][j-k])% MOD;
            }
        }

      }
  }

  return dp[d][target];
    }
}
