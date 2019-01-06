package leetcode;

/**
 * Created by libin on 2018/12/31.
 */
public class leet169$ {
    //王道原题
  static public int majorityElement(int[] nums) {
        int element=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==element) count++;
            else count--;
            if(count<=0){
                element=nums[i];
                count=1;
            }
        }
        return  element;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int []{2,2,1,1,1,2,2}));
    }
}
