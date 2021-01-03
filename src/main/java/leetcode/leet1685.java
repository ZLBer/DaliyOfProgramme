package leetcode;

public class leet1685 {
    //暴力过不了
/*    public int[] getSumAbsoluteDifferences(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int []sum=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                sum[i]=map.get(nums[i]);
                continue;
            }
            for (int j = 0; j < nums.length; j++) {
                int a=Math.abs(nums[j]-nums[i]);
                sum[i]+=a;
            }
        }
        return sum;
    }*/





//前缀和 分左右
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int []presum=new int[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            presum[i+1]=presum[i]+nums[i];
        }

        int []res=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            int left= i*nums[i]-(presum[i]);

            int right=presum[nums.length]-presum[i+1]-(nums.length-i-1)*nums[i];
          res[i]=left+right;
        }
        return res;
    }
}
