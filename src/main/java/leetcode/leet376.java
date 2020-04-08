package leetcode;

public class leet376 {


    //mine  就查找凹凸点就好了  需要处理连续相等的节点
/*    public int wiggleMaxLength(int[] nums) {
      if (nums.length==0) return 0;
      if(nums.length<=2) return 1;
        int res=0;
        for (int i = 1; i < nums.length-1; i++) {
            //处理相等的情况
            if(nums[i]==nums[i+1]) {
                int left=nums[i-1];
                while (i+1<nums.length-1&& nums[i]==nums[i+1]) i++;
                int right=nums[i+1];
                if((nums[i]>left&&nums[i]>right)||(nums[i]<left&&nums[i]<right)) res++;
                continue;
            }
       if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
           res++;
       }else if(nums[i]<nums[i+1]&&nums[i]<nums[i-1]){
           res++;
       }
         }
    return res==0?((nums[0]==nums[nums.length-1])?1:2):res+2;
    }*/


    //比我的想法理解起来简单多了  典型贪心
  /*  public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int k = 0;
        while (k < nums.length - 1 && nums[k] == nums[k + 1]) {  //Skips all the same numbers from series beginning eg 5, 5, 5, 1
            k++;
        }
        if (k == nums.length - 1) {
            return 1;
        }
        int result = 2;     // This will track the result of result array
        boolean smallReq = nums[k] < nums[k + 1];       //To check series starting pattern
        for (int i = k + 1; i < nums.length - 1; i++) {
            if (smallReq && nums[i + 1] < nums[i]) {
              //  nums[result] = nums[i + 1];  //用来记录哪些数字 本题用不到
                result++;
                smallReq = !smallReq;    //Toggle the requirement from small to big number
            } else {
                if (!smallReq && nums[i + 1] > nums[i]) {
               //     nums[result] = nums[i + 1];//用来记录 本题用不到
                    result++;
                    smallReq = !smallReq;    //Toggle the requirement from big to small number
                }
            }
        }
        return result;
    }
*/

    //dp 也是好巧妙啊
    //两个数组 dowm up 按照情况更新不同的数组
    public int wiggleMaxLength(int[] nums) {

        if( nums.length == 0 ) return 0;

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        up[0] = 1;
        down[0] = 1;

        for(int i = 1 ; i < nums.length; i++){
            if( nums[i] > nums[i-1] ){
                up[i] = down[i-1]+1;
                down[i] = down[i-1];
            }else if( nums[i] < nums[i-1]){
                down[i] = up[i-1]+1;
                up[i] = up[i-1];
            }else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }

        return Math.max(down[nums.length-1],up[nums.length-1]);
    }

}
