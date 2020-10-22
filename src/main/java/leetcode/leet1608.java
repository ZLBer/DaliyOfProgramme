package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet1608 {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int[] count=new int[nums[nums.length-1]+1];
        for (int i = 0; i < nums.length; i++) {
          count[nums[i]]++;
        }

       if(count[count.length-1]==count.length-1) return  count.length-1;
        for (int i = count.length - 2; i >= 0; i--) {
           count[i]+=count[i+1];
           if(count[i]==i) return i;
        }
        return -1;
    }




    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        System.out.println(ArrayList.class.getClassLoader());
    }
}
