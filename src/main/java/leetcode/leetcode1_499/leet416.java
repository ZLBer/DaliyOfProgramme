package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/3/6.
 */
public class leet416 {
    //mine  超时 time Limited
/* static    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        if(sum%2==1) return false;
 return dfs(nums,0,0,sum/2);
    }
  static   boolean dfs(int [] nums,int start,int tempSum,int sum){
        if(tempSum==sum)
            return true;
        else if (tempSum>sum||start>=nums.length)return false;
       boolean left=   dfs(nums,start+1,tempSum,sum);
       boolean right= dfs(nums,start+1,tempSum+nums[start],sum);
       return left||right;

    }

    */
    //dp  动态规划还是不简单
    //
  static   public boolean canPartition(int[] nums) {

        int sum=0;
        for(int a:nums ){
            sum+=a;
        }
        if((sum&1)==1)return  false;
        sum/=2;
        boolean [][]dp= new boolean[nums.length+1][sum+1];

        dp[0][0]=true;
        for(int i=1;i<nums.length+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<sum+1;i++){
            dp[0][i]=false;
        }

        for(int i=1;i<nums.length+1;i++){
            for(int j=1;j<sum+1;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j]=(dp[i][j]||dp[i-1][j-nums[i-1]]);
                }
            }
        }
        return dp[nums.length][sum];
    }



    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,}));
    }

}
