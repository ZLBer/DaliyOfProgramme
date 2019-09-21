package leetcode.leetcode500_999;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2017/9/9.
 */
public class leet566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length*nums[1].length!=r*c)
            return nums;
        int [][]result=new int[r][c];
        List<Integer> array=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums[i].length;j++)
                array.add(nums[i][j]);
      int count=0;
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++) {
                result[i][j] = array.get(count);
                count++;
            }
        return result;
    }
}
