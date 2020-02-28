package leetcode;

public class leet343 {
    //mine  dfs+dp
    public int integerBreak(int n) {
int[] dp=new int[n];
dfs(n,1,dp);
return dp[n];
    }

    int dfs(int num,int count,int []dp){
      if(num==1) return 1;
      if(dp[num]!=0) return dp[num+1];
      int maxProduct=count==1?0:num;
      for(int i=1;i<=num/2;i++){
         maxProduct=Math.max(maxProduct,dfs(i,count+1,dp)*dfs(num-i,count+1,dp));
      }

      dp[num]=maxProduct;
      return maxProduct;

    }
    //mine 数组改成map

 /*   public int integerBreak(int n) {
       Map<Integer,Integer> map=new HashMap<>();
        dfs(n,1,map);
        return map.get(n);
    }

    int dfs(int num,int count,Map<Integer,Integer>map){
        if(num==1) return 1;
        if(map.containsKey(num)) return map.get(num);
        int maxProduct=count==1?0:num;
        for(int i=1;i<=num/2;i++){
            maxProduct=Math.max(maxProduct,dfs(i,count+1,map)*dfs(num-i,count+1,map));
        }

        map.put(num,maxProduct);
        return maxProduct;

    }*/

    //纯dp
/*    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i/2;j++){
                dp[i]=Math.max(dp[i],Math.max(j,dp[j])*Math.max(i-j,dp[i-j]));
            }
        }
        return dp[n];
    }*/

    //数学道理 不说也可以  找3
  /*  public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int product = 1;
        while(n>4){
            product*=3;
            n-=3;
        }
        product*=n;

        return product;
    }*/

}
