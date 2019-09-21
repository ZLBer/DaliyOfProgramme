package leetcode.leetcode1_499;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/1/19.
 */
public class leet406$ {
    //good idea
    public int[][] reconstructQueue(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            //按照先排身高，后排k的顺序进行排序
            public int compare(int[] o1, int[] o2) {
                //高的在前， k 小的在前
                return o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
