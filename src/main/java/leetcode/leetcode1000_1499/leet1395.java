package leetcode.leetcode1000_1499;

import java.util.HashMap;
import java.util.Map;

public class leet1395 {

    //mine 分别统计左右两边大于的和小于的
/*    public int numTeams(int[] rating) {
        int[] smallLeft = new int[rating.length];
        int[] largeLeft = new int[rating.length];
        int[] smallRight = new int[rating.length];
        int[] largeRight = new int[rating.length];
        for (int i = 1; i < rating.length-1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (rating[j] < rating[i]) {
                    smallLeft[i]++;
                }
                if (rating[j] > rating[i]) {
                    largeLeft[i]++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < rating[i]) {
                    smallRight[i]++;
                }
                if (rating[j] > rating[i]) {
                    largeRight[i]++;
                }
            }
        }

        int res = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            res += smallLeft[i] * largeRight[i] + largeLeft[i] * smallRight[i];
        }
        return res;
    }*/

    //woc  一样的想法 看看人家的多简洁
    public int numTeams(int[] rating) {
        int res = 0;
        for (int i = 1; i < rating.length - 1; ++i) {
            int less[] = new int[2], greater[] = new int[2];
            for (int j = 0; j < rating.length; ++j) {
                if (rating[i] < rating[j])
                    ++less[j > i ? 1 : 0];
                if (rating[i] > rating[j])
                    ++greater[j > i ? 1 : 0];
            }
            res += less[0] * greater[1] + greater[0] * less[1];
        }
        return res;
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
    }

}
