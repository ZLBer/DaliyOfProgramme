package leetcode.leetcode1000_;

import java.util.Arrays;
import java.util.Comparator;

public class leet1288 {


    //mine  contest
    //先排序，那[a,b]中a相同的 b大的放前面
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });
     /*   for (int i = 0; i < intervals.length; i++) {
            System.out.println(intervals[i][0]+" "+intervals[i][1]);
        }*/


     int count=intervals.length;
        for (int i = 1; i < intervals.length; i++) {
            int begin=intervals[i][0];
            int end=intervals[i][1];
            for(int j=i-1;j>=0;j--){
                if(begin>=intervals[j][0]&&end<=intervals[j][1]){
                    count--;
                    break;
                }
            }
        }
        return count;
    }

  //看看人家的
    //因为第一个数一定是前边大后边小了，只比较后边即可
   /* public int removeCoveredIntervals(int[][] A) {
        int res = 0, right = 0;
        Arrays.sort(A, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for (int[] v : A) {
            //统计没被覆盖的，只有right大才不被覆盖
            if (v[1] > right) {
                ++res;
                right = v[1];
            }
        }
        return res;
    }*/
}
