package leetcode.leetcode1000_1499;

import java.util.HashMap;
import java.util.Map;

public class leet1409 {
    //mine
    /*public int[] processQueries(int[] queries, int m) {
        int[] P = new int[m];
        for (int i = 0; i < m; i++) {
            P[i] = i + 1;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < m; j++) {
                if (P[j] == queries[i]) {
                    swap(P, j, P[j]);
                    res[i] = j;
                    break;
                }
            }
        }
        return res;

    }*/

    void swap(int[] nums, int i, int num) {
        for (int j = i; j > 0; j--) {
            nums[j] = nums[j - 1];
        }
        nums[0] = num;
    }


    //居然又可以树状数组
    //树状数组可以用作范围查询
    //自己一次写对 bingo
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        int[] bit = new int[m + n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            update(bit, n + i + 1, 1);
            map.put(i + 1, n + i + 1);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int oldIndex = map.get(queries[i]);
            res[i] = getSum(bit, oldIndex - 1);
            int newIndex = n - i;
            update(bit, oldIndex, -1);
            map.put(queries[i], newIndex);
            update(bit, newIndex, 1);
        }
        return res;
    }

    void update(int[] bit, int i, int val) {
        while (i < bit.length) {
            bit[i] += val;
            i += i & (-i);
        }
    }

    int getSum(int[] bit, int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & (-i);
        }
        return sum;
    }

}
