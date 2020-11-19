package leetcode;

public class leet334 {
    public boolean increasingTriplet(int[] nums) {
       int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
        for (int num : nums) {
            if(num<a){
               a=num;
            }else if(num<b){
                b=num;
            }else if(num>b){
               return true;
            }
        }
        return false;
    }


}
