package leetcode.Array;

/**
 * Created by libin on 2017/10/17.
 */
public class Non_decreasing_Array {
    public boolean checkPossibility(int[] nums) {
        int count=0;
for(int i=0;i<nums.length-1;i++){
    if(nums[i+1]>=nums[i]) continue;
    else {
        count+=1;
        if(i<nums.length-2){
            if(i-1<0||(nums[i+2]>=nums[i]||nums[i+1]>=nums[i-1])&&i-1>=0)
            continue;
            else return false;
        }

    }
}
 //       System.out.println(count+"eeee");
return  count<=1;
    }
}
