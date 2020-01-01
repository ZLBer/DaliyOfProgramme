package leetcode;

public class leet1295 {
    public int findNumbers(int[] nums) {
   int res=0;
        for (int i = 0; i < nums.length; i++) {
            if(((nums[i]+"").length())%2==0) res++;
        }
        return res;
    }
    //函数式子
/*    public int findNumbers(int[] nums) {
    return Arrays.stream(nums).map(i->1-Integer.toString(i).length()%2).sum();
    }*/

}
