package leetcode._jianzhioffer;

import java.util.Arrays;

public class p45 {

    //mine  也是个找规律
/*
    public String minNumber(int[] nums) {

        Integer [] integers=new Integer[nums.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i]=nums[i];
        }
        Arrays.sort(integers,(a,b)->{
       if(a==b) return 0;
            int i=0,j=0;
       String sa=a+"",sb=b+"";
            while ((i<sa.length()||j<sb.length())&&sa.charAt(i% sa.length())==sb.charAt(j%sb.length())){
    i++;
    j++;
      }
     return sa.charAt(i%sa.length())-sb.charAt(j%sb.length());
        });

     StringBuilder res=new StringBuilder();
        for (Integer integer : integers) {
            res.append(integer);
        }
        return res.toString();
    }
*/


    //题解中的判断简单多了 判断 xy和yx谁大
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }

}
