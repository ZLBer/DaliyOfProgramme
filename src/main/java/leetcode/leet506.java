package leetcode;

import java.util.Arrays;

/**
 * Created by libin on 2019/2/27.
 */
public class leet506 {


    public String[] findRelativeRanks(int[] nums) {
        int[][] pair = new int[nums.length][2];
//重新定义数据结构，带序号和分数
        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
    //排序
        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));

        String[] result = new String[nums.length];
        //排名
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            }
            else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            }
            else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            }
            else {
                result[pair[i][1]] = (i + 1) + "";
            }
        }

        return result;
    }



   /* public String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        int max = 0;
        //找出最大值
        for (int i : nums) {
            if (i > max) max = i;
        }

        //定义一个超大数组
        int[] hash = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            //把序号填进去
            hash[nums[i]] = i + 1;
        }
        int place = 1;

        //从高到低依次遍历
        for (int i = hash.length - 1; i >= 0; i--) {
            if (hash[i] != 0) {
                if (place == 1) {
                    result[hash[i] - 1] = "Gold Medal";
                } else if (place == 2) {
                    result[hash[i] - 1] = "Silver Medal";
                } else if (place == 3) {
                    result[hash[i] - 1] = "Bronze Medal";
                } else {
                    result[hash[i] - 1] = String.valueOf(place);
                }
                place++;
            }
        }
        return result;
    }*/
}
