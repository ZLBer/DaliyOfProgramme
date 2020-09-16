package leetcode;

public class leet1567 {


    //mine 就按照0分组就行
/*
    public int getMaxLen(int[] nums) {
    int i=0;
    int  negtive=0;
    int begin=0;
    int res=0;
    int from=-1,end=0;
    int []newNum=new int[nums.length+1];
        for (int j = 0; j < nums.length; j++) {
            newNum[j]=nums[j];
        }
        newNum[newNum.length-1]=0;

        nums=newNum;
    while (i<nums.length){
      if(nums[i]<0){
         negtive++;
        if(from==-1) from=i;
         end=i;
      }else if(nums[i]==0){

        if(negtive%2==0){
            res=Math.max(res,i-begin);
        }else {
            res=Math.max(res,Math.max(i-from-1,end-begin));
        }
       negtive=0;
        begin=i+1;
        from=-1;
        end=0;
      }
      i++;
    }

    return res;
    }
*/



//别人的  可以不用在最后插入0，每次判断一下就好了
    public int getMaxLen(int[] nums) {
        // sum is used to count the number of negative numbers from zeroPosition to current index
        int firstNegative = -1, zeroPosition = -1, sum = 0, max = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[i] < 0){
                sum++;
                // we only need to know index of first negative number
                if(firstNegative == -1) firstNegative = i;
            }
            // if current number is 0, we can't use any element from index 0 to i anymore, so update zeroPosition, and reset sum and firstNegative. If it is a game, we should refresh the game when we meet 0.
            if(nums[i] == 0){
                sum = 0;
                firstNegative = -1;
                zeroPosition = i;
            }
            else{
                // consider index of zero
                if(sum%2 == 0) max = Math.max(i - zeroPosition, max);
                    // consider index of first negative number
                else max = Math.max(i - firstNegative, max);
            }
        }
        return max;
    }


    public static void main(String[] args) {
    }
}
