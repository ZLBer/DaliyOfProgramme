package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/3/7.
 */
public class leet300 {

    //mine  DP
  static   public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
      int longest[]=new int[nums.length];
longest[0]=1;
int resultMax=0;
      for(int i=1;i<nums.length;i++){
          int max=1;
          for(int j=0;j<i;j++){
              if(nums[j]<nums[i]&&longest[j]+1>max) max=longest[j]+1;
          }
          longest[i]=max;
          if(max>resultMax) resultMax=max;
      }
      return resultMax;
    }

    // TODO: 2019/3/7
  //二分法   不是很理解
   /* public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
*/
    public static void main(String[] args) {
        lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
}
