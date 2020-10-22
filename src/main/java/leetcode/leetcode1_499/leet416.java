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
/*  static   public boolean canPartition(int[] nums) {

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
    }*/













  //MLE
/*    public boolean canPartition(int[] nums) {
     int sum=0;
        for (int num : nums) {
            sum+=num;
        }
      int des=sum/2;
        if(des*2!=sum) return false;

       List<Integer> list=new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
             List<Integer> temp=new ArrayList<>();
            for (Integer integer : list) {
                temp.add(integer);
                temp.add(integer+nums[i]);
            }
           temp.add(nums[i]);
            list=temp;
        }
        for (Integer integer : list) {
            if(integer==des) return true;
        }
        return false;

    }*/
  public boolean canPartition(int[] nums) {
      int sum=0;
      for (int num : nums) {
          sum+=num;
      }
      int des=sum/2;
      if(des*2!=sum) return false;

     boolean[][]dp=new boolean[nums.length+1][des+1];

      for (int i = 0; i < dp.length; i++) {
          dp[i][0]=true;
      }
     
      for (int i = 1; i < nums.length; i++) {
          int num = nums[i-1];
          for (int j = 1; j < dp[0].length; j++) {
            dp[i][j]=dp[i-1][j];
            int frm=j-num;
            if(frm<0) continue;
           if(dp[i-1][frm]==true) {
               dp[i][j]=true;
           }

          }
          if(dp[i][dp[0].length]) return true;
      }

 /*     for (int i = 0; i < dp.length; i++) {
          for (int j = 0; j < dp[0].length; j++) {
              System.out.print(dp[i][j]+" ");
          }
          System.out.println();
      } 
*/
      return dp[dp.length-1][dp[0].length-1];

  }



  

}
